/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;
import Controlador.Conexion.conexion;
import Modelo.POJOFacturacion;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Milton
 */
public class CRUDFacturacion {
    
     private final conexion con = new conexion();
     private final Connection cn = (Connection)con.conectar();
     
     public DefaultTableModel mostrarDatos(){
         
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_producto,id_facturacion,cantidad"};
        
        String[] registro = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        
        try{
             CallableStatement cbstc = cn.prepareCall("{call obtenerDetalle}");
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
          
           String[] titulos = {"id_facturacion","Date_fecha","DNI","id_empleado",};
       String[] registro = new String[4];           
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement call = cn.prepareCall("{call Consultarfacturacion(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            
           while (rs.next()){
               
               registro[0] = rs.getString("id_facturacion");
               registro[1] = rs.getString("Date_fecha");
               registro[2] = rs.getString("DNI");
               registro[3] = rs.getString("id_empleado");
               
                modelo.addRow(registro); 
               
           }
            return modelo;
       }catch (Exception e){
              JOptionPane.showMessageDialog(null, e);
        return null; 
               
    }      
     }
       public void eliminar(String id_facturacion){
      
           try{
               CallableStatement cbst = cn.prepareCall("{call EliminarFacturacion(?)}");
              cbst.setString(1, id_facturacion);
              cbst.executeUpdate();
           }catch (SQLException e){
                JOptionPane.showMessageDialog(null, e);
           }
           
       }
     
        public void actualizar(POJOFacturacion fc){
            try{
                CallableStatement cbst = cn.prepareCall("{call CrearFacturacion(?,?,?,?)}");
                cbst.setInt(fc.getId_facturacion(), 1);
                cbst.setString(2, fc.getFecha());
                cbst.executeUpdate();
            }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);   
            }
            
            
        }
       
        public void Guardar(POJOFacturacion fc){
            try{
                CallableStatement cbst = cn.prepareCall("{call InsertarFacturacion(?,?)}");
                cbst.setInt(fc.getId_facturacion(), 1);
                cbst.setString(2, fc.getFecha());
                cbst.executeUpdate();
                
                
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
      
         public boolean verificarDatos(String dato){
             ResultSet rs;
             try{
                CallableStatement call = cn.prepareCall("{call ConsultarFacturacion(?)}");
                  call.setString(1, dato);
          rs = call.executeQuery();
          return rs.next();
                 
             }catch (SQLException e){
                  JOptionPane.showMessageDialog(null, e);
             }return false;
         }
        
     }
