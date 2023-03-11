package administrador;

import Principal.Login;
import configuracion.Configuracion;
import administrador.FormUser;

/**
 *
 * @author Root
 */
public class FormMainAdmi extends javax.swing.JFrame {

    public FormMainAdmi() {
        initComponents();
        agregarEstilos();
    }

    public void agregarEstilos() {
        Configuracion.styles(this);
        Configuracion.normal(this.menuUser, this.menuProduct, this.menuMain, this.menuSettings, this.menuCompany);
        Configuracion.normal(this.opcAddUser, this.opcUpdateUser, this.opcListUser);
        Configuracion.normal(this.opcAddProduct, this.opcUpdateProduct, this.opcListProduct, this.opcListProductOut);
        Configuracion.normal(this.btnClose);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnClose = new javax.swing.JButton();
        menuMain = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        opcAddUser = new javax.swing.JMenuItem();
        opcUpdateUser = new javax.swing.JMenuItem();
        opcListUser = new javax.swing.JMenuItem();
        menuProduct = new javax.swing.JMenu();
        opcAddProduct = new javax.swing.JMenuItem();
        opcUpdateProduct = new javax.swing.JMenuItem();
        opcListProduct = new javax.swing.JMenuItem();
        opcListProductOut = new javax.swing.JMenuItem();
        menuCompany = new javax.swing.JMenu();
        menuSettings = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        btnClose.setText("Cerrar Sesion");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(385, 439, 29, 29);
        getContentPane().add(btnClose, gridBagConstraints);

        menuUser.setText("Administrar Usuarios");

        opcAddUser.setText("Registrar Usuario");
        opcAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAddUserActionPerformed(evt);
            }
        });
        menuUser.add(opcAddUser);

        opcUpdateUser.setText("Modificar Usuario");
        opcUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcUpdateUserActionPerformed(evt);
            }
        });
        menuUser.add(opcUpdateUser);

        opcListUser.setText("Listar Usuaruio");
        menuUser.add(opcListUser);

        menuMain.add(menuUser);

        menuProduct.setText("Administrar Productos");

        opcAddProduct.setText("Registrar Producto");
        opcAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAddProductActionPerformed(evt);
            }
        });
        menuProduct.add(opcAddProduct);

        opcUpdateProduct.setText("Modificar Producto");
        opcUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcUpdateProductActionPerformed(evt);
            }
        });
        menuProduct.add(opcUpdateProduct);

        opcListProduct.setText("Listar Productos");
        menuProduct.add(opcListProduct);

        opcListProductOut.setText("Listar Productos Agotados");
        menuProduct.add(opcListProductOut);

        menuMain.add(menuProduct);

        menuCompany.setText("Gestionar Información de la Empresa");
        menuMain.add(menuCompany);

        menuSettings.setText("Configuraciones");
        menuMain.add(menuSettings);

        setJMenuBar(menuMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAddProductActionPerformed
        try {
            FormProduct product = new FormProduct(this, true);
            product.setVisible(true);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_opcAddProductActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void opcAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAddUserActionPerformed
        try {
            FormUser user = new FormUser(this, true);
            user.setVisible(true);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_opcAddUserActionPerformed

    private void opcUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcUpdateUserActionPerformed
        
    }//GEN-LAST:event_opcUpdateUserActionPerformed

    private void opcUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcUpdateProductActionPerformed
        try {
            FormBarCodeUpdate update = new FormBarCodeUpdate(this, true);
            update.setVisible(true);
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_opcUpdateProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JMenu menuCompany;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuProduct;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JMenu menuUser;
    private javax.swing.JMenuItem opcAddProduct;
    private javax.swing.JMenuItem opcAddUser;
    private javax.swing.JMenuItem opcListProduct;
    private javax.swing.JMenuItem opcListProductOut;
    private javax.swing.JMenuItem opcListUser;
    private javax.swing.JMenuItem opcUpdateProduct;
    private javax.swing.JMenuItem opcUpdateUser;
    // End of variables declaration//GEN-END:variables
}
