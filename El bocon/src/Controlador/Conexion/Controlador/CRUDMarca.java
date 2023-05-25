/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
import Modelo.POJOMarca;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milton
 */
public class CRUDMarca {
    
     private final conexion con = new conexion();
     private final Connection cn = (Connection)con.conectar();
     
     public DefaultTableModel mostrarDatos(){
         ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_marca", "nombre"};
        
         String[] registro = new String[2];
        modelo = new DefaultTableModel(null, titulos);
        
        try{
             CallableStatement cbstc = cn.prepareCall("{call MostrarMarca}");
        rs = cbstc.executeQuery();
        
        while (rs.next())
            registro[0] = rs.getString("id_marca");
            registro[1] = rs.getString("nombre");
            
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
          
       String[] titulos = {"id_marca","nombre"};
       String[] registro = new String[2];           
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement call = cn.prepareCall("{call ConsultarMarca(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            
            while (rs.next()){
            registro[0] = rs.getString("id_marca");
            registro[1] = rs.getString("nombre");
            
            modelo.addRow(registro); 
                
                
            }
            return modelo;
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        return null; 
       }
       
     }
     
     public void eliminar(String id_marca){
         try{
             CallableStatement cbst = cn.prepareCall("{call Eliminarid_marca(?)}");
              cbst.setString(1, id_marca);
              cbst.executeUpdate();
         }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
                 
     }
    
     public void actualizar(POJOMarca mr){
         try{
             CallableStatement cbst = cn.prepareCall("{call CrearMarca(?,?)}");
             cbst.setInt(mr.getId_marca(), 1);
             cbst.setString(2, mr.getNombre());
             
             cbst.executeUpdate();
         }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     
     
     public void Guardar(POJOMarca mr){
         try{
              CallableStatement cbst = cn.prepareCall("{call Creardeatlle_facturacion(?,?)}");
              cbst.setInt(mr.getId_marca(), 1);
              cbst.setString(2, mr.getNombre());
              
              
              cbst.executeUpdate();
         }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
     }
     
     public boolean verificarDatos(String dato){
         ResultSet rs;
         try{
             CallableStatement call = cn.prepareCall("{call ConsultarMarca(?)}");
                  call.setString(1, dato);
                  
                  rs = call.executeQuery();
          return rs.next();
         }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);
         }return false;
     }
     
}
