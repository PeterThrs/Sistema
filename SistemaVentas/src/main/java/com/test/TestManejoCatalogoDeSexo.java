
package com.test;

import com.classes.CatalogoDeSexo;
import com.conexion.CatalogoDeSexoDAO;
import java.util.List;

public class TestManejoCatalogoDeSexo {
    public static void main(String[] args) {
        
        //eliminar CatalogoDeSexo
        
        CatalogoDeSexo p4 = new CatalogoDeSexo(1);
        CatalogoDeSexo p5 = new CatalogoDeSexoDAO().seleccionIndividual(p4);
        //int registros = pd.eliminar(p4);
        System.out.println("encontramos a "+p5);
        //mostrarValores(pd);   
    }

    public static void mostrarValores(CatalogoDeSexoDAO pd) {
        List<CatalogoDeSexo> personas = pd.seleccionar();
        imprimir(personas);
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
}
