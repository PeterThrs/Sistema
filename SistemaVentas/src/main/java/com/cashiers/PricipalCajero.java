/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

import javax.swing.SwingUtilities;

/**
 *
 * @author Root
 */
public class PricipalCajero {

    public static void main(String[] args) {

        Runnable runApplication = new Runnable() {
            public void run() {
                VistaCajero vc = new VistaCajero();
                ControladorCajero cc = new ControladorCajero(vc, null);
                vc.getClass();
                vc.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
