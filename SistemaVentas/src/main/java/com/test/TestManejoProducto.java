
package com.test;

/**
 *
 * @author corte
 */

import com.classes.Producto;
import com.conexion.ProductoDAO;
import java.util.List;

public class TestManejoProducto {
    
     public static void main(String[] args) {
        
        //eliminar Producto 
        
        Producto p4 = new Producto(1);
        Producto p5 = new ProductoDAO().seleccionIndividual(p4);
        //int registros = pd.eliminar(p4);
        System.out.println("encontramos a "+p5);
        //mostrarValores(pd);   
    }

    public static void mostrarValores(ProductoDAO pd) {
        List<Producto> productos = pd.seleccionar();
        imprimir(productos);
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
    
}
