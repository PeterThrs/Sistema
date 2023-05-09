
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
    private double stock;
    private int idDepartamento;
    
    //atributos para poder manejar el apartado de ventas
    private int totalVender; 
    private static int vender; 
    private double importe; 
    private double precioFinal; 
    private int existencia; 
    
    public Producto(){}; 

    public Producto(int ocupaInventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.stock = stock;
        this.idDepartamento = idDepartamento;
        
        this.vender = 0; 
        this.totalVender = this.vender; 
        this.importe = 0; 
        this.precioFinal = 0; 
        this.existencia = 0; 
    }

    public Producto(String nombre, String descripcion, double precioCosto, double ganancia, double mayoreo, int ocupaInventario, double cantidad, int idDepartamento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCosto = precioCosto;
        this.ganancia = ganancia;
        this.mayoreo = mayoreo;
        this.ocupaInventario = ocupaInventario;
        this.stock = cantidad;
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
        this.stock = cantidad;
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
        return stock;
    }

    public void setCantidad(double cantidad) {
        this.stock = cantidad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    //para poder manejar el aparatado de ventas

    public int getTotalVender() {
        return totalVender;
    }

    public void setTotalVender(int totalVender) {
        this.totalVender = totalVender;
    }

    public double getImporte() {
        return importe;
    }
    public double getPrecioFinal() {
        return precioFinal;
    }
    
    public void aumentarTotalVender(){
        this.vender++; 
        this.totalVender = vender; 
        System.out.println("totalVender = " + totalVender);
    }
    
    public void disminuirTotalVender(){
        this.vender--; 
        this.totalVender = vender; 
        System.out.println("totalVender = " + totalVender);
    }

    public void actualizar(){
        calcularPrecioFinal(); 
        calcularImporte();
        calcularExistente(); 
    }
    
    public void calcularPrecioFinal(){
        this.precioFinal = this.getPrecioCosto() + (this.getPrecioCosto() * (this.getGanancia() / 100));
        System.out.println("precioFinal = " + precioFinal);
    }
    
    public void calcularImporte() {
        this.importe = this.getPrecioFinal() * this.getTotalVender();
        System.out.println("importe = " + importe);
    }
    
    public void calcularExistente() {
      existencia = (int)this.getCantidad() - this.getTotalVender();
        System.out.println("existencias = " + existencia);
    }

    public int getExistencia() {
        return existencia;
    }
    
    public void setVender(int vender){
        this.vender = vender;
    }
    
    public int getVender(){
        return this.vender; 
    }

    @Override
    public String toString() {
        return "Producto{" + "cant=" + totalVender + ", importe=" + importe + ", precioFinal=" + precioFinal + ", existencia=" + existencia + '}';
    }
    
    

}
