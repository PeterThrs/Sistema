package com.conexion;

import com.classes.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {
    
    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa FROM persona";
    
    
    public List<Persona> seleccionar(){
        Connection coon = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
        
        Persona persona = null; 
        List<Persona> personas = new ArrayList<>(); 
        try {
            coon = Conexion.getConnection(); 
            stmt = coon.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getInt("idPersona"));
            }
            
        }catch (SQLException ex){
            
        }finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex){
                
            }
        }
        
        
        
        return null; 
    }
}
    