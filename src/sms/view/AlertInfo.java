package sms.view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Alert info
 * @author Douglas
 */
public class AlertInfo {
    
    public static boolean deleteConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("School Managment");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete?");
        Optional <ButtonType> action = alert.showAndWait();
        
        if(action.get() == ButtonType.OK){
            return true;
        }
        
        return false;
    }
    
    public static String alertSuccess(String sms){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("School Managment");
        alert.setHeaderText(null);
        alert.setContentText(sms);
        alert.showAndWait();
        
        return sms;
    }
    
    public static String alertError(String sms){
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("School Managment");
        alert.setHeaderText(null);
        alert.setContentText(sms);
        alert.showAndWait();
        
        return sms;
    }
}
