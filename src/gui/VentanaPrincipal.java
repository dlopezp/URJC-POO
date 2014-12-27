package gui;

import formula.*;

/**
 *
 * @author HOME3
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.jPanelAdministrador.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jBtAccesoAdministrador = new javax.swing.JButton();
        jPanelAdministrador = new javax.swing.JPanel();
        jBtAdminVolver = new javax.swing.JButton();
        jTbAdministrador = new javax.swing.JTabbedPane();
        jPanelAdminPilotos = new javax.swing.JPanel();
        jBtCargarPilotos = new javax.swing.JButton();
        jBtCrearPiloto = new javax.swing.JButton();
        jPanelCrearPiloto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtFieldPilotoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtFieldPilotoApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtFieldPilotoEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtFieldPilotoAltura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtFieldPilotoPeso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtFieldPilotoReflejos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtFieldPilotoAgresividad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtFieldPilotoPaciencia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtFieldPilotoValentia = new javax.swing.JTextField();
        jBtCaracteristicasPilotoAleatorias = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jLabel4.setText("jLabel4");

        jLabel8.setText("jLabel8");

        jTextField9.setText("jTextField9");

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(444, 389));

        jBtAccesoAdministrador.setText("Acceso Administrador");
        jBtAccesoAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAccesoAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jBtAccesoAdministrador)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAccesoAdministrador)
                .addContainerGap(377, Short.MAX_VALUE))
        );

        jBtAdminVolver.setText("Volver");
        jBtAdminVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdminVolverActionPerformed(evt);
            }
        });

        jBtCargarPilotos.setText("Cargar");

        jBtCrearPiloto.setText("Crear");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Edad");

        jLabel5.setText("Altura");

        jLabel6.setText("Peso");

        jLabel7.setText("Reflejos");

        jLabel9.setText("Agresividad");

        jLabel10.setText("Paciencia");

        jLabel12.setText("Valentía");

        jBtCaracteristicasPilotoAleatorias.setText("Generar Aleatorio");
        jBtCaracteristicasPilotoAleatorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCaracteristicasPilotoAleatoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCrearPilotoLayout = new javax.swing.GroupLayout(jPanelCrearPiloto);
        jPanelCrearPiloto.setLayout(jPanelCrearPilotoLayout);
        jPanelCrearPilotoLayout.setHorizontalGroup(
            jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearPilotoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtFieldPilotoNombre)
                    .addComponent(jTxtFieldPilotoApellidos)
                    .addComponent(jTxtFieldPilotoEdad)
                    .addComponent(jTxtFieldPilotoAltura)
                    .addComponent(jTxtFieldPilotoPeso)
                    .addGroup(jPanelCrearPilotoLayout.createSequentialGroup()
                        .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtFieldPilotoReflejos, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jTxtFieldPilotoAgresividad)
                            .addComponent(jTxtFieldPilotoPaciencia)
                            .addComponent(jTxtFieldPilotoValentia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtCaracteristicasPilotoAleatorias, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCrearPilotoLayout.setVerticalGroup(
            jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearPilotoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtFieldPilotoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFieldPilotoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtFieldPilotoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtFieldPilotoAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtFieldPilotoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCrearPilotoLayout.createSequentialGroup()
                        .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTxtFieldPilotoReflejos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTxtFieldPilotoAgresividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTxtFieldPilotoPaciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCrearPilotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTxtFieldPilotoValentia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBtCaracteristicasPilotoAleatorias, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAdminPilotosLayout = new javax.swing.GroupLayout(jPanelAdminPilotos);
        jPanelAdminPilotos.setLayout(jPanelAdminPilotosLayout);
        jPanelAdminPilotosLayout.setHorizontalGroup(
            jPanelAdminPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminPilotosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtCargarPilotos)
                    .addComponent(jBtCrearPiloto))
                .addGap(18, 18, 18)
                .addComponent(jPanelCrearPiloto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAdminPilotosLayout.setVerticalGroup(
            jPanelAdminPilotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminPilotosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBtCargarPilotos)
                .addGap(18, 18, 18)
                .addComponent(jBtCrearPiloto)
                .addContainerGap(229, Short.MAX_VALUE))
            .addComponent(jPanelCrearPiloto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTbAdministrador.addTab("Pilotos", jPanelAdminPilotos);

        javax.swing.GroupLayout jPanelAdministradorLayout = new javax.swing.GroupLayout(jPanelAdministrador);
        jPanelAdministrador.setLayout(jPanelAdministradorLayout);
        jPanelAdministradorLayout.setHorizontalGroup(
            jPanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdministradorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAdminVolver)
                .addContainerGap())
            .addComponent(jTbAdministrador)
        );
        jPanelAdministradorLayout.setVerticalGroup(
            jPanelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdministradorLayout.createSequentialGroup()
                .addComponent(jTbAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtAdminVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAdminVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdminVolverActionPerformed
        this.jPanelPrincipal.setVisible(true);
        this.jPanelAdministrador.setVisible(false);        
    }//GEN-LAST:event_jBtAdminVolverActionPerformed

    private void jBtAccesoAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAccesoAdministradorActionPerformed
        this.jPanelPrincipal.setVisible(false);
        this.jPanelAdministrador.setVisible(true);
    }//GEN-LAST:event_jBtAccesoAdministradorActionPerformed

    private void jBtCaracteristicasPilotoAleatoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCaracteristicasPilotoAleatoriasActionPerformed
        Double valorMaximo = PilotoLibre.VALOR_MAXIMO_CARACTERISTICAS;
        Double reflejos = Math.random() * valorMaximo;
        this.jTxtFieldPilotoReflejos.setText(reflejos.toString());
    }//GEN-LAST:event_jBtCaracteristicasPilotoAleatoriasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAccesoAdministrador;
    private javax.swing.JButton jBtAdminVolver;
    private javax.swing.JButton jBtCaracteristicasPilotoAleatorias;
    private javax.swing.JButton jBtCargarPilotos;
    private javax.swing.JButton jBtCrearPiloto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAdminPilotos;
    private javax.swing.JPanel jPanelAdministrador;
    private javax.swing.JPanel jPanelCrearPiloto;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JTabbedPane jTbAdministrador;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTxtFieldPilotoAgresividad;
    private javax.swing.JTextField jTxtFieldPilotoAltura;
    private javax.swing.JTextField jTxtFieldPilotoApellidos;
    private javax.swing.JTextField jTxtFieldPilotoEdad;
    private javax.swing.JTextField jTxtFieldPilotoNombre;
    private javax.swing.JTextField jTxtFieldPilotoPaciencia;
    private javax.swing.JTextField jTxtFieldPilotoPeso;
    private javax.swing.JTextField jTxtFieldPilotoReflejos;
    private javax.swing.JTextField jTxtFieldPilotoValentia;
    // End of variables declaration//GEN-END:variables
}
