/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.settings;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Recursos {

    public static ImageIcon mostrarImagen(String rutaImagen) throws IOException {
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        return new ImageIcon(imagen);
    }

    public static void guardarImagen(String rutaImagen, BufferedImage imagen) throws IOException {
        File archivoImagen = new File(rutaImagen);
        ImageIO.write(imagen, "png", archivoImagen);
    }

    public static String obtenerNombreArchivo(String directorio) {
        File folder = new File(directorio);
        File[] archivos = folder.listFiles();
        return (archivos.length == 1 && archivos[0].isFile()) ? archivos[0].getName() : null;
        /*if (archivos.length == 1 && archivos[0].isFile())
        {
            return archivos[0].getName();
        } else
        {
            return null;
        }*/
    }
}
