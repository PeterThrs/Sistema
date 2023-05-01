package com.test;

import com.classes.Persona;
import com.conexion.PersonaDao;
import java.util.List;

public class TestManejoPersona {

    public static void main(String[] args) {
        //PersonaDAO pd = new PersonaDAO();
        //mostrarValores(pd);

        //insertar persona
//        Persona p1 = new Persona("Marcos", "Doe", "Sul", "mdoe@gmail.com", "9511234323", "1233421234", 20, "HOPE123423HOCPRDA3", "ASDFQW13AS", "M", 68000, "Oaxaca", "Oaxaca", "Oaxaca", "Oaxaca", 130);
//        int registros = pd.insertar(p1);
//        System.out.println("registros = " + registros);
//        mostrarValores(pd);

        //modificar persona
//        Persona p3 = new Persona(4,"Marcos", "Doe", "Roe", "mdoe@gmail.com", "9511234323", "1233421234", 20, "HOPE123423HOCPRDA3", "ASDFQW13AS", "M", 68270, "Chiapas", "Chiapas", "Chiapas", "Chiapas", 130);
//        int registros = pd.actualizar(p3);
//        System.out.println("registros = " + registros);
//        mostrarValores(pd);

        //eliminar Persona 
//        Persona p4 = new Persona(1);
//        Persona p5 = new PersonaDao().seleccionIndividual(p4);
//        //int registros = pd.eliminar(p4);
//        System.out.println("encontramos a "+p5);
//        //mostrarValores(pd);   

         Persona p = PersonaDao.traerUltimo();
         System.out.println("el ultimo es "+p.getIdPersona());
    }

    public static void mostrarValores(PersonaDao pd) {
        List<Persona> personas = pd.seleccionar();
        imprimir(personas);
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
}
