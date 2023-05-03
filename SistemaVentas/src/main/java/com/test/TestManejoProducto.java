
package com.test;

import com.classes.Producto;
import com.conexion.ProductoDao;
import java.util.List;

public class TestManejoProducto {
    
     public static void main(String[] args) {
        System.out.println("Mostrando la relacion productos");
        ProductoDao productoDao = new ProductoDao();
        mostrarValores(productoDao);   
    }

    public static void mostrarValores(ProductoDao pd) {
        List<Producto> productos = pd.seleccionar();
        System.out.println("productos.isEmpty() = " + productos.isEmpty());
        productos.forEach(System.out::println);
        //imprimir(productos);
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
    
}
