/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

import com.conexion.Conexion;
import com.conexion.CuentasDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoUsuario {
      //UsuarioDao ud = new UsuarioDao();
        //mostrarValores(ud);

        //insertar usuario
//        Usuario u1 = new Usuario("Adriel", "admin", "01", "contador", "aqui q numero va??");
//        int registros = ud.insertar(u1);
//        System.out.println("registros = " + registros);
//        mostrarValores(ud);

        

    public static void main(String args[]) {
        try
        {
            //        List<Usuario> usuarios = ud.seleccionar();
//        imprimir(usuarios);
            
            List<Double> gananciasPorSemana = CuentasDAO.obtenerValoresPorSemana("ganancia");
            //List<Double> gananciasPorSemana = CuentasDAO.obtenerGananciasUltimas7Semanas(Conexion.getConnection());
            //System.out.println("Fuera "+fechaMinima+" "+fechaMaxima);
            gananciasPorSemana.forEach(ganancia -> {
                System.out.println(ganancia);
            });
        } catch (SQLException ex)
        {
            Logger.getLogger(TestManejoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static <T extends List> void imprimir(T t) {
        t.forEach(e -> {
            System.out.println(e);
        });
    }
}