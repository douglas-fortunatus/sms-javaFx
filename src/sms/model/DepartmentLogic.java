package sms.model;

/**
 *
 * @author Douglas
 */
public class DepartmentLogic {
    
    private String departmentID;
    private String departmentName;
    
    public DepartmentLogic(){
        
    }
    
    public DepartmentLogic(String departmentID){
        this.departmentID = departmentID;
    }
    
    public DepartmentLogic(String departmentID, String departmentName){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
