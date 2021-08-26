package sms.view;

import java.sql.SQLException;
import java.util.logging.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import sms.controller.AccademicsController;
import sms.controller.DashboardContoller;
import sms.controller.StudentController;
import sms.model.Classroom;
import sms.model.Sessons;

/**
 *
 * @author Douglas
 */
public class ViewStudent implements ViewMaker{

     private Stage stage;
     private Sessons cIDe;
     private Classroom lIDe;
     private final ObservableList options = FXCollections.observableArrayList();
     private final ObservableList lessons = FXCollections.observableArrayList();
    
    public ViewStudent(Stage stage) {
        this.stage = stage;
    }

    
    @Override
    public Scene getScene() {
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(0 ,20, 0, 0));
        
        GridPane studentRegister = new GridPane();
        studentRegister.setPadding(new Insets(20));
        studentRegister.setHgap(30);
        studentRegister.setVgap(20);
        
        Text studentInfo = new Text("Student Registraton");
        studentRegister.setConstraints(studentInfo, 0, 0);
        
        Label adNumb = new Label("Admission Number:");
        studentRegister.setConstraints(adNumb, 0, 1);
           
        TextField adNumbField = new TextField("");
        studentRegister.setConstraints(adNumbField, 0, 2);
        adNumbField.setDisable(true);
        
        Label fname = new Label("First Name");
        studentRegister.setConstraints(fname, 1, 1);
        
        TextField fnameField = new TextField("");
        studentRegister.setConstraints(fnameField, 1, 2);
        
        Label mname = new Label("Middle Name");
        studentRegister.setConstraints(mname, 2, 1);
        
        TextField mnameField = new TextField("");
        studentRegister.setConstraints(mnameField, 2, 2);
        
        Label lname = new Label("Last Name");
        studentRegister.setConstraints(lname, 3, 1);
        
        TextField lnameField = new TextField("");
        studentRegister.setConstraints(lnameField, 3, 2);
        
        Label gender = new Label("Gender");
        studentRegister.setConstraints(gender, 0, 3);
        
        TextField gendeSelect = new TextField("");
        studentRegister.setConstraints(gendeSelect, 0, 4);
        
        Label d0B = new Label("Date of Birth");
        studentRegister.setConstraints(d0B, 1, 3);
        
        DatePicker birthday = new DatePicker();
        birthday.setPromptText("Date of Birth");
        studentRegister.setConstraints(birthday, 1, 4);
        
        Label email = new Label("email");
        studentRegister.setConstraints(email, 2, 3);
        
        TextField emailField = new TextField("");
        studentRegister.setConstraints(emailField, 2, 4);
        
        Label saddress = new Label("Address");
        studentRegister.setConstraints(saddress, 3, 3);
        
        TextField saddressField = new TextField("");
        studentRegister.setConstraints(saddressField, 3, 4);
        
        Label classroom = new Label("Class");
        studentRegister.setConstraints(classroom, 0, 5);
        
        try {
             //TextField classSelect = new TextField("");
             new StudentController(stage).loadComboClass(options);
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ComboBox classSelect = new ComboBox(options);
        studentRegister.setConstraints(classSelect, 0, 6);
        classSelect.setPromptText("Class");
        
        classSelect.setOnAction(e -> {
            try {
                lIDe = new StudentController(stage).comboSelect(e, classSelect, (String)classSelect.getSelectionModel().getSelectedItem());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Label section = new Label("Lesson");
        studentRegister.setConstraints(section, 1, 5);
        
        try {
             new StudentController(stage).loadComboLesson(lessons);
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ComboBox lessonSelect = new ComboBox(lessons);
        studentRegister.setConstraints(lessonSelect, 1, 6);
        lessonSelect.setPromptText("Session");
        
        lessonSelect.setOnAction(e -> {
            try {
                cIDe = new StudentController(stage).comboSelectLess(e, classSelect, (String)lessonSelect.getSelectionModel().getSelectedItem());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        studentRegister.getChildren().addAll(studentInfo, adNumb, adNumbField, fname, 
                fnameField, mname, mnameField, lname, lnameField, gender, gendeSelect, d0B, birthday,
                classroom, classSelect, email, emailField, saddress, saddressField, lessonSelect);
        
        HBox btBtn = new HBox();
        btBtn.setPadding(new Insets(0, 0, 40, 20));
        Button StudentCommit = new Button("Save");
        
        StudentCommit.setOnAction(e -> {
            try {
                System.out.println(cIDe);
                System.out.println(lIDe);
                new StudentController(stage).addStudents(e, adNumbField, fnameField, mnameField, lnameField ,birthday , gendeSelect, emailField, saddressField, cIDe, lIDe);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btBtn.getChildren().addAll(StudentCommit);
        
        VBox regSepB = new VBox();
        regSepB.setPadding(new Insets(30));
        regSepB.getChildren().addAll(studentRegister, btBtn);

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
        studentSection.setId("sideBtnA");
        studentSection.setMinWidth(160);
        studentSection.setMinHeight(50);
        studentSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button staffSection = new Button("Staff");
        staffSection.setId("sideBtn");
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
