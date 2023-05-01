/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import com.classes.Departamento;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDao {

    private static final String SQL_SELECT = "SELECT idDepartamento, nombre FROM departamento";
    private static final String SQL_INSERT = "INSERT INTO departamento(idDepartamento, nombre) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE departamento SET idDepartamento = ?, nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM departamento WHERE idDepartamento = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM departamento WHERE idDepartamento = ?";

    public static List<Departamento> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idDepartamento = rs.getInt("idDepartamento"); // en el contructor solo esta el nombre, o departamento q cambie a nombre
                // comentare en el caso de que lo vayan a usar o no.
                String nombre = rs.getString("nombre");

                departamento = new Departamento(idDepartamento, nombre);
                departamentos.add(departamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return departamentos;
    }

    public static int insertar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, departamento.getidDepartamento());
            stmt.setString(2, departamento.getDepartamento());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int actualizar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, departamento.getidDepartamento());
            stmt.setString(2, departamento.getDepartamento());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static int eliminar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, departamento.getidDepartamento());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public static Departamento seleccionIndividual(Departamento departamento) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("id departamento " + departamento.getidDepartamento());
        try {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, departamento.getidDepartamento());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idDepartamento = rs.getInt("idDepartamento");
                String nombre = rs.getString("nombre");

                return new Departamento(idDepartamento, nombre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return null;
    }
}
