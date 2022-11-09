/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.customer;

import java.io.Serializable;

/**
 *
 * @author minhd
 */
public class CustomerDTO implements Serializable {
    private String cusID;
    private String cusName;
    private String phoneNumber;
    private String mail;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String cusID, String cusName, String phoneNumber, String mail, String address) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
