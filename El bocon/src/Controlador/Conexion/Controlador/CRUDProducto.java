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
import java.util.List;



/**
 *
 * @author Waskar
 */


public class CRUDProducto {
    
    
     private final conexion con = new conexion();
    private final Connection cn = (Connection)con.conectar();
    
  
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id", "Nombre", "Descripcion", "PrecioCompra", "PrecioVenta","PorcentajeAlcohol","Cantidad"};
        
         String[] registro = new String[9];
    modelo = new DefaultTableModel(null, titulos);
    
    try{
         CallableStatement cbstc = cn.prepareCall("{call obtenerProducto}");
        rs = cbstc.executeQuery();
        
         while (rs.next()){
            registro[0] = rs.getString("id");
            registro[1] = rs.getString("Nombre");
            registro[2] = rs.getString("Descripcion");
            registro[3] = rs.getString("PrecioCompra");
            registro[4] = rs.getString("PrecioVenta");
            registro[5] = rs.getString("PorcentajeAlcohol");
            registro[6] = rs.getString("Cantidad");
            
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
      
      
      
public void actualizar(POJOProducto producto) {
  try {
            CallableStatement cbst = cn.prepareCall("{call ActualizarProductos(?,?,?,?,?,?,?)}");
            cbst.setInt(1, producto.getId());
            cbst.setString(2, producto.getNombre());
            cbst.setString(3, producto.getDescripcion());
            cbst.setString(4, producto.getPrecioCompra());
            cbst.setString(5, producto.getPrecioVenta());
            cbst.setString(6, producto.getPorcentajeAlcohol());
            cbst.setString(7, producto.getCantidad());
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
       

public void Guardar(POJOProducto producto) {
    try {
        CallableStatement cbst = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?)}");
        cbst.setString(1, producto.getNombre());
        cbst.setString(2, producto.getDescripcion());
        cbst.setString(3, producto.getPrecioCompra());
        cbst.setString(4, producto.getPrecioVenta());
        cbst.setString(5, producto.getPorcentajeAlcohol());
        cbst.setString(6, producto.getCantidad());
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
        public List<String> mostrardatoscombo() {
        List<String> clientes = new ArrayList<>();

        try {
         

            // Preparar la llamada al procedimiento almacenado
            String sql = "{call rellenarcliente}";
            CallableStatement call = cn.prepareCall(sql);

            // Ejecutar la llamada al procedimiento almacenado
            ResultSet rs = call.executeQuery();

            // Recorrer el resultado y obtener los nombres de los clientes
            while (rs.next()) {
                String nombreCliente = rs.getString("nombre");
                clientes.add(nombreCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
