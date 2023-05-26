package com.classes;

import java.io.FileInputStream;
import javax.swing.ImageIcon;

public class Usuario {
    private int idUsuario;
    private FileInputStream imagen;
    private ImageIcon icono;
    private String nomUsuario;
    private String contrasenia;
    private int idPersona;
    private int idRol;
    private int status;
    
    public Usuario() {
    }

    public Usuario(int idUsuario) {//Se puede ocupar para eliminar un registro
        this.idUsuario = idUsuario;
    }

    public Usuario(int status, FileInputStream imagen, String nombreUsuario, String contrasenia, int idPersona, int idRol) {//No necesitamos la llave primaria para hacer un registro
        this.status=status;
        this.imagen = imagen;
        this.icono = icono;
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }
    
    public Usuario(int idUsuario, int status, ImageIcon icono, String nombreUsuario, String contrasenia, int idPersona, int idRol) {//PAra el caso de la modificación
        this.idUsuario = idUsuario;
        this.status = status;
        this.icono = icono;
        this.imagen = imagen;
        this.nomUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.idRol = idRol;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }
    
    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", Nombre=" + nomUsuario + ", Contraseña=" + contrasenia + ", IdPersona=" + idPersona + ", IdRol=" + idRol + '}';
    }
}
