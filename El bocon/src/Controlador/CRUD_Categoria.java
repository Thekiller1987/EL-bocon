/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POJO_Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author waskar
 */
public class CRUD_Categoria {
    private Conexion SQL= new Conexion();
    private Connection cn =SQL.conectar();
    String sql="";
    
    public boolean insertar(POJO_Categoria dts){
      sql=("{call RegistrarCategoria(?)}");
        try {
            PreparedStatement pst =cn.prepareStatement(sql);
            pst.setString(1, dts.getNcategoria());
            
            int n =pst.executeUpdate();
            if (n != 0) {
                return true;
                
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    
}
