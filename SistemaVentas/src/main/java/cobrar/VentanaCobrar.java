package cobrar;

import com.cashiers.ControladorCajero;
import com.services.graphicServices.RecursosService;
import com.settings.ObjGraficosService;
import com.settings.Recursos;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaCobrar extends JDialog{
    private String total;
    private JFrame ventana;
    private JPanel panelSuperior,panelPrincipal,panelBotones;
    private ObjGraficosService sObjGraficos;
    private Recursos sRecursos;
    private JLabel jlEfectivo, jlMetodoDePago,jlTarjeta,jlTransferencia,jlTotalPagar,jlTotal,jlTotalEnPalabras,jlPagaCon, jlAceptar, jlCancelar;
    private ImageIcon iEfectivo, iDimAux,iTarjeta, iTransferencia, iAceptar, iCancelar;
    private JTextField tPagaCon;
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    public VentanaCobrar(JFrame parent, boolean modal, String total){
        super(parent, modal);
        this.total = total;
        this.ventana = ventana;
        obtenerServicios();
        iniciarComponentes();
        this.add(panelSuperior);
        this.add(panelPrincipal);
        this.add(panelBotones);
        eventos();
        this.setVisible(modal);
    }
    private void eventos(){
        jlAceptar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try
                {
                    
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        
        jlCancelar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try
                {
                    dispose();
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void obtenerServicios() {
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = Recursos.getService();
    }
    public void iniciarComponentes(){
        confPanel();
        crearJTextField();
        crearIconos();
        crearJLabels();
        colocarEnLayout();
    }
    
    private void crearIconos(){
        iEfectivo = new ImageIcon("src/main/resources/com.cobrar/efectivo.png");
        iTarjeta = new ImageIcon("src/main/resources/com.cobrar/tarjeta.png");
        iTransferencia = new ImageIcon("src/main/resources/com.cobrar/transferencia.png");
        iAceptar = new ImageIcon("src/main/resources/com.cobrar/aceptar.png");
        iCancelar  = new ImageIcon("src/main/resources/com.cobrar/cancelar.png");
    }
    
    private void crearJTextField(){
        tPagaCon = sObjGraficos.construirJTextField(null, 0, 0, 100, 15,
                sRecursos.getFontTitulo2(), Color.WHITE, sRecursos.getColorPrincipal(), sRecursos.getColorGrisOscuro(),
                sRecursos.getBorderInferiorAzul(), "c");
    }
    
    private void crearJLabels(){
        jlMetodoDePago = sObjGraficos.construirJLabel("Método de pago", 0, 0, 200, 20,null, null, sRecursos.getFontTPrincipal(), null, Color.white, null, "c");
        jlTotalPagar = sObjGraficos.construirJLabel("Total a pagar", 0, 0, 600, 20,null, null, sRecursos.getFontTPrincipal(),Color.white, Color.black, null, "c");
        jlTotal = sObjGraficos.construirJLabel(total, 0, 0, 100, 20,null, null, sRecursos.getFontTPrincipal(), null, Color.BLACK, null, "c");
        jlTotalEnPalabras = sObjGraficos.construirJLabel("("+sRecursos.convertToWords(sRecursos.removeFirstCharacter(total))+" MX$)", 0, 0, 100, 20,null, null, sRecursos.getFontTPrincipal(), Color.white, Color.black, null, "c");
        jlPagaCon = sObjGraficos.construirJLabel("Paga con $", 0, 0, 100, 20,null, null, sRecursos.getFontTitulo2(), Color.white, Color.black, null, "r");
        
        iDimAux = new ImageIcon(
                iEfectivo.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlEfectivo = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,null, iDimAux, null, null, null, null, "z");
        jlEfectivo.setToolTipText("En efectivo");
        
        iDimAux = new ImageIcon(
                iTarjeta.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlTarjeta = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,null, iDimAux, null, null, null, null, "z");
        jlTarjeta.setToolTipText("Con tarjeta");
        
        iDimAux = new ImageIcon(
                iTransferencia.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlTransferencia = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,null, iDimAux, null, null, null, null, "z");
        jlTransferencia.setToolTipText("Por transferencia");
        
        iDimAux = new ImageIcon(
                iAceptar.getImage()
                        .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        jlAceptar = sObjGraficos.construirJLabel(null, 0, 0, 45, 45,null, iDimAux, null, null, null, null, "c");
        jlAceptar.setHorizontalAlignment(SwingConstants.CENTER);
        jlAceptar.setVerticalAlignment(SwingConstants.CENTER);
        jlAceptar.setToolTipText("Realizar venta");
        
        iDimAux = new ImageIcon(
                iCancelar.getImage()
                        .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        jlCancelar = sObjGraficos.construirJLabel(null, 0, 0, 45, 45,null, iDimAux, null, Color.white, null, null, "c");
        jlCancelar.setHorizontalAlignment(SwingConstants.CENTER);
        jlCancelar.setVerticalAlignment(SwingConstants.CENTER);
        jlCancelar.setToolTipText("Cancelar venta");
    }
    
    private void colocarEnLayout(){
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        //gbc.ipady = 50;
        panelSuperior.add(jlMetodoDePago, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        panelSuperior.add(jlEfectivo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        panelSuperior.add(jlTarjeta, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        panelSuperior.add(jlTransferencia, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        //gbc.ipady = 50;
        //gbc.ipadx = 50;
        panelPrincipal.add(jlTotalPagar, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.ipady = 50;
        //gbc.ipadx = 50;
        panelPrincipal.add(jlTotal, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        gbc.ipady = 70;
        //gbc.ipadx = 50;
        panelPrincipal.add(jlTotalEnPalabras, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 0;
        panelPrincipal.add(jlPagaCon, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 80;
        panelPrincipal.add(tPagaCon, gbc);
        
        gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 80;
        panelBotones.add(jlCancelar, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipadx = 80;
        panelBotones.add(jlAceptar, gbc);
    }
    
    private void confPanel(){
        this.setSize(800,500);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        panelSuperior = sObjGraficos.construirJPanel(0, 0, 200, 500, new Color(39,54,77), null);
        panelSuperior.setLayout(gbl);
                
        panelPrincipal = sObjGraficos.construirJPanel(200, 0, 600, 350, Color.white, null);
        panelPrincipal.setLayout(gbl);
        
        panelBotones = sObjGraficos.construirJPanel(200, 350, 600, 150, Color.white, null);
        panelBotones.setLayout(gbl);
    }
}
