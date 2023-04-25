package com.conexion;

import com.classes.Persona;
import java.util.List;

public class PruebaPersona {
    public static void main(String[] args) {
        PersonaDao pd = new PersonaDao(); 
        List<Persona> personas = pd.seleccionar();
        imprimir(personas);
    }
    
    public static<T extends List> void imprimir(T t){
        t.forEach(e -> {
            System.out.println(e);
        });
    }
}
