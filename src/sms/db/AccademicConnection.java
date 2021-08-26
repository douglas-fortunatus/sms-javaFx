package sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sms.model.Classroom;
import sms.model.DepartmentLogic;
import sms.model.SubjectLogic;

/**
 *
 * @author Douglas
 */
public class AccademicConnection {
    
    /** Generating random id
     * @param txt
     * @return  */
    public static long idGenerator(){
        long idNumber;
        Random idRandom = new Random();
        idNumber = idRandom.nextInt(100);
        
        return idNumber;
    }
    
    /** Department Section */
    public static int AddDepartment(DepartmentLogic department) throws ClassNotFoundException,SQLException{
        String SQL = "INSERT INTO department(departmentID, departmentName) VALUE (?,?)";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, department.getDepartmentID());
        stm.setObject(2, department.getDepartmentName());
        
        return stm.executeUpdate();
    }
     
    public static int deleteDepartment(String departmentID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM department WHERE departmentID = '" + departmentID + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
   
    public static int updateDepartment(DepartmentLogic department) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE department SET departmentID= ? ,departmentName= ? WHERE departmentID= '" +department.getDepartmentID()+ "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, department.getDepartmentID());
        stm.setObject(2, department.getDepartmentName());

        return  stm.executeUpdate();
    }
    
    public static boolean departmentExists(String tName) throws SQLException, ClassNotFoundException{
        ObservableList<DepartmentLogic> departments = FXCollections.observableArrayList();
        
        String sql = "SELECT departmentID, departmentName FROM department WHERE departmentName = ? ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        int counter = 1;
        stm.setString(counter++, tName);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            DepartmentLogic fn = new DepartmentLogic();
            fn.setDepartmentID(rs.getString(1));
            fn.setDepartmentName(rs.getString(2));
            departments.add(fn);
        }
        
        if (null != stm){
            stm.close();
        }else if(null != conn){
            conn.close();
        }
        
        //return !departments.isEmpty();
        return departments.isEmpty() ? false : true;
    }
    
    
    
    
    public static int AddClassroom(Classroom classroom) throws ClassNotFoundException,SQLException{
        String SQL = "INSERT INTO classroom(c_name) VALUE (?)";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, classroom.getClassName());
        
        return stm.executeUpdate();
    }
    
    public static int deleteClassroom(String classID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM classroom WHERE c_id = '" + classID + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
    
    public static int updateClassroom(Classroom classroom) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE classroom SET c_id = ? , c_name= ? WHERE c-id = '" + classroom.getClassID() + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, classroom.getClassName());

        return  stm.executeUpdate();
    }
    
    public static int AddSubject(SubjectLogic subject) throws ClassNotFoundException,SQLException{
        String SQL = "INSERT INTO subject(sub_name, department) VALUE (?, ?)";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, subject.getSubjectName());
        stm.setObject(2, subject.getDepartmentId());
        
        return stm.executeUpdate();
    }
    
    public static int deleteSubject(String subName) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM subject WHERE sub_name = '" + subName + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
    
    public static int updateSubject(SubjectLogic subject) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE subject SET sub_name= ? WHERE sub_name = '" + subject.getSubjectName() + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, subject.getSubjectName());

        return  stm.executeUpdate();
    }
}
