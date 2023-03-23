/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;
import javax.swing.ImageIcon;
/**
 *
 * @author juanj
 */
public class Tienda {
    private String name;
    private String slogan;
    private String adress;
    private int numberPhone;
    private String email;
    private ImageIcon logo;

    public Tienda(String name, String slogan, String adress, int numberPhone, String email, ImageIcon logo) {
        this.name = name;
        this.slogan = slogan;
        this.adress = adress;
        this.numberPhone = numberPhone;
        this.email = email;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }
    
}
