/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admin;

import com.admin.enumerador.Entrada;
import com.cashiers.ControladorCajero;
import com.cashiers.VistaCajero;
import javax.swing.SwingUtilities;

/**
 *
 * @author Root
 */
public class PrincipalAltaUsuario {

    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            public void run() {
                VistaAltaUsuario va = new VistaAltaUsuario(Entrada.CONSULTAR, null, null);
                va.getClass();
                va.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }

}
