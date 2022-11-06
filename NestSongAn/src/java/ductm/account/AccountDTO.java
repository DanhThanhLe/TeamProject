/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.account;

/**
 *
 * @author HP
 */
public class AccountDTO {
    private String ID;
    private String username;
    private String password;
    private String fullName;
    private String mail;
    private String role;
    private String phone;

    public AccountDTO(String ID, String username, String password, String fullName, String mail, String role, String phone) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mail = mail;
        this.role = role;
        this.phone = phone;
    }

    public AccountDTO() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
