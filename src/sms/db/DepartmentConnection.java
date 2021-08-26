package sms.db;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sms.model.*;

/**
 *
 * @author Douglas
 * @project school Management System
 */

public class DepartmentConnection {
    
    private ObservableList<ObservableList> data;
    
    public static int AddDepartment(DepartmentLogic department) throws ClassNotFoundException,SQLException{
        String SQL = "INSERT INTO department(departmentID, departmentName) VALUE (?, ?)";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        //stm.setObject(1, department.getName());
        
        return stm.executeUpdate();
    }
    
    public static int deleteStudent(String dpID) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM department WHERE dpID ='" + dpID + "'";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        return stm.executeUpdate();
    }
    
    public void pullData() throws SQLException, ClassNotFoundException{
        
        data = FXCollections.observableArrayList();
        
        //SQL FOR SELECTING ALL OF DEPARTMENTS
        String SQL = "SELECT * FROM department";
        
        //RESULT SET
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        ResultSet tableNames = stm.executeQuery();
        System.out.println("Table query successful");
        while(tableNames.next()){
            TableView table = new TableView();
            String columnQuery = "PARAGNA table_info(" + tableNames.getString("name") + ")";
            
            try(PreparedStatement columnQueryPS = conn.prepareStatement(columnQuery)){
                //ResultSet columnData = dataQueryPS.executeQuery();
            }
            
            //String dataQuery = "SELECT " + columnNames.getString("dpName");
        }
    }
}
