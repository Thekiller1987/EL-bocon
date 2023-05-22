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
    
   private final String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_ELBOCON;"
            + "integratedSecurity=true;encrypt=true;trustServerCertificate=true";
    private Connection cn;

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
            return cn;
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador: " + e);
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e);
        }
        return null;
    }
}

