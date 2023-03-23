/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;
import com.settings.Configuracion;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import com.classes.DatosFalsos;
import com.settings.CodigoColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author RojeruSan
 */
public class PanelProducto extends javax.swing.JPanel {
    private ButtonGroup groupRadioBtn;
    
    public PanelProducto() {
        initComponents();
        configuracion();
        agregarEstilos();
        
    }
    
    private void agregarEstilos() {
        //configuracion de la ventana 
        this.setMinimumSize(new Dimension(650, 600));
        this.setSize(new Dimension(650, 600));
        
        //configuracion al JPanel
         Configuracion.background(CodigoColor.cFondoGris, this); 
        
        //configuracion JLabel
        //titulo
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul,this.jlTitle);
        Configuracion.robotoBold20(this.jlTitle);
        //demas datos
        Configuracion.robotoItalic14(this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost,this.jlRevenue, 
                this.jlSale, this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice, this.jlName);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost,
                this.jlRevenue, this.jlSale, this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice, this.jlName);
        
        //configuraicon JTextField
        Configuracion.robotoPlain12(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,this.tfWholePrice, this.tfName);
        Configuracion.withoutBorde(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal, this.tfWholePrice, this.tfName);
        Configuracion.background(CodigoColor.cFondoGris,this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, 
                this.tfTotal,this.tfWholePrice, this.tfName); 
        Configuracion.foreground(CodigoColor.cLetrasTextField,this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, 
                this.tfTotal,this.tfWholePrice, this.tfName);
        
        //configuracion JSeparator
        Configuracion.foreground(CodigoColor.cSeparatorRed, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea8, this.linea9, this.linea10);
        
        
        //configuracion JButton
        Configuracion.robotoItalic14(this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.background(CodigoColor.cFondoBtnAzul, this.btnCancel, this.btnCreate, this.btnUpdate);
        
        //configuraicion JComboBox 
        Configuracion.robotoItalic14(this.cbDepartment);
        Configuracion.withoutBorde(this.cbDepartment);
        Configuracion.foreground(CodigoColor.cLetrasNegro,this.cbDepartment);
        Configuracion.background(CodigoColor.cFondoGris,this.cbDepartment);
        
        //configuracion JRadioButton
        Configuracion.robotoItalic14(this.rbGranel, this.rbUnit);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.rbGranel, this.rbUnit);
        Configuracion.background(CodigoColor.cFondoGris,this.rbGranel, this.rbUnit);
        
        //configuracion JCheckBox
        Configuracion.robotoItalic14(this.cbInventory);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.cbInventory);
        Configuracion.background(CodigoColor.cFondoGris,this.cbInventory);
        
        
        //configuracion JSpinner
        

    }

    private void configuracion() {
        agregarRadioBotones();
        estadoTfTotal();
        checkBoxEventItemListener();
        listDesplegable();
        confSpinner();
    }

    private void agregarRadioBotones() {
        try {
            groupRadioBtn = new ButtonGroup();
            groupRadioBtn.add(this.rbGranel);
            groupRadioBtn.add(this.rbUnit);
        } catch (Exception ex) {

        }
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
        dcbm.addElement(DatosFalsos.p1.getDepartamento().getDepartamento());

        dcbm.addElement(DatosFalsos.p2.getDepartamento().getDepartamento());
        dcbm.addElement(DatosFalsos.p3.getDepartamento().getDepartamento());
        dcbm.addElement(DatosFalsos.p4.getDepartamento().getDepartamento());
        this.cbDepartment.setModel(dcbm);
        this.cbDepartment.getEditor().getEditorComponent().setForeground(CodigoColor.cLetrasNegro); 
        this.cbDepartment.getEditor().getEditorComponent().setBackground(CodigoColor.cFondoGris); 
    }

    private void confSpinner() {
        SpinnerNumberModel snm = new SpinnerNumberModel(0, 0, 300, 10);
        this.sRevenue.setModel(snm);
        this.sRevenue.getEditor().getComponent(0).setForeground(CodigoColor.cLetrasNegro);
        this.sRevenue.getEditor().getComponent(0).setBackground(CodigoColor.cFondoGris);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jlBarCode = new javax.swing.JLabel();
        jlDescription = new javax.swing.JLabel();
        jlSale = new javax.swing.JLabel();
        jlPriceCost = new javax.swing.JLabel();
        jlRevenue = new javax.swing.JLabel();
        jlSalePrice = new javax.swing.JLabel();
        jlWholeSalePrice = new javax.swing.JLabel();
        jlDepartment = new javax.swing.JLabel();
        tfBarCode = new javax.swing.JTextField();
        tfDescription = new javax.swing.JTextField();
        rbUnit = new javax.swing.JRadioButton();
        rbGranel = new javax.swing.JRadioButton();
        tfPriceCost = new javax.swing.JTextField();
        tfSalePrice = new javax.swing.JTextField();
        tfWholePrice = new javax.swing.JTextField();
        sRevenue = new javax.swing.JSpinner();
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

        setLayout(new java.awt.GridBagLayout());

        jlBarCode.setText("Codigo de Barra: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlBarCode, gridBagConstraints);

        jlDescription.setText("Descripcion: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlDescription, gridBagConstraints);

        jlSale.setText("Se vende: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlSale, gridBagConstraints);

        jlPriceCost.setText("Precio Costo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlPriceCost, gridBagConstraints);

        jlRevenue.setText("Ganancia (%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlRevenue, gridBagConstraints);

        jlSalePrice.setText("PrecioVenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlSalePrice, gridBagConstraints);

        jlWholeSalePrice.setText("Precio Mayoreo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlWholeSalePrice, gridBagConstraints);

        jlDepartment.setText("Departamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfDescription, gridBagConstraints);

        rbUnit.setText("Por Unidad/Pza");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(rbUnit, gridBagConstraints);

        rbGranel.setText("A granel (usa Decimales)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(rbGranel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfPriceCost, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfSalePrice, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfWholePrice, gridBagConstraints);

        sRevenue.setModel(new javax.swing.SpinnerNumberModel());
        sRevenue.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(sRevenue, gridBagConstraints);

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(cbDepartment, gridBagConstraints);

        cbInventory.setText("Este producto Utiliza Inventario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(cbInventory, gridBagConstraints);

        jlTotal.setText("Cantidad a registrar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlTotal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfTotal, gridBagConstraints);

        btnCancel.setText("Registrar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 10, 10);
        add(btnCancel, gridBagConstraints);

        btnCreate.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 10, 10);
        add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Eliminar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 10, 10);
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
        gridBagConstraints.gridy = 7;
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
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 65);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(jlName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 5);
        add(tfName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        add(linea9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(linea10, gridBagConstraints);
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
    private javax.swing.JLabel jlSale;
    private javax.swing.JLabel jlSalePrice;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlWholeSalePrice;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea10;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea8;
    private javax.swing.JSeparator linea9;
    private javax.swing.JRadioButton rbGranel;
    private javax.swing.JRadioButton rbUnit;
    private javax.swing.JSpinner sRevenue;
    private javax.swing.JTextField tfBarCode;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPriceCost;
    private javax.swing.JTextField tfSalePrice;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfWholePrice;
    // End of variables declaration//GEN-END:variables
}
