
package sms.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sms.controller.AccademicsController;
import sms.controller.DashboardContoller;
import sms.controller.StudentController;

/**
 *
 * @author Douglas
 */
public class ViewTeacher implements ViewMaker{

    private Stage stage;
    private EventHandler<? super MouseEvent> handler;

    public ViewTeacher(Stage stage) {
        this.stage = stage;
    }
   
    @Override
    public Scene getScene() {
        
        BorderPane root = new BorderPane();
        
        GridPane TeacherReg = new GridPane();
        TeacherReg.setPadding(new Insets(20));
        TeacherReg.setHgap(30);
        TeacherReg.setVgap(20);
        
        Text staffInfo = new Text("Teacher Registraton");
        TeacherReg.setConstraints(staffInfo, 0, 0);
        
        Label stfNumb = new Label("staff ID:");
        TeacherReg.setConstraints(stfNumb, 0, 1);
           
        TextField staffNumbField = new TextField("");
        TeacherReg.setConstraints(staffNumbField, 0, 2);
        TeacherReg.setDisable(true);
        
        Label fname = new Label("First Name");
        TeacherReg.setConstraints(fname, 1, 1);
        
        TextField fnameField = new TextField("");
        TeacherReg.setConstraints(fnameField, 1, 2);
        
        
        
        Label mname = new Label("Middle Name");
        TeacherReg.setConstraints(mname, 2, 1);
        
        TextField mnameField = new TextField("");
        TeacherReg.setConstraints(mnameField, 2, 2);
        
        Label lname = new Label("Last Name");
        TeacherReg.setConstraints(lname, 3, 1);
        
        TextField lnameField = new TextField("");
        TeacherReg.setConstraints(lnameField, 3, 2);
        
        Label gender = new Label("Gender");
        TeacherReg.setConstraints(gender, 0, 3);
        
        TextField gendeSelect = new TextField("");
        TeacherReg.setConstraints(gendeSelect, 0, 4);
        
        Label d0B = new Label("Date of Birth");
        TeacherReg.setConstraints(d0B, 1, 3);
        
        DatePicker birthday = new DatePicker();
        birthday.setPromptText("Date of Birth");
        TeacherReg.setConstraints(birthday, 1, 4);
        
        Label email = new Label("email");
        TeacherReg.setConstraints(email, 2, 3);
        
        TextField emailField = new TextField("");
        TeacherReg.setConstraints(emailField, 2, 4);
        
        Label saddress = new Label("Address");
        TeacherReg.setConstraints(saddress, 3, 3);
        
        TextField saddressField = new TextField("");
        TeacherReg.setConstraints(saddressField, 3, 4);
        
        Label mobile = new Label("mobile");
        TeacherReg.setConstraints(mobile, 0, 5);
        
        TextField mobileField = new TextField("");
        TeacherReg.setConstraints(mobileField, 0, 6);
        
        Label staffs = new Label("Salary");
        TeacherReg.setConstraints(staffs, 1, 5);
        
        TextField salaryField = new TextField("");
        TeacherReg.setConstraints(salaryField, 1, 6);
        
        TeacherReg.getChildren().addAll(staffInfo, stfNumb, staffNumbField, fname, 
                fnameField, mname, mnameField, lname, lnameField, gender, gendeSelect, d0B, birthday,
                email, emailField, saddress, saddressField, mobile, mobileField, staffs, salaryField);
        
        HBox btBtn = new HBox();
        btBtn.setPadding(new Insets(0, 0, 40, 20));
        Button StaffCommit = new Button("Save");

        btBtn.getChildren().addAll(StaffCommit);
        
        VBox regSepB = new VBox();
        regSepB.setPadding(new Insets(30));
        regSepB.getChildren().addAll(TeacherReg, btBtn);
        
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
        
        Button FinanceSection = new Button("Finance");
        FinanceSection.setId("sideBtn");
        FinanceSection.setMinWidth(160);
        FinanceSection.setMinHeight(50);
        FinanceSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button examSection = new Button("Examination");
        examSection.setId("sideBtn");
        examSection.setMinWidth(160);
        examSection.setMinHeight(50);
        examSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));     

        sideBtn.getChildren().addAll(dashBtn, accademicSection, studentSection, staffSection, FinanceSection, examSection);
        
        root.setCenter(regSepB);
        root.setLeft(sideBtn);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/sms/css/sms.css");
        stage.setMaximized(false);
       
        return scene;
    }
    
}
