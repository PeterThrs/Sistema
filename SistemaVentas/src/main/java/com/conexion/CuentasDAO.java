/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion;

import com.classes.CuentaFinanciera;
import com.classes.Persona;
import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanj
 */
public class CuentasDAO {

    private static final String SQL_SELECT = "SELECT id_cuentaDia, fecha, ganancia, perdida, inversion FROM cuenta_dia";
    private static final String SQL_INSERT = "INSERT INTO cuenta_dia (fecha, ganancia, perdida, inversion) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cuenta_dia SET fecha=?, ganancia=?, perdida=?, inversion=? WHERE id_cuentaDia=?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM cuenta_dia WHERE id_cuentadia = ?";
    private static final String SQL_SELECT_LAST = "SELECT * FROM cuenta_dia ORDER BY id_cuentaDia DESC LIMIT 1;";

    public static List<CuentaFinanciera> seleccionar() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CuentaFinanciera> cuentas = new ArrayList<>();

        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next())
            {
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                double ganancia = rs.getDouble("ganancia");
                double perdida = rs.getDouble("perdida");
                double inversion = rs.getDouble("inversion");

                cuentas.add(new CuentaFinanciera(id_cuentaDia, fecha, ganancia, perdida, inversion));
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
                close(coon);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return cuentas;
    }

    public static int insertar(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);

            stmt.setDate(1, java.sql.Date.valueOf(cuenta.getFecha()));
            stmt.setDouble(2, cuenta.getGanancia());
            stmt.setDouble(3, cuenta.getPerdida());
            stmt.setDouble(4, cuenta.getInversion());

            registros = stmt.executeUpdate();

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
        return registros;
    }

    public static int actualizar(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);

            stmt.setDate(1, java.sql.Date.valueOf(cuenta.getFecha()));
            stmt.setDouble(2, cuenta.getGanancia());
            stmt.setDouble(3, cuenta.getPerdida());
            stmt.setDouble(4, cuenta.getInversion());

            registros = stmt.executeUpdate();

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
        return registros;
    }

    public static CuentaFinanciera traerUltimo() {
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
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                return new CuentaFinanciera(id_cuentaDia);
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

    public static CuentaFinanciera seleccionIndividual(CuentaFinanciera cuenta) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            coon = Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, cuenta.getId_cuentaDi());
            rs = stmt.executeQuery();

            if (rs.next())
            {
                int id_cuentaDia = rs.getInt("id_cuentaDia");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                double ganancia = rs.getDouble("ganancia");
                double perdida = rs.getDouble("perdida");
                double inversion = rs.getDouble("inversion");
                
                return new CuentaFinanciera(id_cuentaDia, fecha, ganancia, perdida, inversion);
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
