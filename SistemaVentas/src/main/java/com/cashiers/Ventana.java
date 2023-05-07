/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

/**
 *
 * @author Pedro
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private GridBagConstraints c; 
    private ImageIcon imagen; 
    
    public Ventana() {
        // Configuramos la ventana principal
        super("Cajero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setMinimumSize(new Dimension(1000, 600));
        // Configuramos el layout de la ventana
        setLayout(new GridBagLayout());
        // Mostramos la ventana
        setVisible(true);
        componentes(); 
    }
    
    private void componentes(){
        paneles();
    }
    
    private void paneles(){
        c = new GridBagConstraints();

        // Creamos el panel izquierdo y lo añadimos a la ventana
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.RED);
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.25;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        panelIzquierdo.setLayout(new GridBagLayout());
        add(panelIzquierdo, c);

        // Creamos el panel derecho y lo añadimos a la ventana
        panelDerecho = new JPanel();
        panelDerecho.setBackground(Color.GREEN);
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.75;
        c.weighty = 1;
        panelDerecho.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        add(panelDerecho, c);
    }
    
    private void imagenes(){
        
    }

    public static void main(String[] args) {
        Ventana v= new Ventana(); 
    }
}