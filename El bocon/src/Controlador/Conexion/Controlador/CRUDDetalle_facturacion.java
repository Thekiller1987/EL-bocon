/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;
import Controlador.Conexion.conexion;
import Modelo.POJODetalle_facturacion;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Milton
 */
public class CRUDDetalle_facturacion {
    
     private final conexion con = new conexion();
     private final Connection cn = (Connection)con.conectar();
     
     public DefaultTableModel mostrarDatos(){
         
     ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_producto", "id_facturacion", "cantidad"};
        
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        
        try{
             CallableStatement cbstc = cn.prepareCall("{call MostrarDetalle_facturacion}");
        rs = cbstc.executeQuery();
        
        
        while (rs.next())
             registro[0] = rs.getString("id_producto");
             registro[1] = rs.getString("id_facturacion");
             registro[2] = rs.getString("cantidad");
             
              modelo.addRow(registro);   
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        return null;
        }
         return null;
     }
    
       public DefaultTableModel buscarDatos(String dato){
           ResultSet rs;
          DefaultTableModel modelo;
          
          String[] titulos = {"id_producto","id_facturacion","cantidad"};
       String[] registro = new String[3];           
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement call = cn.prepareCall("{call ConsultarDetalle_facturacion(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            
              while (rs.next()){
                  
               registro[0] = rs.getString("id_producto");
               registro[1] = rs.getString("id_facturacion");
               registro[2] = rs.getString("cantidad");
               
               modelo.addRow(registro); 
               
              }
            return modelo;
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        return null; 
       }
          
       }
       
       public void eliminar(String id_Detalle_facturacion){
           try{
               CallableStatement cbst = cn.prepareCall("{call EliminarDetalle_facturacion(?)}");
              cbst.setString(1, id_Detalle_facturacion);
              cbst.executeUpdate();
           }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
       }
       
       
         public void actualizar(POJODetalle_facturacion dt){
             try{
                 CallableStatement cbst = cn.prepareCall("{call CrearDetalle_facturacion(?,?,?,?)}");
                  cbst.setInt(dt.getId_producto(),1);
                  cbst.setInt(dt.getId_facturacion(), 2);
                  cbst.setInt(dt.getCantidad(), 3);
                  
                   cbst.executeUpdate();
                 
                 
             }catch (SQLException e){
                     JOptionPane.showMessageDialog(null, e);
                     }
         }
         
         
        public void Guardar(POJODetalle_facturacion dt){
            try{
                 CallableStatement cbst = cn.prepareCall("{call Creardeatlle_facturacion(?,?,?,?)}");
                 
                 cbst.setInt(dt.getId_producto(),1);
                 cbst.setInt(dt.getId_facturacion(), 2);
                 cbst.setInt(dt.getCantidad(), 3);
                  
                 cbst.executeUpdate();
                 
            }catch (SQLException e){
                 JOptionPane.showMessageDialog(null, e);
            }
            
        }
         
        public boolean verificarDatos(String dato){
            ResultSet rs;
            try{
                CallableStatement call = cn.prepareCall("{call ConsultarDetalle_facturacion(?)}");
                  call.setString(1, dato);
          rs = call.executeQuery();
          return rs.next();
            }catch (SQLException e){
                 JOptionPane.showMessageDialog(null, e);
            } return false;
        }
}
