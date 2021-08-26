package sms.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//school package files
import sms.controller.DashboardContoller;

/**
 * Creates and returns the scene {@link  Main}
 * @author Douglas
 */
public class Dashboard implements ViewMaker{
    
    private Stage stage;
    
    public Dashboard(Stage stage){
        this.stage = stage; 
    }

    @Override
    public Scene getScene() {
        
        //injecting stage from main into controller
        DashboardContoller controller = new DashboardContoller(stage);
        
        /** Build scene */
        BorderPane root = new BorderPane();

        GridPane dashGrid = new GridPane();
        dashGrid.setPadding(new Insets(30, 50, 30, 50));
        dashGrid.setVgap(50);
        dashGrid.setHgap(60);
        
        Image imageA = new Image("/sms/icons/school.png");       
        ImageView imageAccademics = new ImageView(imageA);
        imageAccademics.setFitHeight(124);
        imageAccademics.setFitWidth(126);
        imageAccademics.setPreserveRatio(true);
        
        Button accademicsBtn = new Button("Accademics");
        accademicsBtn.setId("dashBtn");
        accademicsBtn.setMaxWidth(130);
        accademicsBtn.setOnMousePressed(e -> controller.handleOnPressedButtonAccademics(e));
       
        VBox accademicsVbox = new VBox();
        accademicsVbox.setPadding(new Insets(10,0,0,0));
        accademicsVbox.setSpacing(10);
        accademicsVbox.getChildren().addAll(imageAccademics, accademicsBtn);
        
        Image imageM = new Image("/sms/icons/man.png");       
        ImageView imageStudent = new ImageView(imageM);
        imageStudent.setFitHeight(124);
        imageStudent.setFitWidth(126);
        imageStudent.setPreserveRatio(true);
        
        Button studentInfo = new Button("Students");
        studentInfo.setId("dashBtn");
        studentInfo.setMaxWidth(130);
        studentInfo.setOnMousePressed(e -> controller.handleOnPressdStudent(e));
        
        VBox studentVbox = new VBox();
        studentVbox.setPadding(new Insets(10,0,0,0));
        studentVbox.setSpacing(10);
        studentVbox.getChildren().addAll(imageStudent, studentInfo);
        dashGrid.setConstraints(studentVbox, 1, 0);
        
        
        Image imageT = new Image("/sms/icons/profile.png");       
        ImageView imageStaff = new ImageView(imageT);
        imageStaff.setFitHeight(124);
        imageStaff.setFitWidth(126);
        imageStaff.setPreserveRatio(true);
        
        Button staffBtn = new Button("Staff");
        staffBtn.setId("dashBtn");
        staffBtn.setMaxWidth(130);
        staffBtn.setOnMousePressed(e -> controller.handleOnPressdStaff(e));
        
        VBox staffVbox = new VBox();
        staffVbox.setPadding(new Insets(10,0,0,0));
        staffVbox.setSpacing(10);
        staffVbox.getChildren().addAll(imageStaff, staffBtn);
        dashGrid.setConstraints(staffVbox, 2, 0);
        
        Image imageAT = new Image("/sms/icons/approve.png");       
        ImageView imageAttandance = new ImageView(imageAT);
        imageAttandance.setFitHeight(124);
        imageAttandance.setFitWidth(126);
        imageAttandance.setPreserveRatio(true);
        
        Button attBtn = new Button("Attendance");
        attBtn.setId("dashBtn");
        attBtn.setMaxWidth(130);
        attBtn.setOnMousePressed(e -> controller.handleOnPressdAttend(e));
        
        VBox attandanceVbox = new VBox();
        attandanceVbox.setPadding(new Insets(10,0,0,0));
        attandanceVbox.setSpacing(10);
        attandanceVbox.getChildren().addAll(imageAttandance, attBtn);
        dashGrid.setConstraints(attandanceVbox, 0, 1);
        
        Image imageE = new Image("/sms/icons/economics.png");       
        ImageView imageEcon = new ImageView(imageE);
        imageEcon.setFitHeight(124);
        imageEcon.setFitWidth(126);
        imageEcon.setPreserveRatio(true);
        
        Button feeInfo = new Button("Finance");
        feeInfo.setId("dashBtn");
        feeInfo.setMaxWidth(130);
        feeInfo.setOnMousePressed(e -> controller.handleOnPressdFinance(e));
        
        VBox finaceVbox = new VBox();
        finaceVbox.setPadding(new Insets(10,0,0,0));
        finaceVbox.setSpacing(10);
        finaceVbox.getChildren().addAll(imageEcon, feeInfo);
        dashGrid.setConstraints(finaceVbox, 1, 1);
        
        Image imageB = new Image("/sms/icons/choose.png");       
        ImageView imageBooks = new ImageView(imageB);
        imageBooks.setFitHeight(124);
        imageBooks.setFitWidth(126);
        imageBooks.setPreserveRatio(true);
        
        Button examInfo = new Button("Examinatoin");
        examInfo.setId("dashBtn");
        examInfo.setMaxWidth(130);
        examInfo.setOnMousePressed(e -> controller.handleOnPressdExam(e));
        
        VBox examVbox = new VBox();
        examVbox.setPadding(new Insets(10,0,0,0));
        examVbox.setSpacing(10);
        examVbox.getChildren().addAll(imageBooks, examInfo);
        dashGrid.setConstraints(examVbox, 2, 1);
        
        dashGrid.getChildren().addAll(accademicsVbox, studentVbox, staffVbox, attandanceVbox, finaceVbox, examVbox);

        root.setCenter(dashGrid);
       
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/sms/css/sms.css");
        stage.setMaximized(false);
       
        return scene;
    }
}
