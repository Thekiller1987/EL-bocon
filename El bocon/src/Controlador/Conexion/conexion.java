/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author waska
 */
public class conexion {
    
    public static Connection conectar() {
        
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=bd_sistemas_ventas; user=sa"
                + "password=root123";
                
        
        try {
            Connection cn = DriverManager.getConnection(conexionUrl);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos" + e);
            return null;
        }
        
        
    
    
}
    }
    

