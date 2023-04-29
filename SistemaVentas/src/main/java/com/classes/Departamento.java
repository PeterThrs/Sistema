package com.classes;

public class Departamento {
    private int idDepartamento;
    private String nombre; 
    
    public Departamento(String nombre){
        this.nombre = nombre; 
    }

    public int getidDepartamento() {
        return idDepartamento;
    }

    public void setidDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public String getDepartamento() {
        return nombre;
    }

    public void setDepartamento(String nombre) {
        this.nombre = nombre;
    }
    
    
}
