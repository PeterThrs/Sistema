package com.cashiers;

import com.classes.Producto;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Root
 */
public class Ticket {
    private List<Producto> productos; 
    private Date fecha; 
    private double total; 
    
    public Ticket(){
        this.total = 0; 
    }
    
    public void agregarProducto(Producto producto) {
        if(producto != null && producto.getExistencia() >= 0 && !existente(producto)){
            producto.aumentarTotalVender();
            producto.actualizar();
            productos.add(producto); 
        }
    }
    
    public void aumetarVentaProducto(Producto producto){
        if(producto != null && producto.getExistencia() > 0 && existente(producto)){
            producto.aumentarTotalVender();
            producto.actualizar();
        }
    }
    
    public void disminuirVentaProducto(Producto producto){
        if(producto != null && producto.getExistencia() > 0 && existente(producto)){
            producto.disminuirTotalVender();
            producto.actualizar();
        }
    }
    
    public Producto recuperarProducto(String codigo){
        Producto producto = null; 
        if(!codigo.isEmpty()){
            producto = productos.stream().filter( p -> (p.getCodigo().equals(codigo))).findFirst().orElse(null); 
        }
        return producto; 
    }
    
    public boolean existente(Producto producto) {
        return this.productos.stream().anyMatch( p -> (p.getCodigo().equals(producto.getCodigo()))); 
    }
    
    public void setFecha(){
        //this.fecha = new Date(); 
    }
    
    public void calcularTotal(){
        this.total = productos.stream().mapToDouble(Producto::getTotalVender).sum(); 
    }
    
    public double getTotal(){
        return this.total; 
    }
    
    
}
