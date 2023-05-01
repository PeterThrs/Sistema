package com.test;

import com.classes.Tienda;
import com.conexion.TiendaDao;
import java.util.List;


public class TestManejoTiendas {
    public static void main(String[] args){
        TiendaDao tiendaDAO = new TiendaDao();
        
//        Insertando un nuevo objeto de tipo Tienda
//        Tienda tiendaNueva = new Tienda("Oxxo","Slogan de prueba","9951064922","9951064922","juanjolr6@gmail.com","Mision de prueba","Vision de prueba",70770,"Chiapas","Santiago Astata","Av. Independencia","Calle Yucatan",8);
//        TiendaDAO.insertar(tiendaNueva);
        
//        //Modificar un objeto d etienda existente
//        Tienda tiendaModificar = new Tienda(3, "Oxxo","Slogan modificadooo","9951064922","9951064922","juanjolr6@gmail.com","Mision de prueba","Vision de prueba",70770,"Chiapas","Santiago Astata","Av. Independencia","Calle Yucatan",8);
//        TiendaDAO.actualizar(tiendaModificar);
        
        //Eliminar un registro
        Tienda tiendaEliminar = new Tienda(3);
        TiendaDao.eliminar(tiendaEliminar);
        
        //Listado Tiendas
        List<Tienda> tiendas = tiendaDAO.seleccionar();
        
        tiendas.forEach(tienda ->
        {
            System.out.println("tienda = "+tienda);
        });
    }
}
