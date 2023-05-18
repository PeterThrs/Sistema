package com.settings;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class PlaceholderUtils {
    public static void setPlaceholder(JTextField textField, String placeholder) {
        // Configurar el estilo del texto de marcador de posición
        textField.setForeground(Color.GRAY);
        textField.setFont(textField.getFont().deriveFont(Font.ITALIC));

        // Añadir un listener de foco para controlar la visibilidad del marcador de posición
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Si se obtiene el foco y el texto es igual al marcador de posición, borrarlo
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    textField.setFont(textField.getFont().deriveFont(Font.PLAIN));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si se pierde el foco y el campo de texto está vacío, mostrar el marcador de posición
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                    textField.setFont(textField.getFont().deriveFont(Font.ITALIC));
                }
            }
        });

        // Establecer el marcador de posición inicial
        textField.setText(placeholder);
    }
    
    public static void setPlaceholder(JPasswordField passwordField, String placeholder) {
        // Configurar el estilo del texto de marcador de posición
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(passwordField.getFont().deriveFont(Font.ITALIC));

        // Añadir un listener de foco para controlar la visibilidad del marcador de posición
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Si se obtiene el foco y el texto es igual al marcador de posición, borrarlo
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setFont(passwordField.getFont().deriveFont(Font.PLAIN));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Si se pierde el foco y el campo de texto está vacío, mostrar el marcador de posición
                if (passwordField.getPassword().length == 0) {
                    passwordField.setText(placeholder);
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setFont(passwordField.getFont().deriveFont(Font.ITALIC));
                }
            }
        });

        // Establecer el marcador de posición inicial
        passwordField.setText(placeholder);
    }
}
