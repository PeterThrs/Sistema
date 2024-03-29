package com.settings;

import com.admin.EditInfoStore;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

/**
 *
 * @author juanj
 */
public class ObjGraficosService {

    private JLabel label;
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JPasswordField passwordField;
    private JCheckBox check;
    
    static private ObjGraficosService servicio;

    private ObjGraficosService() {
    }

    public static ObjGraficosService getService() {
        if (servicio == null) {
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
        if (colorFondo != null) {
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        switch (direccion) {
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

    public JPanel construirJPanel(int x, int y, int ancho, int alto, Color colorFondo, Border borde) {
        panel = new JPanel();
        panel.setSize(ancho, alto);
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        return panel;
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
        while (inicio < texto.length()) {
            if (fin >= texto.length()) {
                fin = texto.length();
            } else {
                fin = texto.lastIndexOf(" ", fin);
            }
            lineas.add(texto.substring(inicio, fin));
            inicio = fin + 1;
            fin = inicio + longitudMaxima;
        }
        return String.join("<br>", lineas);
    }
    
    public JTextField construirJTextField(
            String texto, int x, int y, int ancho, int alto, Font fuente, Color colorFondo,
            Color colorFuente, Color colorCaret, Border borde, String direccion
    ) {
        textField = new JTextField();
        textField.setLocation(x, y);
        textField.setSize(ancho, alto);
        textField.setText(texto);
        textField.setForeground(colorFuente);
        textField.setBackground(colorFondo);
        textField.setCaretColor(colorCaret);
        textField.setFont(fuente);
        textField.setBorder(borde);
        switch (direccion)
        {
            case "c":
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                break;
        }
        return textField;
    }
    
    public JButton construirJButton(
            String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente,
            Color colorFondo, Color colorFuente, Border borde, String direccion, boolean esSolido
    ) {
        button = new JButton(texto);
        button.setLocation(x, y);
        button.setSize(ancho, alto);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(imagen);
        button.setBorder(borde);
        button.setContentAreaFilled(esSolido);
        switch (direccion)
        {
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                button.setHorizontalTextPosition(SwingConstants.LEFT);
                break;
            case "t":
                button.setVerticalTextPosition(SwingConstants.TOP);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "b":
                button.setVerticalTextPosition(SwingConstants.BOTTOM);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            default:
                break;
        }
        return button;
    }
    
    public JPasswordField construirJPasswordField(
            String texto, int x, int y, int ancho, int alto, Font fuente, Color colorFondo,
            Color colorFuente, Color colorCaret, Border borde, String direccion
    ) {
        passwordField = new JPasswordField();
        passwordField.setLocation(x, y);
        passwordField.setSize(ancho, alto);
        passwordField.setText(texto);
        passwordField.setForeground(colorFuente);
        passwordField.setBackground(colorFondo);
        passwordField.setCaretColor(colorCaret);
        passwordField.setBorder(borde);
        switch (direccion)
        {
            case "c":
                passwordField.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "r":
                passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                break;
        }
        return passwordField;
    }
    
    public JCheckBox construirJCheckBox(
            String texto, int x, int y, int ancho, int alto, Cursor cursor, Font fuente, Color colorFuente
    ) {
        check = new JCheckBox(texto);
        check.setLocation(x, y);
        check.setSize(ancho, alto);
        check.setFocusable(false);
        check.setBackground(null);
        check.setCursor(cursor);
        check.setFont(fuente);
        check.setForeground(colorFuente);
        return check;
    }
    
    public static JFileChooser personalizarVentana() {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(EditInfoStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser chooser = new JFileChooser();
        return chooser;
    }
}
