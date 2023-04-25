/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import com.classes.Tienda;
import static com.conexion.Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiendaDAO {

    private static final String SQL_SELECT = "SELECT * from tienda";

    public List<Tienda> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda tienda = null;
        List<Tienda> tiendas = new ArrayList<>();

        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int idTienda = rs.getInt("idTienda");
                String nombre = rs.getString("nombre");
                String slogan = rs.getString("slogan");
                long telefono1 = rs.getLong("telefono1");
                long telefono2 = rs.getLong("telefono2");
                String email = rs.getString("email");
                String mision = rs.getString("mision");
                String vision = rs.getString("vision");
                int codigoPostal = rs.getInt("codigoPostal");
                String estado = rs.getString("estado");
                String municipio = rs.getString("municipio");
                String colonia = rs.getString("colonia");
                String calle = rs.getString("calle");
                int numCasa = rs.getInt("numCasa");

                tienda = new Tienda(idTienda, nombre, slogan, telefono1, telefono2, email, mision, vision, codigoPostal, estado, municipio, colonia, calle, numCasa);

                tiendas.add(tienda);
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
                Logger.getLogger(TiendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tiendas;
    }
}
