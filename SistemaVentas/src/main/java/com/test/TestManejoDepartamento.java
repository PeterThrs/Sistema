/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test;

import com.classes.Departamento;
import com.conexion.DepartamentoDAO;
import java.util.List;

/**
 *
 * @author EdRyz
 */
public class TestManejoDepartamento {
    public static void main(String[] args){
        DepartamentoDAO departamentoDao = new DepartamentoDAO();
        
//        Insertando objeto de tipo Departamento
//        Departamento departamentoNew = new Departamento("RRHH",8);
//        DepartamentoDao.insertar(departamenotNew);
        
//        //Modificar objeto Departamento existente
//        Departamento departamentoMod = new Tienda(3, "RRHH",8);
//        DepartamentoDao.actualizar(departamentoMod);
        
        //Eliminar un registro
        Departamento departamentoDel = new Departamento("");
        DepartamentoDAO.eliminar(departamentoDel);
        
        //Listado Departamentos
        List<Departamento> departamentos = departamentoDao.seleccionar();
        
        departamentos.forEach(departamento ->
        {
            System.out.println("tienda = "+departamento);
        });
    }
}
