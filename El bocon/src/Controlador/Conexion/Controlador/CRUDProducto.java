 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
import Modelo.POJOProducto;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;


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
         CallableStatement cbstc = cn.prepareCall("{call obtenerProducto}");
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
           CallableStatement call = cn.prepareCall("{call buscarProducto(?)}");
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
       }catch (SQLException e){
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
      
      
      
       public void actualizar(POJOProducto producto){
           try{
               CallableStatement cbst = cn.prepareCall("{call ActualizarProducto(?,?,?,?,?,?,?,?,?)})");
            cbst.setInt(producto.getId_producto(), 1);
            cbst.setString(2, producto.getNombre());
            cbst.setInt(producto.getCantidad(),3);
            cbst.setFloat(4, producto.getPrecio());
            cbst.setString(5, producto.getDescripcion());
            cbst.setFloat(6, producto.getPorcentaje_alcohol());
            cbst.setInt(7, producto.getId_proveedor());
            cbst.setInt(8, producto.getId_marca());
            cbst.setInt(9, producto.getId_categoria());
            cbst.executeUpdate();
           }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
               
       }
    
       
<<<<<<< HEAD
       public void Guardar(POJOProducto producto){
           try{
               CallableStatement cbst = cn.prepareCall("{call AgregarProducto(?,?,?,?,?,?,?,?,?)}");
            cbst.setString(1, producto.getNombre());
            cbst.setInt(2, producto.getCantidad());
            cbst.setString(3, producto.getDescripcion());
            cbst.setFloat(4, producto.getPrecio());
            cbst.setFloat(5, producto.getPorcentaje_alcohol());
            cbst.executeUpdate();
           }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
=======
       public void Guardar(POJOProducto agregarProducto){
   try {
        CallableStatement cbst = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?,?,?)}");
        cbst.setInt(1, agregarProducto.getId_producto());
        cbst.setString(2, agregarProducto.getNombre());
        cbst.setInt(3, agregarProducto.getCantidad());
        cbst.setDouble(4, agregarProducto.getPrecio());
        cbst.setString(5, agregarProducto.getDescripcion());
        cbst.setDouble(6, agregarProducto.getPorcentaje_alcohol());
        cbst.setInt(7, agregarProducto.getId_proveedor());
        cbst.setInt(8, agregarProducto.getId_marca());
        cbst.setInt(9, agregarProducto.getId_categoria());
        cbst.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);

>>>>>>> c301547ebbb5c0141f2e3b1e2206f5339d0636cd
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
