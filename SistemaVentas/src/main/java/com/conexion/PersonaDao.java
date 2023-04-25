package com.conexion;

import static com.conexion.Conexion.*;
import com.classes.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDao {

    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellidoP, apellidoM, email, telefono1, telefono2, edad, curp, rfc, sexo, codigoPostal, estado, municipio, colonia, calle, numCasa FROM persona";
    

    public List<Persona> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT); 
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("idPersona");
                System.out.println("idPersona = " + idPersona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }
}
