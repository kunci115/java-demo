package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class KaryawanDTO {

    @NotEmpty(message="Nip is required")
    @Size(min=3, max=5, message="nip length must be 3 to 5")
    private String NIP;

    @NotEmpty(message="First Name is required")
    private String firstName;

    @NotEmpty(message="last Name is required")
    private String lastName;

    @NotEmpty(message="address Name is required")
    private String address;

    @NotEmpty(message="phonenumber Name is required")
    private String phoneNumber;

    @Email(message="Invalid email address format")
    private String emailAddress;

    public KaryawanDTO() {

    }


    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public KaryawanDTO(String NIP, String firstName, String lastName, String address,
                       String phoneNumber, String email){
        this.NIP = NIP;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = email;
    }

}
