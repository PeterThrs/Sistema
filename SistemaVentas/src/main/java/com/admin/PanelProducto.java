/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.settings.Configuracion;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import com.classes.Departamento;
import com.classes.Producto;
import com.conexion.DepartamentoDao;
import com.conexion.ProductoDao;
import com.settings.CodigoColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class PanelProducto extends javax.swing.JPanel {

    private DepartamentoDao departamentoDao;
    private Producto producto;
    private ProductoDao productoDao;

    private String codigo, nombre, descripcion;
    private Double precioCosto, ganancia, mayoreo, cantidad;
    private int idDepartamento;
    private int ocuparInventario;

    //Estado de la ventana
    private boolean VentanaEditar;
    private boolean ventanaAgregar;

    public PanelProducto() {

        this.departamentoDao = new DepartamentoDao();
        this.producto = new Producto();
        this.productoDao = new ProductoDao();
        this.VentanaEditar = false;
        this.ventanaAgregar = true;

        initComponents();
        configuracion();
        agregarEstilos();
        revisarEstado();
        precioVenta();

    }

    //la ventana se ocupara para editar la informacion
    public PanelProducto(Producto producto) {
        this.producto = producto;
        this.departamentoDao = new DepartamentoDao();
        this.productoDao = new ProductoDao();

        this.VentanaEditar = true;
        this.ventanaAgregar = false;
        initComponents();
        configuracion();
        agregarEstilos();
        revisarEstado();
        cargarDatos();
        precioVenta();
        eventoActualizar();
        eventoEliminar();
    }

    private void revisarEstado() {
        if (this.ventanaAgregar) {
            this.btnUpdate.setEnabled(false);
            this.btnCancel.setEnabled(false);
        } else {
            this.btnCreate.setEnabled(false);
            this.tfBarCode.setEnabled(false);
        }
    }

    private void agregarEstilos() {
        //configuracion de la ventana 
        this.setMinimumSize(new Dimension(650, 600));
        this.setSize(new Dimension(650, 600));

        //configuracion al JPanel
        Configuracion.background(CodigoColor.cFondoGris, this);

        //configuracion JLabel
        //titulo
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jlTitle);
        Configuracion.robotoBold20(this.jlTitle);
        //demas datos
        Configuracion.robotoPlain14(this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost, this.jlRevenue,
                this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice, this.jlName);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost,
                this.jlRevenue, this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice, this.jlName);

        //configuraicon JTextField
        Configuracion.robotoPlain14(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,
                this.tfWholePrice, this.tfName, this.tfGanancia);
        Configuracion.withoutBorde(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,
                this.tfWholePrice, this.tfName, this.tfGanancia);
        Configuracion.background(CodigoColor.cFondoGris, this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice,
                this.tfTotal, this.tfWholePrice, this.tfName, this.tfGanancia);
        Configuracion.foreground(CodigoColor.cLetrasTextField, this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice,
                this.tfTotal, this.tfWholePrice, this.tfName, this.tfGanancia);

        //configuracion JSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea8, this.linea9, this.linea10, this.linea11, this.linea12);

        //configuracion JButton
        Configuracion.robotoPlain14(this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnCreate, this.btnUpdate);

        //configuraicion JComboBox 
        Configuracion.robotoPlain14(this.cbDepartment);
        Configuracion.withoutBorde(this.cbDepartment);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbDepartment);
        Configuracion.background(CodigoColor.cFondoGris, this.cbDepartment);

        //configuracion JCheckBox
        Configuracion.robotoPlain14(this.cbInventory);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbInventory);
        Configuracion.background(CodigoColor.cFondoGris, this.cbInventory);
        
    }

    private void configuracion() {
        estadoTfTotal();
        checkBoxEventItemListener();
        listDesplegable();
        eventoGanancia();
        eventoInsertar();
    }

    private void cargarDatos() {
        this.tfBarCode.setText(producto.getCodigo());
        this.tfName.setText(producto.getNombre());
        this.tfDescription.setText(producto.getDescripcion());
        this.tfPriceCost.setText(String.valueOf(producto.getPrecioCosto()));
        this.tfGanancia.setText(String.valueOf(producto.getGanancia()));
        this.tfWholePrice.setText(String.valueOf(producto.getMayoreo()));
        this.cbDepartment.setSelectedIndex(producto.getIdDepartamento() - 1);
        boolean inventario = (producto.getOcupaInventario() == 1) ? true : false;
        this.cbInventory.setSelected(inventario);
        if (inventario) {
            this.tfTotal.setText(String.valueOf(producto.getCantidad()));
        }

    }

    private void limpiarForm() {
        this.tfBarCode.setText("");
        this.tfName.setText("");
        this.tfDescription.setText("");
        this.tfPriceCost.setText("");
        this.tfGanancia.setText("");
        this.tfWholePrice.setText("");
        this.cbDepartment.setSelectedIndex(1);
        this.cbInventory.setSelected(false);
        this.tfTotal.setText("");
        this.tfSalePrice.setText("");

    }

    private void estadoTfTotal() {
        try {
            this.tfTotal.setEnabled(false);
            this.jlTotal.setEnabled(false);
            this.linea8.setVisible(false);
        } catch (Exception ex) {

        }
    }

    private void checkBoxEventItemListener() {
        try {
            this.cbInventory.addItemListener(e -> {
                if (this.cbInventory.isSelected()) {
                    System.out.println(cbInventory.isSelected());
                    this.tfTotal.setEnabled(true);
                    this.jlTotal.setEnabled(true);
                    this.linea8.setVisible(true);
                } else {
                    this.tfTotal.setEnabled(false);
                    this.jlTotal.setEnabled(false);
                    this.linea8.setVisible(false);
                }
            });
        } catch (Exception ex) {

        }
    }

    private void listDesplegable() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        List<Departamento> departamentos = DepartamentoDao.seleccionar();
        departamentos.forEach(departamento -> {
            dcbm.addElement(departamento.getDepartamento());
        });
        this.cbDepartment.setSelectedIndex(0);
        this.cbDepartment.setModel(dcbm);
        this.cbDepartment.getEditor().getEditorComponent().setForeground(CodigoColor.cLetrasNegro);
        this.cbDepartment.getEditor().getEditorComponent().setBackground(CodigoColor.cFondoGris);
    }

    //calcular el precio
    private void precioVenta() {
        if (!tfGanancia.getText().isEmpty()) {
            try {
                double ganancia = Double.parseDouble(this.tfGanancia.getText());
                validarCadena(this.tfPriceCost.getText());
                double precioCosto = Double.parseDouble(this.tfPriceCost.getText());
                double venta = precioCosto + (precioCosto * (ganancia / 100));
                this.tfSalePrice.setText(String.valueOf(venta));

            } catch (NumberFormatException ex) {

            } catch (Exception ex) {

            }
        }
    }

    private void eventoGanancia() {
        this.tfGanancia.addActionListener(e -> {
            precioVenta();
        });

        this.tfGanancia.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // El componente ha ganado el foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                // El componente ha perdido el foco
                System.out.println("Se ha salido del JTextField");
                precioVenta();
            }
        });
    }

    //validar el form producto
    private int recuperarInventario() {
        return (this.cbInventory.isSelected()) ? 1 : 0;
    }

    private boolean validarCadena(String c) throws Exception {
        if (!c.isEmpty()) {
            return true;
        }
        throw new Exception("No puede haber campos vacios");
    }

    private boolean validarNegativo(Double n) throws Exception {
        if (n > 0) {
            return true;
        }
        throw new Exception("No puede haber numero negativo");
    }

    private void recuperarCampos() throws NumberFormatException, Exception {
        this.codigo = this.tfBarCode.getText();
        this.nombre = this.tfName.getText();
        this.descripcion = this.tfDescription.getText();
        this.precioCosto = Double.parseDouble(this.tfPriceCost.getText());
        this.ganancia = Double.parseDouble(this.tfGanancia.getText());
        this.mayoreo = Double.parseDouble(this.tfWholePrice.getText());
        this.idDepartamento = this.cbDepartment.getSelectedIndex() + 1;

        this.ocuparInventario = recuperarInventario(); //falta modificar
        if (ocuparInventario == 1) {
            this.cantidad = Double.parseDouble(this.tfTotal.getText());
            validarNegativo(this.cantidad);
        }
    }

    private void validarForm() throws NumberFormatException, Exception {
        if (validarCadena(this.codigo) && validarCadena(this.nombre)
                && validarCadena(this.descripcion) && validarNegativo(this.precioCosto)
                && validarNegativo(this.ganancia) && validarNegativo(this.mayoreo)) {
            producto.setCodigo(this.codigo);
            producto.setNombre(this.nombre);
            producto.setPrecioCosto(this.precioCosto);
            producto.setGanancia(this.ganancia);
            producto.setMayoreo(this.mayoreo);
            producto.setDescripcion(descripcion);
            producto.setIdDepartamento(idDepartamento);
            producto.setOcupaInventario(ocuparInventario);
            if (cantidad > 0) {
                producto.setCantidad(this.cantidad);
            }

        }
    }

    //insertar informacion a la tabla
    private void eventoInsertar() {
        this.btnCreate.addActionListener(e -> {
            try {
                recuperarCampos();
                validarForm();
                int reg = productoDao.insertar(producto);
                System.out.println("reg = " + reg);
                if (reg > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha insertado los datos correctamente");
                }
            } catch (NumberFormatException ex) {

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }

    //Actualizar informacion
    private void eventoActualizar() {
        this.btnUpdate.addActionListener(e -> {
            System.out.println("Evento para actualizar la informacion");
            try {
                recuperarCampos();
                validarForm();
                int reg = productoDao.actualizar(producto);
                if (reg > 0) {
                    JOptionPane.showMessageDialog(null, "Se han actualizado los datos correctamente");
                }
            } catch (NumberFormatException ex) {

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    //eliminar informacion
    private void eventoEliminar() {
        this.btnCancel.addActionListener(e -> {
            System.out.println("Evento para eliminar el objeto de la BD");
            try {
                recuperarCampos();
                validarForm();
                int reg = productoDao.eliminar(producto);
                if (reg > 0) {
                    JOptionPane.showMessageDialog(null, "Se ha elinado el producto de la BD de datos");
                }
                limpiarForm();
            } catch (NumberFormatException ex) {

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jlBarCode = new javax.swing.JLabel();
        jlDescription = new javax.swing.JLabel();
        jlPriceCost = new javax.swing.JLabel();
        jlRevenue = new javax.swing.JLabel();
        jlSalePrice = new javax.swing.JLabel();
        jlWholeSalePrice = new javax.swing.JLabel();
        jlDepartment = new javax.swing.JLabel();
        tfBarCode = new javax.swing.JTextField();
        tfDescription = new javax.swing.JTextField();
        tfPriceCost = new javax.swing.JTextField();
        tfSalePrice = new javax.swing.JTextField();
        tfWholePrice = new javax.swing.JTextField();
        cbDepartment = new javax.swing.JComboBox<>();
        cbInventory = new javax.swing.JCheckBox();
        jlTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        linea1 = new javax.swing.JSeparator();
        linea2 = new javax.swing.JSeparator();
        linea3 = new javax.swing.JSeparator();
        linea4 = new javax.swing.JSeparator();
        linea5 = new javax.swing.JSeparator();
        linea6 = new javax.swing.JSeparator();
        linea8 = new javax.swing.JSeparator();
        jlTitle = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        linea9 = new javax.swing.JSeparator();
        linea10 = new javax.swing.JSeparator();
        tfGanancia = new javax.swing.JTextField();
        linea11 = new javax.swing.JSeparator();
        linea12 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jlBarCode.setText("Codigo de Producto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlBarCode, gridBagConstraints);

        jlDescription.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlDescription, gridBagConstraints);

        jlPriceCost.setText("Precio Costo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlPriceCost, gridBagConstraints);

        jlRevenue.setText("Ganancia (%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlRevenue, gridBagConstraints);

        jlSalePrice.setText("PrecioVenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlSalePrice, gridBagConstraints);

        jlWholeSalePrice.setText("Precio Mayoreo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlWholeSalePrice, gridBagConstraints);

        jlDepartment.setText("Departamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlDepartment, gridBagConstraints);

        tfBarCode.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfBarCode, gridBagConstraints);

        tfDescription.setText("Galletas sabor Coco");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfDescription, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfPriceCost, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfSalePrice, gridBagConstraints);

        tfWholePrice.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfWholePrice, gridBagConstraints);

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(cbDepartment, gridBagConstraints);

        cbInventory.setText("Este producto Utiliza Inventario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(cbInventory, gridBagConstraints);

        jlTotal.setText("Cantidad a registrar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlTotal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfTotal, gridBagConstraints);

        btnCancel.setText("Eliminar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(24, 35, 24, 35);
        add(btnCancel, gridBagConstraints);

        btnCreate.setText("Registrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(24, 46, 24, 46);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Actualizar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(24, 46, 24, 46);
        add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(linea8, gridBagConstraints);

        jlTitle.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 25, 0);
        add(jlTitle, gridBagConstraints);

        jlName.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlName, gridBagConstraints);

        tfName.setText("Galletes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(linea10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfGanancia, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea12, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JCheckBox cbInventory;
    private javax.swing.JLabel jlBarCode;
    private javax.swing.JLabel jlDepartment;
    private javax.swing.JLabel jlDescription;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPriceCost;
    private javax.swing.JLabel jlRevenue;
    private javax.swing.JLabel jlSalePrice;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlWholeSalePrice;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea10;
    private javax.swing.JSeparator linea11;
    private javax.swing.JSeparator linea12;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea8;
    private javax.swing.JSeparator linea9;
    private javax.swing.JTextField tfBarCode;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfGanancia;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPriceCost;
    private javax.swing.JTextField tfSalePrice;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfWholePrice;
    // End of variables declaration//GEN-END:variables
}
