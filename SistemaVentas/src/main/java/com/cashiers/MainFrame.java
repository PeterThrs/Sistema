package com.cashiers;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MainFrame extends JFrame {

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Carga la imagen desde el archivo
        ImageIcon imageIcon = new ImageIcon("src/main/resources/imagenes/peter/paisaje.jpg");
        Image image = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_AREA_AVERAGING); 

        // Crea un JPanel personalizado para mostrar la imagen con forma de círculo
        JLabel imageLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Crea un objeto Ellipse2D para definir la forma del círculo
                Ellipse2D circle = new Ellipse2D.Float(0, 0, image.getWidth(this), image.getHeight(this));

                // Aplica el recorte (clipping) en la representación gráfica de la imagen
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setClip(circle);
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();
            }
        };

        

        // Establece el JPanel como el contenido principal de la ventana
        //getContentPane().add(imagePanel);
        this.add(imageLabel); 
        repaint(); 
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
