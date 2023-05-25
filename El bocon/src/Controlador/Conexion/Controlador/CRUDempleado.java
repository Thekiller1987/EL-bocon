/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Conexion.Controlador;

import Modelo.POJOempleado;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controlador.Conexion.conexion;

/**
 *
 * @author Milton
 */
public class CRUDempleado {
    
    private final conexion con = new conexion();
    private final Connection cn = (Connection)con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"id_empleado", "nombre","apellido", "telefono","direccion"};
        
        String[] registro = new String[5];
    modelo = new DefaultTableModel(null, titulos);
    
    try{
        CallableStatement cbstc = cn.prepareCall("{call Mostrarempleados}");
        rs = cbstc.executeQuery();
        
         while (rs.next()){
            registro[0] = rs.getString("id_empleado");
            registro[1] = rs.getString("nombre");
            registro[2] = rs.getString("apellido");
            registro[3] = rs.getString("telefono");
            registro[4] = rs.getString("direccion");
            
            
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
     
     String[] titulos = {"id_empleado","nombre","apellido","telefono","direccion"};
       String[] registro = new String[5];           
       modelo = new DefaultTableModel(null, titulos);
       
       try{
             CallableStatement call = cn.prepareCall("{call ConsultarEmpleado(?)}");
    call.setString(1, dato);
    rs = call.executeQuery();
    
    while (rs.next()){
        registro[0] = rs.getString("id_empleado");
        registro[1] = rs.getString("nombre");
        registro[2] = rs.getString("apellido");
        registro[3] = rs.getString("telefono");
        registro[4] = rs.getString("direccion");
        
        modelo.addRow(registro);
    
       }
       return modelo;
       
 }catch (Exception e){
       JOptionPane.showMessageDialog(null, e);
        return null;
 }   
 
 }

public void eliminar(String id_empleado){
    try{
        CallableStatement cbst = cn.prepareCall("{call Eliminarempleado(?)}");
cbst.setString(1, id_empleado);
cbst.executeUpdate();
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
 
public void actualizar(POJOempleado em){
    try{
        CallableStatement cbst = cn.prepareCall("{callModificarempleado(?,?,?,?,?)})");
          cbst.setInt(1, em.getId_empleado());
          cbst.setString(2, em.getNombre());
          cbst.setString(3, em.getApellido());
          cbst.setString(4, em.getTelefono());
          cbst.setString(5, em.getDireccion());
          
          
            cbst.executeUpdate();
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}

public void Guardar(POJOempleado em){
    try{
        CallableStatement cbst = cn.prepareCall("{callModificarempleado(?,?,?,?,?)})");
        cbst.setInt(1, em.getId_empleado());
          cbst.setString(2, em.getNombre());
          cbst.setString(3, em.getApellido());
          cbst.setString(4, em.getTelefono());
          cbst.setString(5, em.getDireccion());
          
          cbst.executeUpdate();
    }catch (SQLException e){
         JOptionPane.showMessageDialog(null, e);
    }
}

 public boolean verificarDatos(String dato){
     ResultSet rs;
     try{
          CallableStatement call = cn.prepareCall("{call Consultarempleado(?)}");
          call.setString(1, dato);
          rs = call.executeQuery();
          return rs.next();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, e);
     } return false;
 }

}