/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

import com.classes.Producto;

/**
 *
 * @author Root
 */
public class prueba {
    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.setCodigo("12345"); 
        producto.setNombre("champu");
        producto.setDescripcion("descripcion");
        producto.setPrecioCosto(5);
        producto.setMayoreo(7); 
        producto.setCantidad(5);
        
        System.out.println("producto = " + producto); 
        System.out.println("Compramos un producto");
        //producto.modificarProducto(1);
        System.out.println("producto = " + producto);
        System.out.println("Compramos otro producto");
        //producto.modificarProducto(1);
        System.out.println("producto = " + producto);
        
    }
}
