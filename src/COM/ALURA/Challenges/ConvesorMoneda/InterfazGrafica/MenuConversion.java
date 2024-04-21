package COM.ALURA.Challenges.ConvesorMoneda.InterfazGrafica;

import COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos.ControladorArchivos;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.ConsultorExchangeRate_API;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.ConversorERAPI;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Divisa;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuConversion extends javax.swing.JFrame {
    private ControladorArchivos controlArchivo;
    /**
     * Creates new form MenuConversion
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */
    public MenuConversion() throws FileNotFoundException {
        initComponents();
        controlArchivo = new ControladorArchivos();
        try {
            controlArchivo.inciarArchivo();
        }catch (InterruptedException | IOException ex) {
            Logger.getLogger(MenuConversion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaMonedaBase.removeAllItems();
        listaMonedaObjectivo.removeAllItems();
        var divisas = controlArchivo.cargarDivisasAdmitidas(controlArchivo.obtenerRutaDivisasAdmitidasErapi());
        divisas.forEach((item) -> {
            listaMonedaBase.addItem(item.toString());
            listaMonedaObjectivo.addItem(item.toString());
        });
    }
    
    private static String generarMensajeConversion(Conversion conversor, String nombreDivisaBase, String nombreDivisaObjectivo){
        return String.format("%,.2f",conversor.getImporte()) + " " + nombreDivisaBase + " = \n"
                    + String.format("%,.2f",conversor.importeConvertido()) + " " + nombreDivisaObjectivo + "\n"
                    + "Razon de cambio: \n"
                    + "1 " + conversor.getCodigoDivisaBase() + " = " + conversor.getTasaCambio() + " " + conversor.getCodigoDivisaObjectivo() + "\n"
                    + "1 " + conversor.getCodigoDivisaObjectivo() + " = " + (1/conversor.getTasaCambio()) + " " + conversor.getCodigoDivisaBase() + "\n";
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listaMonedaBase = new javax.swing.JComboBox<>();
        listaMonedaObjectivo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        salidaConversion = new javax.swing.JTextArea();
        ingresoImporte = new javax.swing.JTextField();
        btnCambiarDivisas = new javax.swing.JButton();
        btnConvertir = new javax.swing.JButton();
        tituloIngresoImporte = new javax.swing.JLabel();
        tituloDivisaBase = new javax.swing.JLabel();
        tituloDivisaObjectivo = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 217, 234));

        listaMonedaBase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listaMonedaObjectivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        salidaConversion.setColumns(20);
        salidaConversion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        salidaConversion.setRows(5);
        jScrollPane1.setViewportView(salidaConversion);

        ingresoImporte.setText("0");
        ingresoImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ingresoImporteKeyTyped(evt);
            }
        });

        btnCambiarDivisas.setText("Cambiar");
        btnCambiarDivisas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarDivisasActionPerformed(evt);
            }
        });

        btnConvertir.setText("Convertir");
        btnConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertirActionPerformed(evt);
            }
        });

        tituloIngresoImporte.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tituloIngresoImporte.setText("Importe");

        tituloDivisaBase.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tituloDivisaBase.setText("De:");

        tituloDivisaObjectivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tituloDivisaObjectivo.setText("a");

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/COM/ALURA/Challenges/ConvesorMoneda/Imagenes/IconoExchangeRateApi.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConvertir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloIngresoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloDivisaBase)
                            .addComponent(listaMonedaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCambiarDivisas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloDivisaObjectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaMonedaObjectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloIngresoImporte)
                    .addComponent(tituloDivisaBase)
                    .addComponent(tituloDivisaObjectivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaMonedaObjectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarDivisas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listaMonedaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnConvertir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void btnCambiarDivisasActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String divisaBase = (String) listaMonedaBase.getSelectedItem();
        listaMonedaBase.setSelectedItem(listaMonedaObjectivo.getSelectedItem());
        listaMonedaObjectivo.setSelectedItem(divisaBase);
    }                                                 

    private void btnConvertirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            // Obtengo las razon de conversion
            String divisaBase = (String) listaMonedaBase.getSelectedItem();
            String divisaObjectivo = (String) listaMonedaObjectivo.getSelectedItem();
            String codigoDivisaBase = divisaBase.substring(0,3);
            String codigoDivisaObjectivo = divisaObjectivo.substring(0,3);
            String json = ConsultorExchangeRate_API.obtenerConversionDivisas(codigoDivisaBase,codigoDivisaObjectivo);
            
            
            // Creo mi objecto para convertir
            Gson gson = new Gson();
            ConversorERAPI c = gson.fromJson(json,ConversorERAPI.class);
            Conversion conversion = new Conversion(c, Double.parseDouble(ingresoImporte.getText()));
            controlArchivo.guardarConversion(conversion,controlArchivo.obtenerRutaHistorial());
            
            //System.out.println(conversion);
            
            // Muestro en pantalla
            salidaConversion.setText(generarMensajeConversion(conversion, divisaBase, divisaObjectivo));
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }                                            

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Historial ventanaHistorial = new Historial();
        ventanaHistorial.setVisible(true);
        this.dispose();
    }                                                                                           

    private void ingresoImporteKeyTyped(java.awt.event.KeyEvent evt) {                                        
       // Obtener el caracter ingresado
       char caracter = evt.getKeyChar();

       // Obtener el texto actual en el campo
       String texto = ingresoImporte.getText();

       // Validar si el caracter ingresado no es un dígito o si ya hay un punto
       if ((!Character.isDigit(caracter) && caracter != '.') || (caracter == '.' && texto.contains("."))) {
           // El caracter ingresado no es válido, mostrar un mensaje de advertencia
           JOptionPane.showMessageDialog(this, "Por favor, ingrese solo números y máximo un punto decimal", "Advertencia", JOptionPane.WARNING_MESSAGE);

           // Consumir el evento para que el caracter no sea ingresado en el campo de texto
           evt.consume();
       }
    }                                       

    public void recibirConversion(Conversion conversion) throws FileNotFoundException{
        var divisas = controlArchivo.cargarDivisasAdmitidas(controlArchivo.obtenerRutaDivisasAdmitidasErapi());
        for(Divisa d : divisas){
            if(d.toString().substring(0, 3).equals(conversion.getCodigoDivisaBase())){
                listaMonedaBase.setSelectedItem(d.toString());
            }
            if(d.toString().substring(0, 3).equals(conversion.getCodigoDivisaObjectivo())){
                listaMonedaObjectivo.setSelectedItem(d.toString());
            }
        }
        ingresoImporte.setText(String.valueOf(conversion.getImporte()));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuConversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConversion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //System.out.println(a);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MenuConversion().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuConversion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCambiarDivisas;
    private javax.swing.JButton btnConvertir;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JTextField ingresoImporte;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> listaMonedaBase;
    private javax.swing.JComboBox<String> listaMonedaObjectivo;
    private javax.swing.JTextArea salidaConversion;
    private javax.swing.JLabel tituloDivisaBase;
    private javax.swing.JLabel tituloDivisaObjectivo;
    private javax.swing.JLabel tituloIngresoImporte;
    // End of variables declaration                   
}
