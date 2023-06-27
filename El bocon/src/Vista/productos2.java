/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Conexion.Controlador.CRUDProducto;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import Modelo.POJOProducto;
import Modelo.POJOCategoria;
import java.util.ArrayList;


/**
 *
 * @author waska
 */
public class productos2 extends javax.swing.JFrame {

    int datoSeleccionado = -1;
    int id;
    
    /**
     * Creates new form prueba
     */
    public productos2() {
       
        initComponents();
Mostrar();
 setExtendedState(MAXIMIZED_BOTH);
 rsscalelabel.RSScaleLabel.setScaleLabel(fondo, "src/vista.imagenes/background formulario.png");
 
    }
 
 
 

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btneditar = new javax.swing.JButton();
        btncerrar1 = new javax.swing.JButton();
        nombre = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        preciov = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        precio = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cantidad = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        alcohol = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(390, 200));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Noimbre del Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jLabel6.setText("Descripcion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        btneliminar.setForeground(new java.awt.Color(255, 0, 0));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 690, 100, 40));

        btnactualizar.setForeground(new java.awt.Color(0, 51, 255));
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 690, 100, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Editar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 360, -1));

        btneditar.setForeground(new java.awt.Color(0, 255, 51));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        getContentPane().add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 690, 100, 40));

        btncerrar1.setText("Regresar");
        btncerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btncerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 690, 100, 40));

        try {
            nombre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 350, 30));

        jLabel3.setText("Precio de Compra");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        preciov.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        preciov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciovActionPerformed(evt);
            }
        });
        getContentPane().add(preciov, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 350, -1));

        jLabel5.setText("Precio de venta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });
        getContentPane().add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 350, -1));

        jLabel7.setText("Cantidad");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        cantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 100, -1));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane2.setViewportView(descripcion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 350, 60));

        alcohol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        alcohol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alcoholActionPerformed(evt);
            }
        });
        getContentPane().add(alcohol, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 40, -1));

        jLabel8.setText("% de Alchohol");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaproductos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, 170));

        fondo.setAutoscrolls(true);
        fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 1590, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
     if (datoSeleccionado >= 0) {
String dato =
String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 0));
CRUDProducto producto = new CRUDProducto();
if (JOptionPane.showConfirmDialog(rootPane,
"Se eliminará el registro, ¿desea continuar?",

"Eliminar Registro",
JOptionPane.WARNING_MESSAGE,
JOptionPane.YES_NO_OPTION)
== JOptionPane.YES_OPTION) {

producto.eliminar(dato);
Mostrar();
JOptionPane.showMessageDialog(null,
"Dato eliminado correctamente");
}
} else {
JOptionPane.showMessageDialog(null,
"Debe seleccionar un registro de la tabla");

        
        
    }//GEN-LAST:event_btneliminarActionPerformed
    }
    private void btncerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrar1ActionPerformed
   this.dispose();  
              
   
   
   
   
   
    }//GEN-LAST:event_btncerrar1ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed

         MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("*************************"); //Definir la mascara
            formatter.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "); //Definir los caracteres validos
        } catch (ParseException e) {
            e.printStackTrace();
        
        }  
    }//GEN-LAST:event_nombreActionPerformed

    private void preciovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciovActionPerformed
      
        
        
    }//GEN-LAST:event_preciovActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        
        
        
        
        
    }//GEN-LAST:event_precioActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á'//minusculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayusculas
                && car != 'Ë'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ñ'
                && car != 'ñ'
                && car != 'Ü'
                && car != 'ü'
                && (car != (char) KeyEvent.VK_SPACE)){
        
        evt.consume();}
        
// TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped
 
    
    
    
    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
  if (datoSeleccionado >= 0) {
        // Obtener los datos seleccionados en la tabla
        id = Integer.parseInt((String)this.tablaproductos.getValueAt(datoSeleccionado, 0));
        String nombre = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 1));
        String descripcion = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 2));
        String precioCompra = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 3));
        String precioVenta = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 4));
        String porcentajeAlcohol = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 5));
        String cantidad = String.valueOf(tablaproductos.getValueAt(datoSeleccionado, 6));

        // Rellenar los campos del formulario con los datos seleccionados
  
        this.nombre.setText(nombre);
        this.descripcion.setText(descripcion);
        this.precio.setText(precioCompra);
        this.preciov.setText(precioVenta);
        this.alcohol.setText(porcentajeAlcohol);
        this.cantidad.setText(cantidad);
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
    
}     
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
try {
    // Obtener los datos ingresados por el usuario
    String nombreProducto = nombre.getText();
    String descripcionProducto = descripcion.getText();
    String precioCompra = precio.getText();
    String precioVenta = preciov.getText();
    String porcentajeAlcohol = alcohol.getText();
    String Cantidad = cantidad.getText();
 
    // Verificar si hay campos vacíos
    if (nombreProducto.trim().isEmpty() || descripcionProducto.trim().isEmpty() || precioCompra.trim().isEmpty() || precioVenta.trim().isEmpty() || porcentajeAlcohol.trim().isEmpty() || Cantidad.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Tiene campos vacíos");
    } else {
        // Crear un objeto del producto con los datos ingresados
        POJOProducto producto = new POJOProducto(id, nombreProducto, descripcionProducto, precioCompra, precioVenta, porcentajeAlcohol, Cantidad);

        // Crear una instancia del CRUDProducto
        CRUDProducto crudProducto = new CRUDProducto();

        // Llamar al método actualizar del CRUDProducto para actualizar los datos en la base de datos
        crudProducto.actualizar(producto);

        // Llamar al método mostrar() para actualizar la tabla de productos
        Mostrar();

        JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
        limpiarCampos();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error: " + e);
}
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void alcoholActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alcoholActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alcoholActionPerformed

    private void tablaproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproductosMouseClicked
datoSeleccionado = tablaproductos.rowAtPoint(evt.getPoint());        // TODO add your handling code here:
    }//GEN-LAST:event_tablaproductosMouseClicked


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
            java.util.logging.Logger.getLogger(productos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new productos2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFormattedTextField alcohol;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncerrar1;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JFormattedTextField cantidad;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField nombre;
    private javax.swing.JFormattedTextField precio;
    private javax.swing.JFormattedTextField preciov;
    public javax.swing.JTable tablaproductos;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Mostrar() {
try {
    DefaultTableModel modelo;
CRUDProducto cli = new CRUDProducto(); //objeto de la clase Crudproveedor
modelo = cli.mostrarDatos();
tablaproductos.setModel(modelo);
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}

}
    }