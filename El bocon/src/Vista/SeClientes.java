/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import javax.swing.JOptionPane;


/**
 *
 * @author waska
 */
public class SeClientes extends javax.swing.JFrame {

    /**
     * Creates new form SeClientes
     */
    public SeClientes() {
        initComponents();
rsscalelabel.RSScaleLabel.setScaleLabel(fondoSec,"src/vista.imagenes/background login.png");
          this.setResizable(false);
          this.setLocation(450 ,350);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seclientes = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        editar1 = new javax.swing.JButton();
        fondoSec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seclientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregar.setBackground(new java.awt.Color(1, 17, 29));
        agregar.setForeground(new java.awt.Color(102, 255, 102));
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/añadir.png"))); // NOI18N
        agregar.setText("Añadir");
        agregar.setActionCommand("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        seclientes.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, 110));

        cerrar.setBackground(new java.awt.Color(0, 0, 0));
        cerrar.setForeground(new java.awt.Color(255, 0, 0));
        cerrar.setText("Regresar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        seclientes.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 90, 30));

        editar1.setBackground(new java.awt.Color(1, 17, 29));
        editar1.setForeground(new java.awt.Color(51, 51, 255));
        editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        editar1.setText("Editar");
        editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar1ActionPerformed(evt);
            }
        });
        seclientes.add(editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 91, 140, 110));
        seclientes.add(fondoSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 280));

        getContentPane().add(seclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
     try {
        clientes panel2 = new clientes()
                ;
        panel2.setVisible(true);
        this.dispose();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al mostrar el panel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);   

// TODO add your handling code here:
    }
    }//GEN-LAST:event_agregarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
  try {
        lobby panel2 = new lobby()
                ;
        panel2.setVisible(true);
        this.dispose();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al mostrar el panel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarActionPerformed

    private void editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar1ActionPerformed
            try {
        clientes2 panel2 = new clientes2()
                ;
        panel2.setVisible(true);
        this.dispose();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al mostrar el panel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);   
        // TODO add your handling code here:
    }
    }//GEN-LAST:event_editar1ActionPerformed

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
            java.util.logging.Logger.getLogger(SeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton editar1;
    private javax.swing.JLabel fondoSec;
    private javax.swing.JPanel seclientes;
    // End of variables declaration//GEN-END:variables
}

        
    
