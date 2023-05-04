/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;

public class Usuario {
    private int idUsuario;
    private String nomUsuario;
    private String contrasenia;
    private int idPersona;
    private int idRol;
    
    public Usuario() {
    }

    public Usuario(int idUsuario) {//Se puede ocupar para eliminar un registro
        this.idUsuario = idUsuario;
    }

    public Usuario(String nombreUsuario, String contrasenia, int idPersona, int idRol) {//No necesitamos la llave primaria para hacer un registro
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }
    
    public Usuario(int idUsuario, String nombreUsuario, String contrasenia, int idPersona, int idRol) {//PAra el caso de la modificación
        this.idUsuario = idUsuario;
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", Nombre=" + nomUsuario + ", Contraseña=" + contrasenia + ", IdPersona=" + idPersona + ", IdRol=" + idRol + '}';
    }
}
