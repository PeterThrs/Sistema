/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import static com.conexion.Conexion.*;
import com.classes.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiendaDao {

    private static final String SQL_SELECT = "SELECT * from tienda";
    private static final String SQL_INSERT = "INSERT INTO tienda(nombre, slogan, telefono1, telefono2, email, mision, vision, codigoPostal, estado, municipio, colonia, calle, numCasa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tienda SET nombre = ?, slogan = ?, telefono1 = ?, telefono2 = ?, email = ?, mision = ?, vision = ?, codigoPostal = ?, estado = ?, municipio = ?, colonia = ?, calle = ?, numCasa = ? WHERE idTienda = ?";
    private static final String SQL_DELETE = "DELETE FROM tienda WHERE idTienda = ?";
    private static final String SQL_SELECT_LAST = "SELECT * FROM tienda ORDER BY idTienda DESC LIMIT 1;";

//    public List<Tienda> seleccionar() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Tienda tienda = null;
//        List<Tienda> tiendas = new ArrayList<>();
//
//        try
//        {
//            conn = getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//
//            while (rs.next())
//            {
//                int idTienda = rs.getInt("idTienda");
//                String nombre = rs.getString("nombre");
//                String slogan = rs.getString("slogan");
//                String telefono1 = rs.getString("telefono1");
//                String telefono2 = rs.getString("telefono2");
//                String email = rs.getString("email");
//                String mision = rs.getString("mision");
//                String vision = rs.getString("vision");
//                int codigoPostal = rs.getInt("codigoPostal");
//                String estado = rs.getString("estado");
//                String municipio = rs.getString("municipio");
//                String colonia = rs.getString("colonia");
//                String calle = rs.getString("calle");
//                int numCasa = rs.getInt("numCasa");
//
//                tienda = new Tienda(idTienda, nombre, slogan, telefono1, telefono2, email, mision, vision, codigoPostal, estado, municipio, colonia, calle, numCasa);
//
//                tiendas.add(tienda);
//            }
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace(System.out);
//        } finally
//        {
//            try
//            {
//                close(rs);
//                close(stmt);
//                close(conn);
//            } catch (SQLException ex)
//            {
//                Logger.getLogger(TiendaDao.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return tiendas;
//    }

    public static int insertar(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tienda.getNombre());
            stmt.setString(2, tienda.getSlogan());
            stmt.setString(3, tienda.getTelefono1());
            stmt.setString(4, tienda.getTelefono2());
            stmt.setString(5, tienda.getEmail());
            stmt.setString(6, tienda.getMision());
            stmt.setString(7, tienda.getVision());
            stmt.setString(8, String.valueOf(tienda.getCodigoPostal()));
            stmt.setString(9, tienda.getEstado());
            stmt.setString(10, tienda.getMunicipio());
            stmt.setString(11, tienda.getColonia());
            stmt.setString(12, tienda.getCalle());
            stmt.setString(13, String.valueOf(tienda.getNumCasa()));
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int actualizar(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tienda.getNombre());
            stmt.setString(2, tienda.getSlogan());
            stmt.setString(3, tienda.getTelefono1());
            stmt.setString(4, tienda.getTelefono2());
            stmt.setString(5, tienda.getEmail());
            stmt.setString(6, tienda.getMision());
            stmt.setString(7, tienda.getVision());
            stmt.setString(8, String.valueOf(tienda.getCodigoPostal()));
            stmt.setString(9, tienda.getEstado());
            stmt.setString(10, tienda.getMunicipio());
            stmt.setString(11, tienda.getColonia());
            stmt.setString(12, tienda.getCalle());
            stmt.setString(13, String.valueOf(tienda.getNumCasa()));
            stmt.setInt(14, tienda.getIdTienda());
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int eliminar(Tienda tienda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tienda.getIdTienda());
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static Tienda traerUltimo() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_LAST);
            rs = stmt.executeQuery();

            if (rs.next())
            {
                int idTienda = rs.getInt("idTienda");
                String nombre = rs.getString("nombre");
                String slogan = rs.getString("slogan");
                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String email = rs.getString("email");
                String mision = rs.getString("mision");
                String vision = rs.getString("vision");
                int codigoPostal = rs.getInt("codigoPostal");
                String estado = rs.getString("estado");
                String municipio = rs.getString("municipio");
                String colonia = rs.getString("colonia");
                String calle = rs.getString("calle");
                int numCasa = rs.getInt("numCasa");

                return new Tienda(nombre, slogan, telefono1, telefono2, email, mision, vision, codigoPostal, estado, municipio, colonia, calle, numCasa);
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
