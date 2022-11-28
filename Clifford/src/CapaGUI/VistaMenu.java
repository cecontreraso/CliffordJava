/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author valay
 */
public class VistaMenu extends javax.swing.JFrame {
        /*Centrado 
    public VistaMenu(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
    */
    
    
    public static String rut_empleado = "";
    
    public void redireccionarVentana() throws SQLException{
        NegocioCargo control = new NegocioCargo();
        VistaTrabajador ventana1 = new VistaTrabajador();
        VistaAdministrador ventana2 = new VistaAdministrador();
        int cargo = control.consultarCargo(rut_empleado);

        if (cargo == 1) {
            ventana1.setVisible(true);
            this.dispose();
        } else if (cargo == 2) {
            ventana2.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un usuario válido");
        }
    }
    
    /**
     * Creates new form VistaMenu
     */
    public VistaMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_rut = new javax.swing.JTextField();
        jLabelBienvenida = new javax.swing.JLabel();
        jLabelRut = new javax.swing.JLabel();
        bto_ingresar = new javax.swing.JButton();
        bto_salir = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/banner.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 150));

        txt_rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutActionPerformed(evt);
            }
        });
        txt_rut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rutKeyTyped(evt);
            }
        });
        getContentPane().add(txt_rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 140, 30));

        jLabelBienvenida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelBienvenida.setText("¡Bienvenido!");
        getContentPane().add(jLabelBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 160, 60));

        jLabelRut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRut.setText("Rut");
        getContentPane().add(jLabelRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 50, 40));

        bto_ingresar.setText("Ingresar");
        bto_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(bto_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        bto_salir.setText("Salir");
        bto_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_salirActionPerformed(evt);
            }
        });
        getContentPane().add(bto_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 79, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/FondoGrande.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-490, -40, 1430, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bto_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ingresarActionPerformed
        // TODO add your handling code here:
       //validarTrabajador();
       
       rut_empleado = txt_rut.getText();
        try {
            redireccionarVentana();
        } catch (SQLException ex) {
            Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_bto_ingresarActionPerformed

    private void bto_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bto_salirActionPerformed

    private void txt_rutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rutActionPerformed

    private void txt_rutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutKeyTyped
        // TODO add your handling code here:
        if(txt_rut.getText().length()>9)
        {
            evt.consume();
            
        }
    }//GEN-LAST:event_txt_rutKeyTyped

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bto_ingresar;
    private javax.swing.JButton bto_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBienvenida;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelRut;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
