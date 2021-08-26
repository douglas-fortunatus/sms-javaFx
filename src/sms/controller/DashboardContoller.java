package sms.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import sms.Main;
import sms.model.SceneName;

/**
 *
 * @author Douglas
 */
public class DashboardContoller {
    
    private Stage stage;
    
    public DashboardContoller(Stage stage){
        this.stage = stage;
    }
    
    public void handleOnPressedButtonAccademics(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.ACCADEMICS));
    }
     
    public void handleOnPressdStudent(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.STUDENT));
    }
    
    public void handleOnPressdStaff(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.STAFF));
    }
    
    public void handleOnPressdExam(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.EXAM));
    }
    
    public void handleOnPressdFinance(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.FINANCE));
    }
    
    public void handleOnPressdAttend(MouseEvent event){
        stage.setScene(Main.getScenes().get(SceneName.ATTEND));
    }
    
    
    
//    public ObservableList<Department> getDepartment(){
//        ObservableList<Department> departments = FXCollections.observableArrayList();
//        departments.add(new DepartmentLogic( "1", "Science"));
//        departments.add(new DepartmentLogic( "2", "Arts"));
//        departments.add(new DepartmentLogic( "3", "Econmics"));
//        departments.add(new DepartmentLogic( "4", "Information Technology"));
//        
//        return departments;
//    }

    public void handleOnPressdStudent(ActionEvent e) {
       stage.setScene(Main.getScenes().get(SceneName.STUDENT)); 
    }
}
