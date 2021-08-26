package sms.model;

import java.io.Serializable;

/**
 *
 * @author Douglas
 */
public class Classroom implements Serializable{
    
    private int classID;
    private String className;
    private String teacherID;

    public Classroom(){
        
    }
    
    public Classroom(String className){
        this.className = className;
    }
    
    public Classroom(int classID , String className){
        this.classID = classID;
        this.className = className;
    }
    
    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public int addElement(int classID){
        this.classID = classID;
        
        return classID;
    }
}
