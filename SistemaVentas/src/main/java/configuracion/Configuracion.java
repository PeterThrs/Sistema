package configuracion;

import Objetos.Sesion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Configuracion {
    
    public Icon setIconoBoton(String url,JButton boton){
        ImageIcon icon=new ImageIcon(getClass().getResource(url)); 
        int ancho=boton.getWidth();
        int alto=boton.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        return icono;
    }
    public Icon setIconoEtiqueta(String url,JLabel etiqueta){
        ImageIcon icon=new ImageIcon(getClass().getResource(url)); 
        int ancho=etiqueta.getWidth();
        int alto=etiqueta.getHeight();
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        return icono;
    }
    //configuraciones generales para una ventana de tipo JFrame
    public static <T extends JFrame> void styles(T t){
        t.setExtendedState(t.MAXIMIZED_BOTH);
        t.setTitle(Sesion.app.getAppNombre());
        t.setLocationRelativeTo(null);
        t.setIconImage(Sesion.app.getIcono());
        
    }
    //configuraciones generales par auna ventana de tipo JDialog
    public static <T extends JDialog> void styles(T t){
        t.setTitle(Sesion.app.getAppNombre());
        t.setLocationRelativeTo(null);
        t.setIconImage(Sesion.app.getIcono());
    }
    //configuraicones para el tipo de letra general de la aplicacion
    public static <T extends JComponent> void robotoPlain12(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setFont(new Font("Roboto", Font.PLAIN, 12));
        } 
    }
    //configuraicones para el tipo de titulos general de la aplicacion
    public static <T extends JComponent> void titulo(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setFont(new Font("Roboto", Font.BOLD, 16));
        } 
    }
    
    //metodos creados por peter. 
    
    public static <T extends JComponent> void borde(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setBorder(null);
        } 
    }
    
    public static <T extends JComponent> void withoutBorde(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setBorder(null);
        } 
    }
    
    public static <T extends JComponent> void normalItalic(T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setFont(new Font("Roboto", Font.ITALIC, 13));
        } 
    }
    
    //Establecer Foreground
    public static <T extends JComponent> void foreground(Color color, T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setForeground(color);
        } 
    }
    
    //Establecer background
    public static <T extends JComponent> void background(Color color, T... t){
        for(int i = 0; i < t.length; i++){
            t[i].setBackground(color);
        } 
    }
    
}
