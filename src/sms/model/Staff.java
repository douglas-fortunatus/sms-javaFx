package sms.model;

import java.time.LocalDate;

/**
 * keeping track of the teachers record.
 * @author Douglas
 */
public class Staff extends User{
    
    private String teacherID;
    private int salary;

    public Staff(String firstName, String middleName, String lastName, String gender, String dateOfBirth, String email, String address) {
        super(firstName, middleName, lastName, gender, dateOfBirth, email, address);
    }

//    public Staff(String firstName, String middleName, String lastName, String gender, LocalDate dateOfBirth, String email, String address) {
//        super(firstName, middleName, lastName, gender, dateOfBirth, email, address);
//    }
    
//    public Staff(String teacherID, String firstName, String middleName, String lastName, String gender, String email, String mobile, String address, int salary) {
//        super(firstName, middleName, lastName, gender, email, mobile, address);
//        this.teacherID = teacherID;
//        this.salary = salary;
//    }

    public String getTeacherID() {
        return teacherID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    
}
