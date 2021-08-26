package sms.model;

/**
 *
 * @author Douglas
 */
public class SubjectLogic{
    
    private int subjectID;
    private String subjectName;
    private String departmentId;
    
    public SubjectLogic(String subjectName, String departmentId){
        //super(departmentID);
        this.subjectName = subjectName;
        this.departmentId = departmentId;
    }
    
    public SubjectLogic(String subjectName){
        this.subjectName = subjectName;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
}
