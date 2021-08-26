package sms.view;

import java.sql.SQLException;
import java.util.logging.*;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sms.controller.AccademicsController;
import sms.controller.DashboardContoller;
import sms.model.*;

/**
 *
 * @author Douglas
 */
public class ViewAccademics implements ViewMaker{
    
    private Stage stage;
    
    public ViewAccademics(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Scene getScene() {
        
        /** 
         * Department Section 
         */
        VBox gridSeparat = new VBox();
        gridSeparat.setSpacing(20);
        
        GridPane gridDepartments = new GridPane();
        gridDepartments.setPadding(new Insets(0, 10, 10, 10));
        gridDepartments.setVgap(10);
        gridDepartments.setHgap(20);
        
        Label labelDepartmentID = new Label("Department ID");
        gridDepartments.setConstraints(labelDepartmentID, 0, 0);       
        TextField departmentIdField = new TextField(""); 
        departmentIdField.setDisable(true);
        gridDepartments.setConstraints(departmentIdField, 1, 0);       
        Label labelDepartmentName = new Label("Department Name");
        gridDepartments.setConstraints(labelDepartmentName, 0, 1);        
        TextField departmentNameField = new TextField("");
        gridDepartments.setConstraints(departmentNameField, 1, 1);
        
        TableView <DepartmentLogic> departTable = new TableView<>();
        departTable.setEditable(false);
        TableColumn<DepartmentLogic, String> dNameColumn = new TableColumn<>("Department Name");
        dNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        dNameColumn.setMinWidth(300);
         
        Button newDepartmentBtn = new Button("_New");
        newDepartmentBtn.setMaxSize(100, 300);
        Button SaveDepartmentBtn = new Button("_Save");
        SaveDepartmentBtn.setMaxSize(100, 300);
        Button updateDepartmentBtn = new Button("_Update");
        updateDepartmentBtn.setMaxSize(100, 300);      
        Button deleteDepartmentBtn = new Button("_Delete");
        deleteDepartmentBtn.setMaxSize(100, 300);   
        
        departTable.getColumns ().addAll(dNameColumn);
        
        VBox vboxDepartBtn = new VBox();
        vboxDepartBtn.getChildren().addAll(newDepartmentBtn, SaveDepartmentBtn, updateDepartmentBtn, deleteDepartmentBtn);
        vboxDepartBtn.setSpacing(20);
        
        gridDepartments.getChildren().addAll(labelDepartmentID, departmentIdField, labelDepartmentName, departmentNameField);
        
        HBox hboxDepartment = new HBox();
        hboxDepartment.setPadding(new Insets(20, 10, 20, 10));
        hboxDepartment.setSpacing(40);
        hboxDepartment.getChildren().addAll(gridDepartments,vboxDepartBtn ,departTable);
        
        try {
            departTable.setItems(new AccademicsController(stage).getDepartment(departTable));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        departTable.setOnMouseClicked( e -> {
            try {
                SaveDepartmentBtn.setDisable(true);
                new AccademicsController(stage).onTableClick(e, departTable, departmentIdField, departmentNameField);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        newDepartmentBtn.setOnAction( e -> new AccademicsController(stage).clearField(e, departmentIdField, departmentNameField));

        SaveDepartmentBtn.setOnAction(e -> {
            try {
                new AccademicsController(stage).AddDepartment(e, departmentIdField, departmentNameField, departTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        updateDepartmentBtn.setOnAction( e -> {
            try {
                SaveDepartmentBtn.setDisable(false);
                new AccademicsController(stage).updateDepartment(e, departmentIdField, departmentNameField, departTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        deleteDepartmentBtn.setOnAction( e -> {
            try {
                SaveDepartmentBtn.setDisable(false);
                new AccademicsController(stage).deleteDepartment(e, departmentIdField, departmentNameField, departTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        /** 
         * Subject section 
         */
        
        VBox gridSubjectSeparat = new VBox();
        gridSubjectSeparat.setSpacing(20);
        
        GridPane gridSubjects = new GridPane();
        gridSubjects.setPadding(new Insets(0, 10, 10, 10));
        gridSubjects.setVgap(10);
        gridSubjects.setHgap(20);
        
        
        Label labelSubjectName = new Label("Subject Name");
        gridSubjects.setConstraints(labelSubjectName, 0, 0); 
        
        TextField subjectNameField = new TextField("");
        gridSubjects.setConstraints(subjectNameField, 1, 0);
        
        Label labelSubjectCategory = new Label("Subjct Category");
        gridSubjects.setConstraints(labelSubjectCategory, 0, 1);
        
        TextField catIDField = new TextField("");
        gridSubjects.setConstraints(catIDField, 1, 2);
        catIDField.setDisable(true);
        
        ObservableList<DepartmentLogic> option =  FXCollections.observableArrayList();
        try {
            new AccademicsController(stage).getDepartCombo(option);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComboBox subjectCategoty = new ComboBox(option);
        subjectCategoty.setOnAction(e -> {
            try {
                new AccademicsController(stage).comboSelect(e, subjectCategoty, catIDField);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        subjectCategoty.setPromptText("Category");
        gridSubjects.setConstraints(subjectCategoty, 1, 1);
        
        gridSubjects.getChildren().addAll(labelSubjectName, subjectNameField, labelSubjectCategory, subjectCategoty, catIDField);
              
        Button newSubjectBtn = new Button("_New");
        newSubjectBtn.setMaxSize(100, 300);
        Button subjectCommit = new Button("_Save");
        subjectCommit.setMaxSize(100, 300);
        Button updateSubjectBtn = new Button("_Update");
        updateSubjectBtn.setMaxSize(100, 300);      
        Button deleteSubjectBtn = new Button("_Delete");
        deleteSubjectBtn.setMaxSize(100, 300);
 
        VBox vboxSubjectBtn = new VBox();
        vboxSubjectBtn.getChildren().addAll(newSubjectBtn, subjectCommit, updateSubjectBtn, deleteSubjectBtn);
        vboxSubjectBtn.setSpacing(20);
        
        TableView <SubjectLogic> SubjectTable = new TableView();
        
        TableColumn<SubjectLogic, String> subjectNameColumn = new TableColumn<>("Subject Name");
        subjectNameColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        subjectNameColumn.setMinWidth(300);
        
        SubjectTable.getColumns ().addAll(subjectNameColumn);
        
        HBox hboxSubjects = new HBox();
        hboxSubjects.setPadding(new Insets(20, 10, 20, 10));
        hboxSubjects.setSpacing(40);
        hboxSubjects.getChildren().addAll(gridSubjects,vboxSubjectBtn, SubjectTable);
        
        SubjectTable.setEditable(false);
        
        try {
            SubjectTable.setItems(new AccademicsController(stage).getSubject(SubjectTable));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SubjectTable.setOnMouseClicked( e -> {
            try {
                SaveDepartmentBtn.setDisable(true);
                new AccademicsController(stage).onTableClickSubject(e, SubjectTable, subjectNameField);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        newSubjectBtn.setOnAction(e -> new AccademicsController(stage).clearFieldSubject(e, subjectNameField, subjectCategoty, catIDField));
                
        subjectCommit.setOnAction(e -> {
            try {
                new AccademicsController(stage).AddSubject(e, subjectNameField, catIDField, SubjectTable);
                subjectCategoty.setValue(null);
                catIDField.setText(null);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
       updateSubjectBtn.setOnAction( e -> {
           try {
                new AccademicsController(stage).updateSubject(e, subjectNameField, SubjectTable);
           } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        deleteSubjectBtn.setOnAction( e -> {
            try {
                new AccademicsController(stage).deleteSubject(e, subjectNameField,  SubjectTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 
        
        /** 
         * 
         * class section 
         */
        
        VBox gridClassSeparat = new VBox();
        gridClassSeparat.setSpacing(20);
      
        GridPane gridClass = new GridPane();
        gridClass.setPadding(new Insets(30, 10, 10, 30));
        gridClass.setVgap(10);
        gridClass.setHgap(20);
        
        Label labelClassID = new Label("Class ID");
        gridClass.setConstraints(labelClassID, 0, 0);       
        TextField classIdField = new TextField(""); 
        classIdField.setDisable(true);
        gridClass.setConstraints(classIdField, 1, 0);       
        Label labelClassName = new Label("Class Name");
        gridClass.setConstraints(labelClassName, 0, 1);        
        TextField classNameField = new TextField("");
        gridClass.setConstraints(classNameField, 1, 1);
        
        gridClass.getChildren().addAll(labelClassID, classIdField, labelClassName, classNameField);
                
        Button newClassBtn = new Button("_New");
        newClassBtn.setMaxSize(100, 300);
        Button commitClassBtn = new Button("_Save");
        commitClassBtn.setMaxSize(100, 300);
        Button updateClassBtn = new Button("_Update");
        updateClassBtn.setMaxSize(100, 300);      
        Button deleteClassBtn = new Button("_Delete");
        deleteClassBtn.setMaxSize(100, 300);
        
        VBox vboxClassBtn = new VBox();
        vboxClassBtn.getChildren().addAll(newClassBtn, commitClassBtn, updateClassBtn, deleteClassBtn);
        vboxClassBtn.setSpacing(20);
        
        TableView <Classroom> classTable = new TableView();
        classTable.setEditable(false);
        TableColumn<Classroom, String> classroomNameColumn = new TableColumn<>("Classroom Name");
        classroomNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        classroomNameColumn.setMinWidth(300);
        
        classTable.getColumns ().addAll(classroomNameColumn);
        
        HBox hboxClass = new HBox();
        hboxClass.setPadding(new Insets(20, 10, 20, 10));
        hboxClass.setSpacing(40);
        hboxClass.getChildren().addAll(gridClass,vboxClassBtn, classTable);
        
        classTable.setEditable(false);
        
        try {
            classTable.setItems(new AccademicsController(stage).getClassroom(classTable));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        classTable.setOnMouseClicked( e -> {
            try {
                SaveDepartmentBtn.setDisable(true);
                new AccademicsController(stage).onTableClickClass(e, classTable, classIdField, classNameField);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        newClassBtn.setOnAction(e -> new AccademicsController(stage).clearField(e, classIdField, classNameField));
                
        commitClassBtn.setOnAction(e -> {
            try {
                new AccademicsController(stage).AddClassroom(e, classNameField, classTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        updateClassBtn.setOnAction( e -> {
            try {
                new AccademicsController(stage).updateClassroom(e, classIdField, classNameField, classTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        deleteClassBtn.setOnAction( e -> {
            try {
                new AccademicsController(stage).deleteClassroom(e, classIdField, classNameField,  classTable);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ViewAccademics.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         /** 
         * 
         * Tabs design section 
         */        
        
        TabPane tabPaneDept = new TabPane();
        tabPaneDept.setPadding(new Insets(20));
        
        Tab tabSubjects = new Tab("Subjects");
        Tab tabDepartment = new Tab("Department");
        Tab tabClassroom = new Tab ("Classes");
        
        tabPaneDept.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPaneDept.getTabs().addAll(tabClassroom, tabDepartment, tabSubjects);
         
        tabSubjects.setContent(hboxSubjects);
        tabDepartment.setContent(hboxDepartment);
        tabClassroom.setContent(hboxClass);
        
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
        accademicSection.setId("sideBtnA");
        accademicSection.setMinWidth(160);
        accademicSection.setMinHeight(50);
        accademicSection.setOnAction(e -> new DashboardContoller(stage).handleOnPressdStudent(e));
        
        Button studentSection = new Button("Student");
        studentSection.setId("sideBtn");
        studentSection.setMinWidth(160);
        studentSection.setMinHeight(50);
        studentSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button staffSection = new Button("Staff");
        staffSection.setId("sideBtn");
        staffSection.setMinWidth(160);
        staffSection.setMinHeight(50);
        staffSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button financeSection = new Button("Finance");
        financeSection.setId("sideBtn");
        financeSection.setMinWidth(160);
        financeSection.setMinHeight(50);
        financeSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));
        
        Button examSection = new Button("Examination");
        examSection.setId("sideBtn");
        examSection.setMinWidth(160);
        examSection.setMinHeight(50);
        examSection.setOnAction(e -> new AccademicsController(stage).dashboardScene(e));     

        sideBtn.getChildren().addAll(dashBtn, accademicSection, studentSection, staffSection, financeSection, examSection);
        
        root.setLeft(sideBtn);
        root.setCenter(tabPaneDept);
     
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/sms/css/sms.css");
        stage.setResizable(false);
       
        return scene;
    }
    
    
}
