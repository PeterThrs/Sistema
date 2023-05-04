package com.conexion;

import com.classes.Persona;
import com.classes.Rol;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDao {
    private static final String SQL_SELECT = "SELECT * from rol";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM rol WHERE idRol = ?";
    
    public static List<Rol> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Rol rol = null;
        List<Rol> roles = new ArrayList<>();
        
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                int idRol = rs.getInt("idRol");
                String nombre = rs.getString("nombre");
                
                rol = new Rol(idRol, nombre);
                
                roles.add(rol);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return roles;
    }
    
    public static Rol seleccionIndividual(Rol rol) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, rol.getIdRol());
            rs = stmt.executeQuery();

            if(rs.next())
            {
                int idRol = rs.getInt("idRol");
                String nombre = rs.getString("nombre");
                return new Rol(idRol, nombre);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }
}