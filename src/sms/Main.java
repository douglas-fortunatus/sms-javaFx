package sms;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import sms.model.SceneName;
import sms.view.*;

/**
 *
 * @author Douglas
 */
public class Main extends Application {
    
    /** holding the various scenes to switch between */
    private static Map<SceneName, Scene> scenes= new HashMap<>();
    
    @Override
    public void start(Stage stage) {
        
        //Storing all scenes infront
        scenes.put(SceneName.MAIN, new Dashboard(stage).getScene());
        scenes.put(SceneName.ACCADEMICS, new ViewAccademics(stage).getScene());
        scenes.put(SceneName.STUDENT, new ViewStudent(stage).getScene());
        scenes.put(SceneName.STAFF, new ViewTeacher(stage).getScene());
        scenes.put(SceneName.ATTEND, new ViewAttandance(stage).getScene());
        scenes.put(SceneName.EXAM, new ViewExam(stage).getScene());
        scenes.put(SceneName.FINANCE, new ViewFinance(stage).getScene());
        
        //starting with the main scene
        stage.setScene(scenes.get(SceneName.MAIN));
        stage.setTitle("School Managment System");
        stage.getIcons().add(new Image("/sms/icons/s-favicon.png"));
        stage.show();
    }
    
    /** 
     * Returns a Map of the scenes by {@link SceneName
     * @return }
     */
    public static Map<SceneName, Scene> getScenes(){
        return scenes;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
