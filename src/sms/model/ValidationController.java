package sms.model;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Douglas
 */
public class ValidationController {
    
    public static boolean validateEmpty(TextField txt){
        
        if (txt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Managment");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All The Fields ...!");
            alert.showAndWait();
            
            return false;
        }
        
        return true;
    }
    
    public boolean validateNIC(TextField txt){
        if (txt.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")|| (txt.getText().isEmpty())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Managment");
            alert.setHeaderText(null);
            alert.setContentText("Invalid NIC Number ...!");
            alert.showAndWait();
            
            return false;
        }
        
    }
    
    public boolean numbersOnly(TextField txt){
        if(txt.getText().matches("[0-9]+")){
            return true;
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Managment");
            alert.setHeaderText(null);
            alert.setContentText("Invalid input type ...!");
            alert.showAndWait();
            
            return false;
        }
    }
    
    public boolean validationPhone(TextField txt){
        if(txt.getText().matches("^(\\d{10})")){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Managment");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Phone Number ...!");
            alert.showAndWait();
            
            return false;
        }
    }
    
    public boolean validateDate(TextField txt){
        if(txt.getText().matches("\\d{4}-\\d{2}-\\{2}")){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Managment");
            alert.setHeaderText(null);
            alert.setContentText("Invalid NIC Number ...!");
            alert.showAndWait();
            
            return false;
        }
    }
}
