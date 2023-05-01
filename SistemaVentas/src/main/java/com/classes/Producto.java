
package com.classes;

import com.classes.Departamento;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioCosto;
    private double ganancia;
    private double mayoreo;
    private int ocupaInventario;
    private double cantidad;
    private int idDepartamento;

    public Producto(int ocupaInventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.cantidad = cantidad;
        this.idDepartamento = idDepartamento;
    }

    public Producto(String nombre, String descripcion, double precioCosto, double ganancia, double mayoreo, int ocupaInventario, double cantidad, int idDepartamento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.cantidad = cantidad;
        this.idDepartamento = idDepartamento;
    }

    public Producto(String codigo, String nombre, String descripcion, double precioCosto, double ganancia, double mayoreo, int ocupaInventario, double cantidad, int idDepartamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.cantidad = cantidad;
        this.idDepartamento = idDepartamento;
    }
    
    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getMayoreo() {
        return mayoreo;
    }

    public void setMayoreo(double mayoreo) {
        this.mayoreo = mayoreo;
    }

    public int getOcupaInventario() {
        return ocupaInventario;
    }

    public void setOcupaInventario(int ocupaInventario) {
        this.ocupaInventario = ocupaInventario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
