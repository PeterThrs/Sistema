package com.classes;

import javax.swing.JDialog;

public class Seguridad {
    private final String userAdmin = "admin"; 
    private final String passAdmin = "admin"; 
    
    private final String userCount = "counter"; 
    private final String passCount = "counter"; 
    
    private final String userCash = "cashier"; 
    private final String passCash = "cashier"; 
    
    private String user; 
    private String password; 
    
    public Seguridad(String user, String password){
        this.user = user; 
        this.password = password; 
    } 

    public String getUserAdmin() {
        return userAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public String getUserCount() {
        return userCount;
    }

    public String getPassCount() {
        return passCount;
    }

    public String getUserCash() {
        return userCash;
    }

    public String getPassCash() {
        return passCash;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    public boolean validar(){
        switch (user){
            case userAdmin: 
                return (password.equals(passAdmin)); 
            case userCount: 
                return (password.equals(passCount)); 
            case userCash: 
                return (password.equals(passCash)); 
        }
        return false; 
    }
    
    
}
