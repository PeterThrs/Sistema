/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private JTable table;

    public MainFrame() {
        // Configuración básica de la ventana JFrame
        setTitle("Ventana de ejemplo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una matriz de datos para la JTable (solo para ejemplificar)
        Object[][] data = {
                {"Juan", "Pérez"},
                {"María", "Gómez"},
                {"Carlos", "López"}
        };

        // Crear un array con los nombres de las columnas (solo para ejemplificar)
        String[] columnNames = {"Nombre", "Apellido"};

        // Crear la JTable con los datos y los nombres de las columnas
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar un MouseListener a la JTable para deseleccionarla cuando se hace clic fuera de ella
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                table.requestFocusInWindow(); // Solicitar el foco para la JTable
                table.clearSelection(); // Limpiar la selección de la JTable
            }
        });

        // Agregar el JScrollPane (con la JTable) al JFrame
        add(scrollPane);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}