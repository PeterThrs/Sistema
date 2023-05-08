/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cashiers;

/**
 *
 * @author Pedro
 */
import com.classes.Tienda;
import com.conexion.TiendaDAO;
import com.settings.CodigoColor;
import com.settings.Configuracion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VistaCajero extends JFrame {

    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    private GridBagConstraints c;
    private ImageIcon imagen;
    private JLabel jlImagen, jlNombreEmpresa, jlSloga, jlgmail, jlNombreCajero, jlCodigoProducto;
    private JTable tabla;
    private JButton btnAgregar, btnEliminar, btnCerrarSesion;
    private Color colorPrincipal;
    private JTextField tCodigo;

    public VistaCajero() {
        // Configuramos la ventana principal
        super("Cajero");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setMinimumSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(this);
        this.colorPrincipal = new Color(39, 54, 77);

        //configurando ventana al 100%
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        setResizable(false);
        setUndecorated(true);
        setBounds(bounds);

        // Configuramos el layout de la ventana
        setLayout(new GridBagLayout());
        // Mostramos la ventana
        componentes();
        setVisible(true);
    }

    private void componentes() {
        paneles();
        imagenes();
        etiquetas();
        crearControl();
        crearTabla();
    }

    private void paneles() {
        c = new GridBagConstraints();

        // Creamos el panel izquierdo y lo añadimos a la ventana
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(colorPrincipal);
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.20;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        panelIzquierdo.setLayout(new GridBagLayout());
        add(panelIzquierdo, c);

        // Creamos el panel derecho y lo añadimos a la ventana
        panelDerecho = new JPanel();
        panelDerecho.setBackground(CodigoColor.cFondo);
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.80;
        c.weighty = 1;
        panelDerecho.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        add(panelDerecho, c);
    }

    private void imagenes() {
        try {
            this.jlImagen = new JLabel();
            this.jlImagen.setSize(new Dimension(100, 100));
            Icon icon = new ImageIcon(new ImageIcon("src/main/resources/imagenes/peter/austronauta.png").getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING));
            this.jlImagen.setIcon(icon);
            //this.repaint();
            this.jlImagen.setBackground(Color.MAGENTA);
            c = grid(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 100, 10), 0, 0);
            centrarTexto(jlImagen);
            this.panelIzquierdo.add(jlImagen, c);
        } catch (Exception ex) {

        }
    }

    private void etiquetas() {
        this.jlNombreEmpresa = new JLabel();
        this.jlSloga = new JLabel();
        this.jlgmail = new JLabel();
        this.jlNombreCajero = new JLabel();

        TiendaDAO tiendaDao = new TiendaDAO();
        Tienda tienda = tiendaDao.traerUltimo();
        jlNombreEmpresa.setText(tienda.getNombre());
        c = grid(0, 1, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        agregarAlPanel(panelIzquierdo, jlNombreEmpresa, c);
        jlSloga.setText(tienda.getSlogan());
        c = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        agregarAlPanel(panelIzquierdo, jlSloga, c);
        jlgmail.setText(tienda.getEmail());
        c = grid(0, 3, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        agregarAlPanel(panelIzquierdo, jlgmail, c);
        jlNombreCajero.setText("Aqui va el nombre del usuario actual");
        c = grid(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        agregarAlPanel(panelIzquierdo, jlNombreCajero, c);
        centrarTexto(jlNombreEmpresa, jlSloga, jlgmail, jlNombreCajero);
        Configuracion.robotoPlain14(jlNombreEmpresa, jlSloga, jlgmail, jlNombreCajero);
        Configuracion.foreground(Color.WHITE, jlNombreEmpresa, jlSloga, jlgmail, jlNombreCajero);
        this.jlNombreEmpresa.setBackground(Color.RED);

        //Btn cerrar Sesion
        btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBackground(new Color(139, 0, 0)); // rojo oscuro
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Configuracion.robotoPlain14(btnCerrarSesion);
        this.repaint();
        c = grid(0, 5, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(50, 10, 10, 10), 0, 0);
        agregarAlPanel(panelIzquierdo, btnCerrarSesion, c);

        //le agregamos la acción de cerrar
        btnCerrarSesion.addActionListener(e -> {
            System.exit(0);
        });
    }

    /**
     *
     * @param <T>
     * @param gridx - La posición del componente en el eje x.
     * @param gridy - La posición del componente en el eje y.
     * @param gridWidth - El número de celdas de la cuadrícula que ocupa el
     * componente en el eje x.
     * @param gridHeight - El número de celdas de la cuadrícula que ocupa el
     * componente el eje y.
     * @param weightx - La cantidad de espacio extra que se asignará a la celda
     * en el eje x si el espacio disponible en la ventana se agranda.
     * @param weighty - La cantidad de espacio extra que se asignará a la celda
     * en el y si el espacio disponible en la ventana se agranda.
     * @param fill - Determinacómo se estirará el componente para llenar la
     * celda: NONE, HORIZONTAL,VERTICAL o BOTH.
     * @param anchor - La posición del componente dentro de la celda si la celda
     * es más grande que el componente.
     * @param insets - El espacio entre el borde del componente y el borde de su
     * celda.
     * @param ipadx - La cantidad de espacio extra en píxeles que se agregará al
     * ancho preferido del componente.
     * @param ipady - La cantidad de espacio extra en píxeles que se agregará al
     * alto preferido del componente.
     */
    private <T extends JComponent> GridBagConstraints grid(int gridx, int gridy, int gridWidth, int gridHeight,
            int weightx, int weighty, int fill, int anchor, Insets insets, int ipadx, int ipady) {
        c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = insets;
        c.ipadx = ipadx;
        c.ipady = ipady;
        return c;
    }

    private <T extends JComponent> void agregarAlPanel(JPanel panel, T componente, GridBagConstraints c) {
        //Arrays.asList(componentes).forEach(e -> panel.add(e, a.iterator().next()));
        panel.add(componente, c);
    }

    private void centrarTexto(JLabel... componentes) {
        Arrays.asList(componentes).forEach(c -> c.setHorizontalAlignment(SwingConstants.CENTER));
    }

    private void crearControl() {
        jlCodigoProducto = new JLabel("Codigo de Producto: ");
        Configuracion.robotoPlain14(jlCodigoProducto);
        jlCodigoProducto.setOpaque(false);
        jlCodigoProducto.setBackground(Color.YELLOW);
        c = grid(0, 2, 1, 1, 1, 0, GridBagConstraints.NONE, GridBagConstraints.EAST, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(panelDerecho, jlCodigoProducto, c);

        tCodigo = new JTextField("");
        tCodigo.setSize(new Dimension(100, 40));
        c = grid(1, 2, 1, 1, 1, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(panelDerecho, tCodigo, c);

        btnAgregar = new JButton("Agregar");
        c = grid(2, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(panelDerecho, btnAgregar, c);
        btnEliminar = new JButton("Eliminar");
        c = grid(3, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(panelDerecho, btnEliminar, c);

        btnConf(btnAgregar, btnEliminar);

    }

    private void btnConf(JButton... btn) {
        Arrays.asList(btn).forEach(e -> {
            e.setBackground(colorPrincipal);
            e.setForeground(Color.WHITE);
            Configuracion.robotoPlain14(btn);
            e.setFocusable(false);
            e.setCursor(new Cursor(Cursor.HAND_CURSOR) {
            });
        });
    }

    private void crearTabla() {
        // Crear la tabla con un modelo de datos vacío
        tabla = new JTable();

        // Agregar la tabla a un JScrollPane para poder desplazarse por ella
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Configurar los titulos de las columnas
        String[] titulos = {"Codigo", "Descripcion del producto", "Precio Venta", "Cant", "Importe", "Existencia"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(titulos);
        tabla.setModel(model);

        // Configurar los tamaños de las columnas
        int[] tam = {50, 200, 50, 30, 70, 50};
        for (int i = 0; i < titulos.length; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(tam[i]);
        }

        // Configurar algunos detalles estéticos
        tabla.setRowHeight(30);
        tabla.setIntercellSpacing(new Dimension(0, 0));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setBackground(new Color(39, 54, 77));
        tabla.getTableHeader().setOpaque(false);
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setSelectionBackground(new Color(194, 230, 248));
        // Para quitar el borde de selección de las celdas de la tabla
        tabla.setFocusable(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Centrar el texto en las celdas de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.setDefaultRenderer(Object.class, centerRenderer);

        // Agregar algunos datos a la tabla para mostrarla con información
//        Object[] fila1 = {"123456789", "Crema para peinarse PANTENE", "$40.00", "2", "$80.00", "5"};
//        model.addRow(fila1);
//        Object[] fila2 = {"123456789", "Crema para peinarse PANTENE", "$40.00", "2", "$80.00", "5"};
//        model.addRow(fila2);

        //lo agregamos al panel con las ubicaciones
        c = grid(0, 5, 5, 10, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        agregarAlPanel(panelDerecho, scrollPane, c);

    }
    
    //getter and Setter para poder recuperar los datos desde el controlador

    public static void main(String[] args) {
        VistaCajero v = new VistaCajero();
    }

    public JPanel getPanelIzquierdo() {
        return panelIzquierdo;
    }

    public void setPanelIzquierdo(JPanel panelIzquierdo) {
        this.panelIzquierdo = panelIzquierdo;
    }

    public JPanel getPanelDerecho() {
        return panelDerecho;
    }

    public void setPanelDerecho(JPanel panelDerecho) {
        this.panelDerecho = panelDerecho;
    }

    public GridBagConstraints getC() {
        return c;
    }

    public void setC(GridBagConstraints c) {
        this.c = c;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public JLabel getJlImagen() {
        return jlImagen;
    }

    public void setJlImagen(JLabel jlImagen) {
        this.jlImagen = jlImagen;
    }

    public JLabel getJlNombreEmpresa() {
        return jlNombreEmpresa;
    }

    public void setJlNombreEmpresa(JLabel jlNombreEmpresa) {
        this.jlNombreEmpresa = jlNombreEmpresa;
    }

    public JLabel getJlSloga() {
        return jlSloga;
    }

    public void setJlSloga(JLabel jlSloga) {
        this.jlSloga = jlSloga;
    }

    public JLabel getJlgmail() {
        return jlgmail;
    }

    public void setJlgmail(JLabel jlgmail) {
        this.jlgmail = jlgmail;
    }

    public JLabel getJlNombreCajero() {
        return jlNombreCajero;
    }

    public void setJlNombreCajero(JLabel jlNombreCajero) {
        this.jlNombreCajero = jlNombreCajero;
    }

    public JLabel getJlCodigoProducto() {
        return jlCodigoProducto;
    }

    public void setJlCodigoProducto(JLabel jlCodigoProducto) {
        this.jlCodigoProducto = jlCodigoProducto;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setBtnCerrarSesion(JButton btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public JTextField gettCodigo() {
        return tCodigo;
    }

    public void settCodigo(JTextField tCodigo) {
        this.tCodigo = tCodigo;
    }
    
    
    
}
