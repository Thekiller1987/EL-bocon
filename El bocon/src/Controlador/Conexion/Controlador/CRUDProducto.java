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
import java.util.ArrayList;
import Modelo.POJOCategoria;



/**
 *
 * @author Milton
 */


public class CRUDProducto {
    
    
     private final conexion con = new conexion();
    private final Connection cn = (Connection)con.conectar();
    
    public ArrayList mostrarDatosCombo(){
        
        ArrayList<POJOCategoria> Categorias = new ArrayList();
        
        try{
            CallableStatement cbstc = cn.prepareCall("{call llenarCategorias}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                POJOCategoria cat = new POJOCategoria();
                cat.setId_categoria(String.valueOf(Integer.parseInt(rs.getString("IdCategoria"))));
                cat.setNombre(rs.getString("nombreCategoria"));
                Categorias.add(cat);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return Categorias;
    }
    
    

    
    
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_producto", "nombre", "cantidad", "precio", "descripcion","porcentaje_alcohol","id_proveedor","id_marca","id_categoria"};
        
         String[] registro = new String[9];
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
            cbst.setFloat(4, (float) producto.getPrecio());
            cbst.setString(5, producto.getDescripcion());
            cbst.setFloat(6, (float) producto.getPorcentaje_alcohol());
            cbst.setInt(7, producto.getId_proveedor());
            cbst.setInt(8, producto.getId_marca());
            cbst.setInt(9, producto.getId_categoria());
            cbst.executeUpdate();
           }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }
               
       }
    
       

       public void Guardar(POJOProducto producto){
           try{
            CallableStatement cbst = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?,?,?)}");
            cbst.setString(1, producto.getNombre());
            cbst.setInt(2, producto.getCantidad());
            cbst.setString(3, producto.getDescripcion());
            cbst.setFloat(4, (float) producto.getPrecio());
            cbst.setFloat(5, (float) producto.getPorcentaje_alcohol());
            cbst.executeUpdate();
           }catch (SQLException e){
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
