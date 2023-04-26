package com.test;

import com.classes.Tienda;
import com.conexion.TiendaDAO;
import java.util.List;


public class TestManejoPersonas {
    public static void main(String[] args){
        TiendaDAO tiendaDAO = new TiendaDAO();
        
        //Insertando un nuevo objeto de tipo Tienda
        Tienda tiendaNueva = new Tienda("Oxxo","Slogan de prueba","9951064922","9951064922","juanjolr6@gmail.com","Mision de prueba","Vision de prueba",70770,"Chiapas","Santiago Astata","Av. Independencia","Calle Yucatan",8);
        TiendaDAO.insertar(tiendaNueva);
        
        List<Tienda> tiendas = tiendaDAO.seleccionar();
        /*for(Tienda tienda : tiendas){
            System.out.println("tienda = "+tienda);
        }*/
        tiendas.forEach(tienda ->
        {
            System.out.println("tienda = "+tienda);
        });
    }
}
