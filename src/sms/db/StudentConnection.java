package sms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import sms.model.Student;

/**
 *
 * @author Douglas
 */
public class StudentConnection {
    
    /** Generating random id
     * @param txt
     * @return  */
    public static long idGenerator(){
        long idNumber;
        Random idRandom = new Random();
        idNumber = idRandom.nextInt(10000);
        
        return idNumber;
    }
    
    /** Department Section */
    
    public static int addStudent(Student student) throws ClassNotFoundException,SQLException{
       
        String sql ="INSERT INTO student(st_adNo, st_fname, st_mname, st_lname, st_gender, st_email, Date_of_Birth, st_address, c_id, les_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFirstName());
        stm.setObject(3, student.getMiddleName());
        stm.setObject(4, student.getLastName());
        stm.setObject(5, student.getGender());
        stm.setObject(6, student.getEmail());
        stm.setObject(7, student.getDateOfBirth());
        stm.setObject(8, student.getAddress());
        stm.setObject(9, student.getGradeClass());
        stm.setObject(10, student.getLesson());
         
        //stm.setObject(0, stm);
        
        return stm.executeUpdate();
    }
     
//    public static int deleteStudent(String studentID) throws ClassNotFoundException, SQLException {
//        String sql = "DELETE FROM student WHERE st_id = '" + studentID + "'";
//        Connection conn = Database.getDatabase().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//
//        return  stm.executeUpdate();
//    }
//   
//    public static int updateStudent(Student student) throws ClassNotFoundException, SQLException {
//        String sql = "UPDATE student SET st_id = ?, parent = ?, st_adNo = ?, st_fname = ?, st_mname = ?, st_lname = ? WHERE st_id = '" + student.getStudentID() + "'";
//        Connection conn = Database.getDatabase().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1, student.getStudentID());
//        stm.setObject(2, student.getParentID());
//        stm.setObject(3, student.getAdNo());
//        stm.setObject(4, student.getFirstName());
//        stm.setObject(5, student.getMiddleName());
//        stm.setObject(6, student.getLastName());
//
//        return  stm.executeUpdate();
//    }
//    
    
}
