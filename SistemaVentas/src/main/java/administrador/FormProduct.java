package administrador;

import configuracion.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import Objetos.DatosFalsos;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Peter
 */
public class FormProduct extends javax.swing.JDialog {

    private ButtonGroup groupRadioBtn;

    public FormProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configuracion();
        agregarEstilos();
    }

    private void agregarEstilos() {
        this.setMinimumSize(new Dimension(650, 600));
        this.setSize(new Dimension(650, 600));
        //this.panel.setBackground(new Color(224,225,221));
        //this.linea1.setBackground(new Color(94,159,163));

        Configuracion.styles(this);
        Configuracion.titulo(jlTitle);
        Configuracion.normalItalic(this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost,
                this.jlRevenue, this.jlSale, this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice);
        Configuracion.normal(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,
                this.tfWholePrice);
        Configuracion.normalItalic(this.rbGranel, this.rbUnit);
        Configuracion.normalItalic(this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.normalItalic(this.cbInventory, this.cbDepartment);

        //Quitar el borde a los text Field
        Configuracion.borde(this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,
                this.tfWholePrice, this.sRevenue, this.cbDepartment);

        //configuracion para establecer el foreground
        //color azul fuerte
        Color color = new Color(29, 53, 87);
        Configuracion.foreground(color, this.jlBarCode, this.jlDepartment, this.jlDescription, this.jlPriceCost,
                this.jlRevenue, this.jlSale, this.jlSalePrice, this.jlTotal, this.jlWholeSalePrice, this.jlTitle);

        Configuracion.foreground(color, this.rbGranel, this.rbUnit);
        Configuracion.foreground(color, this.btnCancel, this.btnCreate, this.btnUpdate);
        Configuracion.foreground(color, this.cbInventory, this.cbDepartment);

        //color rojo fuerte
        color = new Color(230, 57, 70);
        Configuracion.foreground(color, this.linea1, this.linea2, this.linea3, this.linea4, this.linea5, this.linea6,
                this.linea8);

        //color blanco crema
        color = new Color(241, 250, 238);
        Configuracion.background(color, this.panel, this.tfBarCode, this.tfDescription, this.tfPriceCost, this.tfSalePrice, this.tfTotal,
                this.tfWholePrice, this.sRevenue, this.cbDepartment);
        Configuracion.background(color, this.btnCancel, this.btnCreate, this.btnUpdate, this.rbGranel, this.rbUnit,
                this.cbInventory, this.sRevenue);
        Configuracion.foreground(color, this.btnCancel, this.btnCreate, this.btnUpdate);

        //color azul bajo
        color = new Color(168, 218, 220);
        //color azul intermedio
        color = new Color(69, 123, 157);
        Configuracion.background(color, this.btnCancel, this.btnCreate, this.btnUpdate);

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
        this.cbDepartment.getEditor().getEditorComponent().setForeground(new Color(29, 53, 87)); 
        this.cbDepartment.getEditor().getEditorComponent().setBackground(new Color(241, 250, 238)); 
    }

    private void confSpinner() {
        SpinnerNumberModel snm = new SpinnerNumberModel(0, 0, 300, 10);
        this.sRevenue.setModel(snm);
        this.sRevenue.getEditor().getComponent(0).setForeground(new Color(29, 53, 87));
        this.sRevenue.getEditor().getComponent(0).setBackground(new Color(241, 250, 238));
    }

    public static void main(String[] args) {
        FormProduct vProduct = new FormProduct(new JFrame(), true);
        vProduct.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        jlTitle.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 17, 20, 17);
        panel.add(jlTitle, gridBagConstraints);

        jlBarCode.setText("Codigo de Barra: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(jlBarCode, gridBagConstraints);

        jlDescription.setText("Descripcion: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(jlDescription, gridBagConstraints);

        jlSale.setText("Se vende: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        panel.add(jlSale, gridBagConstraints);

        jlPriceCost.setText("Precio Costo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panel.add(jlPriceCost, gridBagConstraints);

        jlRevenue.setText("Ganancia (%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(jlRevenue, gridBagConstraints);

        jlSalePrice.setText("PrecioVenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(jlSalePrice, gridBagConstraints);

        jlWholeSalePrice.setText("Precio Mayoreo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(jlWholeSalePrice, gridBagConstraints);

        jlDepartment.setText("Departamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        panel.add(jlDepartment, gridBagConstraints);

        tfBarCode.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(tfBarCode, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(tfDescription, gridBagConstraints);

        rbUnit.setText("Por Unidad/Pza");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        panel.add(rbUnit, gridBagConstraints);

        rbGranel.setText("A granel (usa Decimales)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        panel.add(rbGranel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panel.add(tfPriceCost, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(tfSalePrice, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(tfWholePrice, gridBagConstraints);

        sRevenue.setModel(new javax.swing.SpinnerNumberModel());
        sRevenue.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 10);
        panel.add(sRevenue, gridBagConstraints);

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        panel.add(cbDepartment, gridBagConstraints);

        cbInventory.setText("Este producto Utiliza Inventario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        panel.add(cbInventory, gridBagConstraints);

        jlTotal.setText("Cantidad a registrar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panel.add(jlTotal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panel.add(tfTotal, gridBagConstraints);

        btnCancel.setText("Regresar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(51, 0, 51, 0);
        panel.add(btnCancel, gridBagConstraints);

        btnCreate.setText("Registrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.insets = new java.awt.Insets(51, 0, 51, 0);
        panel.add(btnCreate, gridBagConstraints);

        btnUpdate.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(51, 0, 51, 0);
        panel.add(btnUpdate, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea6, gridBagConstraints);

        linea8.setBackground(new java.awt.Color(51, 51, 255));
        linea8.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        panel.add(linea8, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
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
    private javax.swing.JLabel jlPriceCost;
    private javax.swing.JLabel jlRevenue;
    private javax.swing.JLabel jlSale;
    private javax.swing.JLabel jlSalePrice;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlWholeSalePrice;
    private javax.swing.JSeparator linea1;
    private javax.swing.JSeparator linea2;
    private javax.swing.JSeparator linea3;
    private javax.swing.JSeparator linea4;
    private javax.swing.JSeparator linea5;
    private javax.swing.JSeparator linea6;
    private javax.swing.JSeparator linea8;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton rbGranel;
    private javax.swing.JRadioButton rbUnit;
    private javax.swing.JSpinner sRevenue;
    private javax.swing.JTextField tfBarCode;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfPriceCost;
    private javax.swing.JTextField tfSalePrice;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfWholePrice;
    // End of variables declaration//GEN-END:variables
}
