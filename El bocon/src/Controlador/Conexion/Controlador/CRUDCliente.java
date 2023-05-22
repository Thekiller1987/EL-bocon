package Controlador.Conexion.Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.clientes;
/**
 *
 * @author waska
 */
import Controlador.Conexion.conexion;
import Modelo.POJOClientes;
import Modelo.Persona;

public class CRUDCliente {

    private final conexion con = new conexion();
    private final Connection cn = con.conectar();

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;

        String[] titulos = {"DNI", "Nombres", "Apellidos", "Correo", "Telefono", "Dirección"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarCliente}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("cedula");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("Correo");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("direccion");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    


public DefaultTableModel buscarDatos(String dato){
   ResultSet rs;
        DefaultTableModel modelo;
String[] titulos = {"Cédula", "Nombres", "Apellidos", "Correo",
"Telefono", "Dirección"};
String[] registro = new String[6];
modelo = new DefaultTableModel(null, titulos);
    try {
        CallableStatement call = cn.prepareCall("{callConsultarClientes(?)}");
        call.setString(1, dato);
        rs = call.executeQuery();
        
while (rs.next()) {
registro[0] = rs.getString("cedula");
registro[1] = rs.getString("nombres");
registro[2] = rs.getString("apellidos");
registro[3] = rs.getString("Correo");
registro[4] = rs.getString("telefono");
registro[5] = rs.getString("direccion");
modelo.addRow(registro);
}
return modelo;
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
return null;
}
//Metodo  Guardar
public void Guardar(POJOClientes cl) {
try {
CallableStatement cbst = cn.prepareCall("{call CrearCliente(?,?,?,?,?,?,?)}");
cbst.setString(1, cl.getDNI());
cbst.setString(2, cl.getNombres());
cbst.setString(3, cl.getApellidos());
cbst.setString(5, cl.getTelefono());
cbst.setString(6, cl.getDireccion());
cbst.setString(7 , cl.getCorreo());
cbst.executeUpdate();
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, e);
}
}

//Metodo de Verificar Datos
public boolean verificarDatos(String dato) {
ResultSet rs;

try {
  CallableStatement call = cn.prepareCall("{call ConsultarClientes(?)}");
    call.setString(1, dato);
    rs = call.executeQuery();
    return rs.next();
}
catch (SQLException e) {
JOptionPane.showMessageDialog(null, e);
return false;
}
}
//Metodo de Eliminar Datos
public void eliminar(String DNI) {
try {
CallableStatement cbst = cn.prepareCall("{call EliminarClientes(?)}");
cbst.setString(1, DNI);
cbst.executeUpdate();
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, e);
}
}
}


