/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import com.mysql.cj.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sms.Main;
import sms.db.Database;
import sms.db.StudentConnection;
import sms.model.Classroom;
import sms.model.SceneName;
import sms.model.Sessons;
import sms.model.Student;
import sms.view.AlertInfo;

/**
 *
 * @author Douglas
 */
public class StudentController {
    
        private Stage stage;
        
        private static AlertInfo alinfo = new AlertInfo();

        public StudentController(Stage stage){
            this.stage = stage;
        }
        
        public void handleMousePress(Event event){
            stage.setScene(Main.getScenes().get(SceneName.MAIN));
        }
        
        
        public void loadComboClass(ObservableList options) throws ClassNotFoundException, SQLException{
            options.clear();
            
            String sql = "SELECT * FROM classroom";
            
            Connection conn = Database.getDatabase().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        
            while(rs.next()){
                options.add(rs.getString("c_name"));
            }
        
            stm.close();
            rs.close(); 
        }
        
        public void loadComboLesson(ObservableList options) throws ClassNotFoundException, SQLException{
            options.clear();
            
            String sql = "SELECT * FROM lesson";
            
            Connection conn = Database.getDatabase().getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
        
            while(rs.next()){
                options.add(rs.getString("les_year"));
            }
        
            stm.close();
            rs.close(); 
        }
        
        public static Classroom comboSelect(Event event,  ComboBox txtCombo, String id) throws ClassNotFoundException, SQLException{
            
            String SQL = "SELECT * FROM classroom WHERE c_name = ? ";
            Connection conn = Database.getDatabase().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);

            int counter = 1;
            stm.setString(counter++, (String)txtCombo.getSelectionModel().getSelectedItem());
            ResultSet rs = stm.executeQuery();

            Classroom c = new Classroom();
            
            while(rs.next()){
               int idclass = rs.getInt("c_id");
               c.setClassID(idclass);
            }
            
            return c;
        }
        
        public static Sessons comboSelectLess(Event event,  ComboBox txtCombo, String id) throws ClassNotFoundException, SQLException{
            ObservableList options = FXCollections.observableArrayList();
            
            String SQL = "SELECT les_id FROM lesson WHERE les_year = ?";
            Connection conn = Database.getDatabase().getConnection();
            PreparedStatement stm = conn.prepareStatement(SQL);
            
            int counter = 1;
            stm.setString(counter++, id);
            ResultSet rs = stm.executeQuery();

            Sessons c = new Sessons();
            
            while(rs.next()){
               int idclass = rs.getInt("les_id");
               options.add(rs.getString("les_id"));
               c.setSessID(idclass);
            }
            
            System.out.println(c);
            
            return c;
        }
        
       
        
        public static void addStudents(Event event, TextField txtadNo, TextField txtfn, TextField txtmn, TextField txtln, TextField gendertxt, DatePicker dob, 
                 TextField emailtxt, TextField addresstxt, int classID, int lessonID) throws ClassNotFoundException, SQLException{
            
            
            //int sclass = grade.getValue().toInt();
//            int sclass = Integer.parseInt(adNoField.getText());
            
            
        }

    public void addStudents(ActionEvent e, TextField adNumbField, TextField fnameField, TextField mnameField, TextField lnameField, DatePicker birthday,
            TextField gendeSelect, TextField emailField, TextField saddressField, Sessons cIDe, Classroom lIDe) throws ClassNotFoundException, SQLException {
        adNumbField.setText(String.valueOf("SMS/ST/21" + new StudentConnection().idGenerator()));
        String stAdNO = adNumbField.getText();
            
        String stFirstName = fnameField.getText();
        String stmiddleName = mnameField.getText();
        String stlastName = lnameField.getText();
        String sgender = gendeSelect.getText();
        String doB = birthday.getValue().toString();
        String semail = emailField.getText();
        String saddress = saddressField.getText();
        
        Student st = new Student(stAdNO, stFirstName, stmiddleName, stlastName, sgender, doB, semail, saddress, cIDe, lIDe);
        int i = StudentConnection.addStudent(st);             
        if(i > 0) {
            alinfo.alertSuccess("STUDENT REGISTERD SUCCESSIFULLY.");
        }else{
            alinfo.alertError("STUDENT FAILED TO REGISTER .! ");
        }
    }
}
