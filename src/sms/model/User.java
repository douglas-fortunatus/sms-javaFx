package sms.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Douglas
 */
public class User {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String Gender;
    private String dateOfBirth;
    private String email;
    private String Address;
    
    public User(String firstName, String middleName, String lastName, String gender, String dateOfBirth, String email, String address){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.Gender = gender;
        this.email = email;
        this.Address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
  
}
