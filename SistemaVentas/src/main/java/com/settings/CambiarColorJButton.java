/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CambiarColorJButton {

    public static void cambiarColorJButton(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color cuando el puntero del mouse entra en el JButton
                button.setBackground(Color.RED);
                button.setOpaque(true);
            }

            public void mouseExited(MouseEvent e) {
                // Restaurar el color cuando el puntero del mouse sale del JButton
                button.setBackground(UIManager.getColor("Button.background"));
                button.setOpaque(false);
            }
        });
    }
}
