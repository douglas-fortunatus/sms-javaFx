package sms.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Douglas
 */
public class Student extends User{
    
    private String adNo;
    private Sessons gradeClass;
    private Classroom lesson;
    private int feesPaid;
    private int fessTotal;  
    
    
//    public Student(String adN0, String firstName, String middleName, String lastName, String gender, String email, String mobile, String address, String gradeClass) {
//        
//        super(firstName, middleName, lastName, gender, email, mobile, address);
//        this.feesPaid = 0;
//        this.fessTotal = 1700000;
//        this.adNo = adN0;
//        this.gradeClass = gradeClass;
//    }


//    public int getFeesPaid() {
//        return feesPaid;
//    }
//
//    public int getFessTotal() { 
//        return fessTotal;
//    }
//
//    public void setGradeClass(String gradeClass) {
//        this.gradeClass = gradeClass;
//    }
//
//    /** adding fees when paid by the student
//     * @param fees */
//    public void updateFeesPaid(int fees){
//        feesPaid += fees;
//    }

    

    public Student(String adNo, String firstName, String middleName, String lastName, String gender, String dateOfBirth, String email,
            String address, Sessons gradeClass, Classroom lesson) {
        super(firstName, middleName, lastName, gender, dateOfBirth, email, address);
        
        this.adNo = adNo;
        this.gradeClass = gradeClass;
        this.lesson = lesson;
    }

    public String getAdNo() {
        return adNo;
    }

    public Sessons getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(Sessons gradeClass) {
        this.gradeClass = gradeClass;
    }

    public Classroom getLesson() {
        return lesson;
    }

    public void setLesson(Classroom lesson) {
        this.lesson = lesson;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(int feesPaid) {
        this.feesPaid = feesPaid;
    }

    public int getFessTotal() {
        return fessTotal;
    }

    public void setFessTotal(int fessTotal) {
        this.fessTotal = fessTotal;
    }
   
}
