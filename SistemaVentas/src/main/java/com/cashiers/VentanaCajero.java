package com.cashiers;

/**
 *
 * @author Alberto
 */


import com.settings.CodigoColor;
import com.main.Login;
import com.settings.Configuracion;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class VentanaCajero extends javax.swing.JFrame {

    public VentanaCajero() {
        initComponents();
        AgregarConfiguración ();
        //Configuracion.styles(this);
        setIconImage(new ImageIcon(getClass().getResource("/images/ventass.png")).getImage());
        setVisible(true);
    }
    
    private void AgregarConfiguración () {
    
        //Configuracion Ventana()
        
        Configuracion.styles(this);
        this.setExtendedState(this.NORMAL);
        
        //Configuracion al JPanel()
        
         Configuracion.background(CodigoColor.cFondo, this.JPanelPrincipal);
         Configuracion.background(CodigoColor.cFondoizq, this.jPanelIzq);
         
        
        //Configuracion JLabel()
        
        Configuracion.titulo( this.jLabelTituloP);
        Configuracion.foreground(CodigoColor.cLetrasTituloAzul, this.jLabelTituloP);
        Configuracion.foreground(CodigoColor.cLetrasNegro, this.jLabelTituloP);
        
        
        Configuracion.foreground(CodigoColor.cLetrasNegro,this.jLabelProducto, this.jLabelCantidad, 
                this.jLabelPrecio, this.jLabelImporte, this.jLabelSubtotal,this.jLabelTotal,jLabelIva);
        Configuracion.robotoItalic14(this.jLabelProducto, this.jLabelCantidad, 
                this.jLabelPrecio, this.jLabelImporte, this.jLabelSubtotal,this.jLabelTotal,jLabelIva);
        Configuracion.foreground(CodigoColor.cLetrasNegro,this.jLabelProducto, this.jLabelCantidad, 
                this.jLabelPrecio, this.jLabelImporte, this.jLabelSubtotal,this.jLabelTotal,jLabelIva);
       
        //Configurar JTextField()
        
        Configuracion.robotoItalic14(this.jTextFieldPrecio, this.jTextFieldImporte,this.jTextFieldSubtotal,this.totaldecompra,this.jTextFieldIVA);
        Configuracion.withoutBorde(this.jTextFieldPrecio, this.jTextFieldImporte,this.jTextFieldSubtotal,this.totaldecompra,this.jTextFieldIVA);
        Configuracion.background(CodigoColor.cFondoGris,this.jTextFieldPrecio, this.jTextFieldImporte,this.jTextFieldSubtotal,this.totaldecompra,this.jTextFieldIVA); 
        Configuracion.foreground(CodigoColor.cLetrasTextField,this.jTextFieldPrecio, this.jTextFieldImporte,this.jTextFieldSubtotal,this.totaldecompra,this.jTextFieldIVA);
            
        //Configuración En JButton ()
        
        Configuracion.robotoPlain16(this.jButtonRegistro,this.jButtonCobrar,this.jButtonCancelar,this.jButtonSalir);
        Configuracion.foreground(CodigoColor.cLetrasBtnBlanco, this.jButtonRegistro,this.jButtonCobrar,this.jButtonCancelar,this.jButtonSalir);
        Configuracion.background(CodigoColor.cFondoBtnAzul1, this.jButtonRegistro,this.jButtonCobrar,this.jButtonCancelar,this.jButtonSalir);
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        JPanelPrincipal = new javax.swing.JPanel();
        jLabelProducto = new javax.swing.JLabel();
        jComboBoxSelecProduc = new javax.swing.JComboBox<>();
        jLabelCantidad = new javax.swing.JLabel();
        jComboBoxCantidad = new javax.swing.JComboBox<>();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelImporte = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCajero = new javax.swing.JTable();
        jTextFieldImporte = new javax.swing.JTextField();
        jPanelIzq = new javax.swing.JPanel();
        jLabelTituloP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonRegistro = new javax.swing.JButton();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabelSubtotal = new javax.swing.JLabel();
        jTextFieldSubtotal = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        totaldecompra = new javax.swing.JTextField();
        jLabelIva = new javax.swing.JLabel();
        jTextFieldIVA = new javax.swing.JTextField();
        jButtonCobrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COBRAR COMPRA");
        setBackground(new java.awt.Color(255, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.yellow);
        setLocation(new java.awt.Point(90, 40));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1400, 800));

        JPanelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPanelPrincipal.setMinimumSize(new java.awt.Dimension(1210, 700));
        JPanelPrincipal.setPreferredSize(new java.awt.Dimension(1400, 800));

        jLabelProducto.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelProducto.setText("Producto:");

        jComboBoxSelecProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxSelecProduc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Un Producto:", "Mayonesa", "Tortillas", "Aguacate", "Galletas", "Sabrita", "Agua", "Leche", "Miel", "Alcohol", " " }));
        jComboBoxSelecProduc.setBorder(null);
        jComboBoxSelecProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecProducActionPerformed(evt);
            }
        });

        jLabelCantidad.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelCantidad.setText("Cantidad:");

        jComboBoxCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        jLabelPrecio.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelPrecio.setText("Precio:");

        jLabelImporte.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelImporte.setText("Importe:");

        jTableCajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableCajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCTO", "PRECIO", "CANTIDAD", "IMPORTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCajero.setGridColor(new java.awt.Color(255, 255, 153));
        jTableCajero.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTableCajero.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jTableCajero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCajero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableCajero);

        jTextFieldImporte.setText("$ ");

        jLabelTituloP.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabelTituloP.setForeground(new java.awt.Color(51, 51, 255));
        jLabelTituloP.setText("CAJERO");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/George/1649339.png"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(350, 300));

        jButtonRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRegistro.setForeground(new java.awt.Color(0, 0, 255));
        jButtonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venta.png"))); // NOI18N
        jButtonRegistro.setText("      Registrar Compra");
        jButtonRegistro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });
        jButtonRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonRegistroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIzqLayout = new javax.swing.GroupLayout(jPanelIzq);
        jPanelIzq.setLayout(jPanelIzqLayout);
        jPanelIzqLayout.setHorizontalGroup(
            jPanelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzqLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIzqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIzqLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTituloP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanelIzqLayout.setVerticalGroup(
            jPanelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIzqLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTituloP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTextFieldPrecio.setText("$ ");
        jTextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioActionPerformed(evt);
            }
        });

        jLabelSubtotal.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelSubtotal.setText("Subtotal:");

        jTextFieldSubtotal.setText("$ ");
        jTextFieldSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSubtotalActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelTotal.setText("Total:");

        totaldecompra.setText("$ ");
        totaldecompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaldecompraActionPerformed(evt);
            }
        });

        jLabelIva.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabelIva.setText("IVA:");

        jTextFieldIVA.setText("                         %");

        jButtonCobrar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButtonCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoVCobrar.png"))); // NOI18N
        jButtonCobrar.setText("    COBRAR");
        jButtonCobrar.setBorder(null);
        jButtonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCobrarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jButtonCancelar.setText("  CANCELAR");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        jButtonSalir.setText("  SALIR");
        jButtonSalir.setBorder(null);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelPrincipalLayout = new javax.swing.GroupLayout(JPanelPrincipal);
        JPanelPrincipal.setLayout(JPanelPrincipalLayout);
        JPanelPrincipalLayout.setHorizontalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxSelecProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(jLabelImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jTextFieldIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(totaldecompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jButtonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        JPanelPrincipalLayout.setVerticalGroup(
            JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(JPanelPrincipalLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSelecProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totaldecompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(JPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("COBRAR COMPRA");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSelecProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSelecProducActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        try
        {
            dispose();
            Login ventana = new Login();
            ventana.setVisible(true);
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCobrarActionPerformed
        try{
            RegistrarCompra pago = new RegistrarCompra(this, true);
            pago.setVisible(true);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButtonCobrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try
        {
            
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void totaldecompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaldecompraActionPerformed
        // TODO add your handling code here:
        
        String totalfinal = totaldecompra.getText();
            
            String resultado = " - El total de compras es: "+totalfinal;
            
            JOptionPane.showMessageDialog(null,resultado);
    }//GEN-LAST:event_totaldecompraActionPerformed

    private void jTextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioActionPerformed

    private void jButtonRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonRegistroKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonRegistroKeyPressed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        // TODO add your handling code here:
        RegistrarCompra pago = new RegistrarCompra(this, true);
        pago.setVisible(true);
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jTextFieldSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSubtotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCobrar;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxCantidad;
    private javax.swing.JComboBox<String> jComboBoxSelecProduc;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelImporte;
    private javax.swing.JLabel jLabelIva;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelTituloP;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanelIzq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCajero;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldIVA;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldSubtotal;
    private javax.swing.JTextField totaldecompra;
    // End of variables declaration//GEN-END:variables
}
