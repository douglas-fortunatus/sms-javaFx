package sms.model;

/**
 *
 * @author Douglas
 */
public class Accademic {
    /** subject instance */
    private int subjectID;
    private String subjectName;
    
    /** department instance */
    private String departmentID;
    private String departmentName;
    
    /** exam instance */
    private String examID;
    private String examTypeID;
    private String examName;
    
    /** grade logic */
    private int gradeID;
    private String gradeName;
    private int noOfStudent;
    
    /** result */
    private int marks;
    
    /** Lesson logic*/
    public int sessID;
    public String sessName;

    public Accademic(int subjectID, String subjectName, String departmentID, String departmentName, String examID, String examTypeID, String examName, int gradeID, String gradeName, int noOfStudent, int marks, int sessID, String sessName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.examID = examID;
        this.examTypeID = examTypeID;
        this.examName = examName;
        this.gradeID = gradeID;
        this.gradeName = gradeName;
        this.noOfStudent = noOfStudent;
        this.marks = marks;
        this.sessID = sessID;
        this.sessName = sessName;
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

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getExamTypeID() {
        return examTypeID;
    }

    public void setExamTypeID(String examTypeID) {
        this.examTypeID = examTypeID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getSessID() {
        return sessID;
    }

    public void setSessID(int sessID) {
        this.sessID = sessID;
    }

    public String getSessName() {
        return sessName;
    }

    public void setSessName(String sessName) {
        this.sessName = sessName;
    }
}
