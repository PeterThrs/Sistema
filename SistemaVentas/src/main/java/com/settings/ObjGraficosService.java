/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author juanj
 */
public class ObjGraficosService {
    private JLabel label;
    static private ObjGraficosService servicio;
    
    private ObjGraficosService() {
    }

    public static ObjGraficosService getService() {
        if (servicio == null)
        {
            servicio = new ObjGraficosService();
        }
        return servicio;
    }
    
    public JLabel construirJLabel(
            String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen,
            Font fuente, Color colorFondo, Color colorFuente, Border borde, String direccion
    ) {
        label = new JLabel(texto);
        label.setLocation(x, y);
        label.setSize(ancho, alto);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        label.setCursor(cursor);
        label.setIcon(imagen);
        label.setBorder(borde);
        if (colorFondo != null)
        {
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        switch (direccion)
        {
            case "c":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                label.setHorizontalTextPosition(SwingConstants.LEFT);
                break;
            case "t":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.TOP);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "b":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.BOTTOM);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            default:
                break;
        }
        return label;
    }
    
    public static ImageIcon mostrarImagen(String rutaImagen) throws IOException {
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        return new ImageIcon(imagen);
    }

    public static void guardarImagen(String rutaImagen, BufferedImage imagen) throws IOException {
        File archivoImagen = new File(rutaImagen);
        ImageIO.write(imagen, "png", archivoImagen);
    }
    
    public static String saltosDeLineaJlabel(String texto, int longitudMaxima) {
        java.util.List<String> lineas = new ArrayList<String>();
        int inicio = 0;
        int fin = longitudMaxima;
        while (inicio < texto.length())
        {
            if (fin >= texto.length())
            {
                fin = texto.length();
            } else
            {
                fin = texto.lastIndexOf(" ", fin);
            }
            lineas.add(texto.substring(inicio, fin));
            inicio = fin + 1;
            fin = inicio + longitudMaxima;
        }
        return String.join("<br>", lineas);
    }
}
