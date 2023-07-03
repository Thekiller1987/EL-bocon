/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
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
public class CRUDCategoria {

         private final conexion con = new conexion();
         private final Connection cn = (Connection)con.conectar();
     
    public DefaultTableModel mostrarDatos(){
         ResultSet rs;
         DefaultTableModel modelo;
         String[] titulos = {"id_categoria", "Nombre", "tipo_de_alcohol", "tipo_de_producto"};
         
          String[] registro = new String[4];
          modelo = new DefaultTableModel(null, titulos);
          
          try{
              CallableStatement cbstc = cn.prepareCall("{call obtenercategoria}");
              rs = cbstc.executeQuery();
              
              
              while (rs.next()){
                  registro[0] = rs.getString("id_categoria");
                  registro[1] = rs.getString("Nombre");
                  registro[2] = rs.getString("tipo_de_alcohol");
                  registro[3] = rs.getString("tipo_de_producto");
                  
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
       
       String[] titulos = {"id_categoria", "Nombre", "tipo_de_alcohol", "tipo_de_producto"};
       String[] registro = new String[4];
       modelo = new DefaultTableModel(null, titulos);
       
        try{
            CallableStatement call = cn.prepareCall("{call buscarcategoria(?)}");
             call.setString(1, dato);
             rs = call.executeQuery();
             
             while (rs.next()){
                 
                  registro[0] = rs.getString("id_categoria");
                  registro[1] = rs.getString("Nombre");
                  registro[2] = rs.getString("tipo_de_alcohol");
                  registro[3] = rs.getString("tipo_de_producto");
                  
                  modelo.addRow(registro);
             }
              return modelo;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        return null;
        }
       
    }
    
    public void eliminar(String id_categoria){
         try{
             CallableStatement cbst = cn.prepareCall("{call Eliminarcategoria(?)}");
             cbst.setString(1, id_categoria);
             cbst.executeUpdate();
         }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
         }
        
        
    }
    
    public void actualizar(POJOCategoria categoria){
        try{
            CallableStatement cbst = cn.prepareCall("{call Actualizarcategoria(?,?,?,?)})");
            cbst.setString(1 ,categoria.getId_categoria());
            cbst.setString(2, categoria.getNombre());
            cbst.setString(3, categoria.getTipo_de_alcohol());
            cbst.setString(4, categoria.getTipo_de_producto());
            cbst.executeUpdate();    
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void Guardar(POJOCategoria categoria){
        
        try{
             CallableStatement cbst = cn.prepareCall("{call Actualizarcategoria(?,?,?,?)})");
            cbst.setString(1 ,categoria.getId_categoria());
            cbst.setString(2, categoria.getNombre());
            cbst.setString(3, categoria.getTipo_de_alcohol());
            cbst.setString(4, categoria.getTipo_de_producto());
            cbst.executeUpdate();       
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public boolean verificarDatos(String dato){
        ResultSet rs;
        try{
            CallableStatement call = cn.prepareCall("{call Consultarcategoria(?)}");
          call.setString(1, dato);
          rs = call.executeQuery();
           return rs.next();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }return false;
    }
    
}
