package sms.controller;

import java.sql.*;
import javafx.collections.*;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sms.Main;
import sms.db.AccademicConnection;
import sms.db.Database;
import sms.model.*;
import sms.view.AlertInfo;

/**
 *
 * @author Douglas
 */
public class AccademicsController {
    
    private Stage stage;

//   private static ObservableList<Classroom> classroomData = FXCollections.observableArrayList();
//    private static ObservableList<SubjectLogic> subjectData = FXCollections.observableArrayList();
//   private static ObservableList options = FXCollections.observableArrayList();
//    private static DepartmentLogic department;
    
    private static AlertInfo alinfo = new AlertInfo();
    private static ValidationController v = new ValidationController();
    
    public void dashboardScene(Event event){
        stage.setScene(Main.getScenes().get(SceneName.MAIN));
    }
    
    /** 
     * Must inject Stag
     * @param stage*/
    public AccademicsController(Stage stage){
        this.stage = stage;
    }
    
    /** 
     * Display scene when the button is click
     * @param event
     */
    public void handleMousePress(Event event){
        stage.setScene(Main.getScenes().get(SceneName.MAIN));
    }
        
    /** 
     * DEPARTMENT SECTION
     * Loading data to the table
     * @param table
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static ObservableList<DepartmentLogic> getDepartment(TableView table) throws ClassNotFoundException, SQLException{
        
        ObservableList<DepartmentLogic> departmentData = FXCollections.observableArrayList();
        departmentData.clear();
        
        String SQL = "SELECT * from department";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            departmentData.add(new DepartmentLogic(rs.getString("departmentID"), rs.getString("departmentName")));
            table.setItems(departmentData);
        }
        
        return departmentData;
    }
    
    /** on click on the table event
     * @param event
     * @param table
     * @param txt
     * @param txt2
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static void onTableClick(Event event, TableView table, TextField txt, TextField txt2) throws ClassNotFoundException, SQLException{
        DepartmentLogic depart = (DepartmentLogic)table.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM department WHERE departmentID = ? ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, depart.getDepartmentID());
        ResultSet rst = stm.executeQuery();
                
        if(rst.next()){
            txt.setText(rst.getString("departmentID"));
            txt2.setText(rst.getString("departmentName"));
        }
        stm.close();
        rst.close();
    }
    
    /** Adding department data
     * @param event 
     * @param txtId 
     * @param txtName 
     * @param table 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException */ 
    public static void AddDepartment(Event event, TextField txtId, TextField txtName, TableView table) throws ClassNotFoundException, SQLException{              
        if(v.validateEmpty(txtName)){
            txtId.setText(String.valueOf(new AccademicConnection().idGenerator()));
            
            String departName = txtName.getText(); 
            
            if(!AccademicConnection.departmentExists(departName)){ 
                String departID = "D-" + txtId.getText();
                DepartmentLogic d = new DepartmentLogic(departID, departName);
                int i = AccademicConnection.AddDepartment(d); 
                if(i > 0) {
                    getDepartment(table);
                    alinfo.alertSuccess("DEPARTMENT REGISTERD SUCCESSIFULLY.");

                    txtName.setText(null);
                    txtId.setText(null);
                }else{
                    alinfo.alertError("ERROR ADDING DEPARTMENT!");
                }
            }else{
                alinfo.alertError("ERROR DEPARTMENT EXISTS!");
            }
            
        }
    }
    
    /** updating department
     * @param event
     * @param txtid
     * @param txtname
     * @param table
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static void updateDepartment(Event event, TextField txtid, TextField txtname, TableView table) throws ClassNotFoundException, SQLException{
        
        if(v.validateEmpty(txtname)){
            String dID = txtid.getText();
            String dName = txtname.getText();
            
            DepartmentLogic dl = new DepartmentLogic(dID, dName);
            int i = AccademicConnection.updateDepartment(dl);
            if(i > 0){
                getDepartment(table);
                alinfo.alertSuccess("DEPARTMENT UPDATED SUCCESSFULLY.");
 
                txtid.setText(null);
                txtname.setText(null);
            }
        }
    }

    /** Deleting Department
     * @param event
     * @param txtid
     * @param txtname
     * @param table
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static void deleteDepartment(Event event, TextField txtid, TextField txtname, TableView table) throws ClassNotFoundException, SQLException{
        String dpID = txtid.getText();
        String dpName = txtname.getText();
        
        DepartmentLogic dl = new DepartmentLogic(dpID, dpName);
        int i = AccademicConnection.deleteDepartment(dpID);
        
        if(alinfo.deleteConfirmation() == true){
            if (i > 0) {
                getDepartment(table);
                alinfo.alertSuccess("DEPARTMENT DELETED.");

                txtid.setText(null);
                txtname.setText(null);
            } else {
                alinfo.alertError("FAILD TO DELETE DEPARTMENT");
            }
        }
    }
    
    /** 
     * clear fields departmenT
     * @param event
     * @param id
     * @param name
     */
    public static void clearField(Event event, TextField id, TextField name){
        id.setText(null);
        name.setText(null);
    }
    
    /** 
     * CLASSROOM SECTION
     * Loading data to the class table
     * @param table
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static ObservableList<Classroom> getClassroom(TableView table) throws ClassNotFoundException, SQLException{
        ObservableList<Classroom> classroomData = FXCollections.observableArrayList();
        classroomData.clear();
        
        String SQL = "SELECT * from classroom ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            classroomData.add(new Classroom(rs.getInt("c_id"), rs.getString("c_name")));
            table.setItems(classroomData);
        }
        
        return classroomData;
    }
    
    /** on click on the table event */
    public static void onTableClickClass(Event event, TableView table, TextField txt, TextField txt2) throws ClassNotFoundException, SQLException{
        Classroom co = (Classroom)table.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM classroom WHERE c_id = ? ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, co.getClassID());
        ResultSet rst=stm.executeQuery();
                
        if(rst.next()){
            txt.setText(rst.getString("c_id"));
            txt2.setText(rst.getString("c_name"));
        }
                
        stm.close();
        rst.close();
    }
    
    /** Adding classroom data
     * @param event 
     * @param txtName 
     * @param table 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException */ 
    public static void AddClassroom(Event event, TextField txtName, TableView table) throws ClassNotFoundException, SQLException{
            
        if(v.validateEmpty(txtName)){ 
            String departName = txtName.getText(); 
                
            Classroom cl = new Classroom(departName);
            int i = AccademicConnection.AddClassroom(cl);
              
            if(i > 0) {
                getClassroom(table);
                alinfo.alertSuccess("CLASSROOM NAME REGISTERD SUCCESSIFULLY ..!");
                    
                txtName.setText(null);
            }else{
                alinfo.alertError("Ooops THE IS AN ERROR ADDING CLASSROOM ..!");
            }
        }
    }

    /** updating classroom
     * @param event */
    public static void updateClassroom(Event event, TextField id, TextField name, TableView table) throws ClassNotFoundException, SQLException{
        
        ValidationController v = new ValidationController();
        if(v.validateEmpty(name)){
            int cID = Integer.parseInt(id.getText());
            //String cID = id.getText();
            String cName = name.getText();
            
            Classroom cl = new Classroom(cID, cName);
            int i = AccademicConnection.updateClassroom(cl);
            
            if(i > 0){
                getClassroom(table);
                alinfo.alertSuccess("Class Updated Successfully..!");

                id.setText(null);
                name.setText(null);
            }
        }
    }

    /** Deleting classroom */
    public static void deleteClassroom(Event event, TextField id, TextField name, TableView table) throws ClassNotFoundException, SQLException{
        String cID = id.getText();
        
        Classroom dl = new Classroom(Integer.parseInt(id.getText()), name.getText());
        int i = AccademicConnection.deleteClassroom(cID);
        
        if (i > 0) {
            getClassroom(table);
            alinfo.alertSuccess("Department has been deleted sucessfully..!");

            id.setText(null);
            name.setText(null);
        } else {
            alinfo.alertError("There is an error deleting Department");
        }
    }

    
    /** 
     * SUBJECT SECTION
     * Loading data to the subject table
     * @param table
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static ObservableList<SubjectLogic> getSubject(TableView table) throws ClassNotFoundException, SQLException{
        ObservableList<SubjectLogic> subjectData = FXCollections.observableArrayList();
        subjectData.clear();
        
        String SQL = "SELECT * from subject";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            subjectData.add(new SubjectLogic(rs.getString("sub_name")));
            table.setItems(subjectData);
        }
        
        return subjectData;
    }
    
    /** 
     * on click on the table event
     * @param event
     * @param table
     * @param txt
     * @param txt2
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static void onTableClickSubject(Event event, TableView table, TextField txt) throws ClassNotFoundException, SQLException{
        SubjectLogic sub = (SubjectLogic)table.getSelectionModel().getSelectedItem();
        String sql = "SELECT * FROM subject WHERE sub_name = ? ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, sub.getSubjectName());
        ResultSet rst=stm.executeQuery();
                
        if(rst.next()){
            txt.setText(rst.getString("sub_name"));
        }
                
        stm.close();
        rst.close();
    }
    
    public static void comboSelect(Event event,  ComboBox txtCombo, TextField txt) throws ClassNotFoundException, SQLException{
        ObservableList options = FXCollections.observableArrayList();
        
        String SQL = "SELECT departmentID FROM department WHERE departmentName = ? ";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        
        int counter = 1;
        stm.setString(counter++, (String)txtCombo.getSelectionModel().getSelectedItem());
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            txt.setText(rs.getString("departmentID"));
            options.add(rs.getString("departmentID"));
        }  
    }
    
    public static void clearFieldSubject(Event event, TextField id, ComboBox com, TextField name){
        name.setText(null);
        com.setValue(null);
        id.setText(null);
    }
    
    /** Adding subject data
     * @param event 
     * @param txtName 
     * @param txtdId 
     * @param table 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.sql.SQLException */ 
    public static void AddSubject(Event event, TextField txtName, TextField txtdId, TableView table) throws ClassNotFoundException, SQLException{
           
        if(v.validateEmpty(txtName)){
            String subName = txtName.getText();
            String dId = txtdId.getText();
            
            SubjectLogic sub = new SubjectLogic(subName, dId);
            int i = AccademicConnection.AddSubject(sub);
              
            if(i > 0) {
                getSubject(table);
                alinfo.alertSuccess("SUBJECT REGISTERD SUCCESSIFULLY ..!");
                    
                txtName.setText(null);
            }else{
                alinfo.alertSuccess("ERROR UPDATING SUBJECT");
            }
        }
    }

    /** updating department */
    public static void updateSubject(Event event, TextField name, TableView table) throws ClassNotFoundException, SQLException{
        if(v.validateEmpty(name)){
            String cName = name.getText();
            
            SubjectLogic sub = new SubjectLogic(cName);
            int i = AccademicConnection.updateSubject(sub);
            
            if(i > 0){
                getSubject(table);
                alinfo.alertSuccess("Subject Updated Successfully..!");

                name.setText(null);
            }
        }
    }

    /** Deleting subject */
    public static void deleteSubject(Event event, TextField name, TableView table) throws ClassNotFoundException, SQLException{      
        String subID = name.getText();
        
        SubjectLogic subdel = new SubjectLogic(name.getText());
        int i = AccademicConnection.deleteSubject(subID);
        
        if(AlertInfo.deleteConfirmation() == true){
            if (i > 0) {
                getSubject(table);
                alinfo.alertSuccess("Subject deleted");

                name.setText(null);
            } else {
                alinfo.alertError("Subject not deleted");
            }
        }   
    }

    /** combo box loading items
     * @param options
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public static ObservableList<DepartmentLogic> getDepartCombo(ObservableList options) throws ClassNotFoundException, SQLException{
        options.clear();
        
        String SQL = "SELECT departmentName from department";
        Connection conn = Database.getDatabase().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            options.add(rs.getString("departmentName"));
        }
        
        stm.close();
        rs.close(); 
        
        return options;
    }

}
