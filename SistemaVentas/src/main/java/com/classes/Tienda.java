/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;

public class Tienda {
    private int idTienda;
    private String nombre;
    private String slogan;
    private String telefono1;
    private String telefono2;
    private String email;
    private String mision;
    private String vision;
    private int codigoPostal;
    private String estado;
    private String municipio;
    private String colonia;
    private String calle;
    private int numCasa;

    public Tienda() {
    }

    public Tienda(int idTienda) {//Se puede ocupar para eliminar un registro
        this.idTienda = idTienda;
    }

    public Tienda(String nombre, String slogan, String telefono1, String telefono2, String email, String mision, String vision, int codigoPostal, String estado, String municipio, String colonia, String calle, int numCasa) {//No necesitamos la llave primaria para hacer un registro
        this.nombre = nombre;
        this.slogan = slogan;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.mision = mision;
        this.vision = vision;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numCasa = numCasa;
    }

    public Tienda(int idTienda, String nombre, String slogan, String telefono1, String telefono2, String email, String mision, String vision, int codigoPostal, String estado, String municipio, String colonia, String calle, int numCasa) {//PAra el caso de la modificación
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.slogan = slogan;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.mision = mision;
        this.vision = vision;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numCasa = numCasa;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public String toString() {
        return "Tienda{" + "idTienda=" + idTienda + ", nombre=" + nombre + ", slogan=" + slogan + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", email=" + email + ", mision=" + mision + ", vision=" + vision + ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", municipio=" + municipio + ", colonia=" + colonia + ", calle=" + calle + ", numCasa=" + numCasa + '}';
    }
    
}
