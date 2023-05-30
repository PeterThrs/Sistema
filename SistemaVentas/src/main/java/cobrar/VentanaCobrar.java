package cobrar;

import com.settings.ObjGraficosService;
import com.settings.Recursos;
import static com.settings.Recursos.removeFirstCharacter;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaCobrar extends JDialog{
    private String total;
    private JFrame ventana;
    private JPanel panelSuperior,panelPrincipal,panelBotones,panelPago;
    private ObjGraficosService sObjGraficos;
    private Recursos sRecursos;
    private JLabel jlEfectivo, jlMetodoDePago,jlTarjeta,jlTransferencia,jlTotalPagar,jlTotal,jlTotalEnPalabras,jlPagaCon, jlAceptar, jlCancelar,jlCambio;
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
        this.add(panelPago);
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
        
         tPagaCon.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarCambio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarCambio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarCambio();
            }
        });
    }
    
    private void actualizarCambio() {
        try {
            // Obtener el valor del pago ingresado
            double pago = Double.parseDouble(tPagaCon.getText());

            // Realizar el cálculo del cambio
            double cambio = pago-Double.parseDouble(removeFirstCharacter(total));

            DecimalFormat df = new DecimalFormat("#.00");
            String numeroRedondeado = df.format(cambio);
            
            // Actualizar el texto del JLabel con el cambio calculado
            jlCambio.setText("Cambio = $" + numeroRedondeado);
        } catch (NumberFormatException ex) {
            // Si el valor ingresado no es un número válido, mostrar un mensaje de error
            jlCambio.setText("Cambio = $0.00");
        }
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
        jlCambio = sObjGraficos.construirJLabel("Cambio = $0.00", 0, 0, 50, 15,null, null, sRecursos.getFontTitulo2(), Color.white, Color.black, null, "r");
        
        iDimAux = new ImageIcon(
                iEfectivo.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlEfectivo = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,sRecursos.getCMano(), iDimAux, null, null, null, null, "z");
        jlEfectivo.setToolTipText("En efectivo");
        
        iDimAux = new ImageIcon(
                iTarjeta.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlTarjeta = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,sRecursos.getCMano(), iDimAux, null, null, null, null, "z");
        jlTarjeta.setToolTipText("Con tarjeta");
        
        iDimAux = new ImageIcon(
                iTransferencia.getImage()
                        .getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING)
        );
        jlTransferencia = sObjGraficos.construirJLabel(null, 0, 0, 40, 40,sRecursos.getCMano(), iDimAux, null, null, null, null, "z");
        jlTransferencia.setToolTipText("Por transferencia");
        
        iDimAux = new ImageIcon(
                iAceptar.getImage()
                        .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        jlAceptar = sObjGraficos.construirJLabel(null, 0, 0, 45, 45,sRecursos.getCMano(), iDimAux, null, null, null, null, "c");
        jlAceptar.setHorizontalAlignment(SwingConstants.CENTER);
        jlAceptar.setVerticalAlignment(SwingConstants.CENTER);
        jlAceptar.setToolTipText("Realizar venta");
        
        iDimAux = new ImageIcon(
                iCancelar.getImage()
                        .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        jlCancelar = sObjGraficos.construirJLabel(null, 0, 0, 45, 45,sRecursos.getCMano(), iDimAux, null, Color.white, null, null, "c");
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
        gbc.ipady = 50;
        //gbc.ipadx = 50;
        panelPrincipal.add(jlTotalEnPalabras, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 0;
        panelPago.add(jlPagaCon, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 80;
        panelPago.add(tPagaCon, gbc);
        
        gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipady = 50;
        gbc.ipadx = 150;
        panelBotones.add(jlCancelar, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipadx = 80;
        panelBotones.add(jlAceptar, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.ipadx = 10;
        panelBotones.add(jlCambio, gbc);
    }
    
    private void confPanel(){
        this.setSize(800,500);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        
        panelSuperior = sObjGraficos.construirJPanel(0, 0, 200, 500, new Color(39,54,77), null);
        panelSuperior.setLayout(gbl);
                
        panelPrincipal = sObjGraficos.construirJPanel(200, 0, 600, 200, Color.white, null);
        panelPrincipal.setLayout(gbl);
        
        panelPago = sObjGraficos.construirJPanel(200, 200, 600, 150, Color.white, null);
        panelPago.setLayout(gbl);
        
        panelBotones = sObjGraficos.construirJPanel(200, 350, 600, 150, Color.white, null);
        panelBotones.setLayout(gbl);
    }
}
