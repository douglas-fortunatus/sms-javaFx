package sms.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sms.controller.AccademicsController;
import sms.controller.DashboardContoller;

/**
 *
 * @author Douglas
 */
public class ViewStaff implements ViewMaker{

    private Stage stage;
    
    @Override
    public Scene getScene() {
        
        BorderPane root = new BorderPane();
        
        root.setPadding(new Insets(0 ,20, 0, 0));
        
        VBox sideBtn = new VBox();
        sideBtn.setSpacing(0);
        sideBtn.setPadding(new Insets(0));
        //sideBtn.setMargin(new Insets(0));
        sideBtn.setId("sideBar");
        
        Button dashBtn = new Button("Home");
        dashBtn.setId("sideBtn");
        dashBtn.setMinWidth(160);
        dashBtn.setMinHeight(50);
        dashBtn.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button accademicSection = new Button("Accademic");
        accademicSection.setId("sideBtn");
        accademicSection.setMinWidth(160);
        accademicSection.setMinHeight(50);
        accademicSection.setOnAction(e -> new DashboardContoller(stage).handleOnPressdStudent(e));
        
        Button studentSection = new Button("Student");
        studentSection.setId("sideBtn");
        studentSection.setMinWidth(160);
        studentSection.setMinHeight(50);
        studentSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button staffSection = new Button("Staff");
        staffSection.setId("sideBtnA");
        staffSection.setMinWidth(160);
        staffSection.setMinHeight(50);
        staffSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button attendanceSection = new Button("Attandance");
        attendanceSection.setId("sideBtn");
        attendanceSection.setMinWidth(160);
        attendanceSection.setMinHeight(50);
        attendanceSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button examSection = new Button("Examination");
        examSection.setId("sideBtn");
        examSection.setMinWidth(160);
        examSection.setMinHeight(50);
        examSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));     

        sideBtn.getChildren().addAll(dashBtn, accademicSection, studentSection, staffSection, attendanceSection, examSection);
        
        root.setLeft(sideBtn);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/sms/css/sms.css");
        stage.setMaximized(false);
        
        return scene;
    }   
}
