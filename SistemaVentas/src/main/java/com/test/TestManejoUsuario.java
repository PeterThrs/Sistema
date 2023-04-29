/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

import com.classes.Usuario;
import com.conexion.UsuarioDAO;
import java.util.List;

public class TestManejoUsuario {
      UsuarioDAO ud = new UsuarioDAO();
        //mostrarValores(ud);

        //insertar usuario
//        Usuario u1 = new Usuario("Adriel", "admin", "01", "contador", "aqui q numero va??");
//        int registros = ud.insertar(u1);
//        System.out.println("registros = " + registros);
//        mostrarValores(ud);

        //modificar usuario
//        Usuario u3 = new Usuario(5,"Adriel", "admin", "01", "contador", "Que numero va??");
//        int registros = ud.actualizar(u3);
//        System.out.println("registros = " + registros);
//        mostrarValores(ud);

        //eliminar usuario
        Usuario u4 = new Usuario(4);
        //int registros = ud.eliminar(u4);
        //System.out.println("registros = " + registros);
        //mostrarValores(ud);

    public static void mostrarValores(UsuarioDAO ud) {
        List<Usuario> usuarios = ud.seleccionar();
        imprimir(usuarios);
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
}