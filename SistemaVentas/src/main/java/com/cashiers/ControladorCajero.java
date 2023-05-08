/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

import com.classes.Producto;
import com.conexion.ProductoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Root
 */
public class ControladorCajero {
    private Producto producto; 
    private ProductoDAO productoDao; 
    private VistaCajero vistaCajero;
    private List<Producto> productos; 
    private int codigoProducto; 
    
    public ControladorCajero(VistaCajero vistaCajero){
        this.vistaCajero = vistaCajero; 
        this.productoDao = new ProductoDAO(); 
        productos = new ArrayList<>(); 
    }
    
    public void recuperarCodigo()throws NumberFormatException{
       this.codigoProducto = Integer.parseInt(vistaCajero.gettCodigo().getText());
    }
    
    public void recuperarProducto(){
        producto = new Producto(this.codigoProducto); 
        productos = productoDao.seleccionar(); 
        producto = productos.stream().filter(p -> (p.getCodigo().equals(producto.getCodigo()))).findFirst().orElse(null);
    }
    
    public void productoExistente()throws Exception{
        if(producto == null){
            throw new Exception("Producto no encontrado"); 
        }
        
    }
    
}
