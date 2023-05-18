/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classes;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Usuario {
    private int idUsuario;
    private InputStream imagen;
    private String nomUsuario;
    private String contrasenia;
    private int idPersona;
    private int idRol;
    
    public Usuario() {
    }

    public Usuario(int idUsuario) {//Se puede ocupar para eliminar un registro
        this.idUsuario = idUsuario;
    }

    public Usuario(InputStream imagen, String nombreUsuario, String contrasenia, int idPersona, int idRol) {//No necesitamos la llave primaria para hacer un registro
        this.imagen = imagen;
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }
    
    public Usuario(int idUsuario, InputStream imagen, String nombreUsuario, String contrasenia, int idPersona, int idRol) {//PAra el caso de la modificación
        this.idUsuario = idUsuario;
        this.imagen = imagen;
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
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
