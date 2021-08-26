package sms.controller;

import java.sql.SQLException;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import sms.Main;
import sms.db.DepartmentConnection;
import sms.model.*;


/**
 *
 * @author Douglas
 */
public class DepartmentController {
    
    private Stage stage;
    private static TextField dpnNameField;
    
    
    /** Must inject Stag
     * @param stage*/
    public DepartmentController(Stage stage){
        /*
        if(stage == null){
            throw new IllegalArgumentException("Stage cannot be null");
        }
        */
        
        this.stage = stage;
    }
    
    public DepartmentController(TextField dpnNameField){
        this.dpnNameField = dpnNameField;
    }
    
    public DepartmentController(){
        
    }
    
    /** Display main scene when the back button is click
     * @param event
     */
    public void handleMousePress(Event event){
        stage.setScene(Main.getScenes().get(SceneName.MAIN));
    }
    
    /*
    public static void alert(String title, String message, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        //alert.initOwner(owner);
        alert.show();
    }
    */
    
    /** inserting data into the database */
    
    /*
    public void register(ActionEvent event) throws SQLException {
        
        TextField departmentName = ViewDepartment.nameInput;
        
        if(departmentName.getText().isEmpty()){
            alert("Failed", "Text field can not be empty", Alert.AlertType.ERROR);
            return;
        }
        
        String deptName = departmentName.getText();
        
        Database DB = new Database();
        DB.insertRecord(deptName);
        
        alert("Save", "Welcome", Alert.AlertType.INFORMATION);
    }
    */
    
    
    public static void AddDepertment(Event event) throws ClassNotFoundException, SQLException{
        /*
        String testing = dpnNameField.getText();
        System.out.println(testing);
        
           */ 
        
            ValidationController v = new ValidationController();
            
            if(v.validateEmpty(dpnNameField)){
                String dpName = dpnNameField.getText();
                
                //DepartmentLogic d = new DepartmentLogic(dpName);
                //int i = DepartmentConnection.AddDepartment(d);
                int i = 0;
                if(i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Department");
                    alert.setHeaderText(null);
                    alert.setContentText("Department ID" + dpName + " Registered Sucessfully ..!");
                    alert.showAndWait();
                    
                    dpnNameField.setText(null);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Department");
                    alert.setHeaderText(null);
                    alert.setContentText("Ooops there is an error adding student ..!");
                    alert.showAndWait();
                }
            }
            
            
            
    }
    
}
