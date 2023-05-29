 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
import Modelo.POJOProducto;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Milton
 */


public class CRUDProducto {
    
    
     private final conexion con = new conexion();
    private final Connection cn = (Connection)con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_producto", "nombre", "cantidad", "precio", "descripcion","porcentaje_alcohol","id_proveedor","id_marca","id_categoria"};
        
         String[] registro = new String[6];
    modelo = new DefaultTableModel(null, titulos);
    
    try{
         CallableStatement cbstc = cn.prepareCall("{call MostrarProducto}");
        rs = cbstc.executeQuery();
        
         while (rs.next()){
            registro[0] = rs.getString("id_producto");
            registro[1] = rs.getString("nombre");
            registro[2] = rs.getString("cantidad");
            registro[3] = rs.getString("precio");
            registro[4] = rs.getString("descripcion");
            registro[5] = rs.getString("porcentaje_alcohol");
            registro[6] = rs.getString("id_proveedor");
            registro[7] = rs.getString("id_marca");
            registro[8] = rs.getString("id_categoria");
            
            modelo.addRow(registro);
            
         }
         
         return modelo;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
        
    }
    
    public DefaultTableModel buscarDatos(String dato){
        
        ResultSet rs;
       DefaultTableModel modelo;
       
       
        String[] titulos = {"id_producto","nombre","cantidad","precio","descripcion","porcentaje_alcohol","id_proveedor","id_marca","id_categoria"};
       String[] registro = new String[5];           
       modelo = new DefaultTableModel(null, titulos);
       
       try{
           CallableStatement call = cn.prepareCall("{call ConsultarProducto(?)}");
    call.setString(1, dato);
    rs = call.executeQuery();
    
        while (rs.next()){
        registro[0] = rs.getString("id_producto");
            registro[1] = rs.getString("nombre");
            registro[2] = rs.getString("cantidad");
            registro[3] = rs.getString("precio");
            registro[4] = rs.getString("descripcion");
            registro[5] = rs.getString("porcentaje_alcohol");
            registro[6] = rs.getString("id_proveedor");
            registro[7] = rs.getString("id_marca");
            registro[8] = rs.getString("id_categoria");
            
             modelo.addRow(registro);
        
        
    }
        return modelo;
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
        return null;
       }
        
    }
    
      public void eliminar(String id_producto){
          try{
              CallableStatement cbst = cn.prepareCall("{call EliminarProducto(?)}");
cbst.setString(1, id_producto);
cbst.executeUpdate();
          }catch (SQLException e){
              JOptionPane.showMessageDialog(null, e);
          }
      }
      
      
      
       public void actualizar(POJOProducto pro){
           try{
               CallableStatement cbst = cn.prepareCall("{callModificarPro(?,?,?,?,?,?,?,?,?)})");
            cbst.setInt(pro.getId_producto(), 1);
            cbst.setString(2, pro.getNombre());
            cbst.setInt(pro.getCantidad(),3);
            cbst.setInt((int) pro.getPrecio(), 4);
            cbst.setString(5, pro.getDescripcion());
            cbst.setInt((int)pro.getPorcentaje_alcohol(), 6);
            cbst.setInt(pro.getId_proveedor(), 7);
            cbst.setInt(pro.getId_marca(), 8);
            cbst.setInt(pro.getId_categoria(), 9);
            cbst.executeUpdate();
           }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
               
       }
    
       
       public void Guardar(POJOProducto pro){
   try {
        CallableStatement cbst = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?,?,?)}");
        cbst.setInt(1, pro.getId_producto());
        cbst.setString(2, pro.getNombre());
        cbst.setInt(3, pro.getCantidad());
        cbst.setDouble(4, pro.getPrecio());
        cbst.setString(5, pro.getDescripcion());
        cbst.setDouble(6, pro.getPorcentaje_alcohol());
        cbst.setInt(7, pro.getId_proveedor());
        cbst.setInt(8, pro.getId_marca());
        cbst.setInt(9, pro.getId_categoria());
        cbst.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);

           }
       }
       
       
        public boolean verificarDatos(String dato){
             ResultSet rs;
             try{
                  CallableStatement call = cn.prepareCall("{call ConsultarProducto(?)}");
          call.setString(1, dato);
          rs = call.executeQuery();
           return rs.next();
             }catch (SQLException e){
                  JOptionPane.showMessageDialog(null, e);
             }return false;
        }
       
}
