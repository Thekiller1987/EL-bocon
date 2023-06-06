package Controlador.Conexion.Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.POJOClientes;
import Controlador.Conexion.conexion;

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
            CallableStatement cbstc = cn.prepareCall("{call ObtenerClientes}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("DNI");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("direccion");
                registro[4] = rs.getString("correo");
                registro[5] = rs.getString("telefono");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel buscarDatos(String dato) {
      ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"DNI","nombre", "apellido", "direccion", "correo","telefono"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarClientes(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
              registro[0] = rs.getString("DNI");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("direccion");
                registro[4] = rs.getString("correo");
                registro[5] = rs.getString("telefono");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void guardar(POJOClientes cl) {
        try {
            CallableStatement cbst = cn.prepareCall("{call CrearCliente(?,?,?,?,?,?)}");
            cbst.setString(1, cl.getCedula());
            cbst.setString(2, cl.getNombres());
            cbst.setString(3, cl.getApellidos());
            cbst.setString(4, cl.getCorreo());
            cbst.setString(5, cl.getTelefono());
            cbst.setString(6, cl.getDireccion());
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarClientes(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void eliminar(String cedula) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarCliente(?)}");
            cbst.setString(1, cedula);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public void actualizarCliente(POJOClientes pro) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ActualizarCliente(?,?,?,?,?,?)}");
        cbst.setString(1, pro.getCedula());
        cbst.setString(2, pro.getNombres());
        cbst.setString(3, pro.getApellidos());
        cbst.setString(4, pro.getCorreo());
        cbst.setString(5, pro.getTelefono());
        cbst.setString(6, pro.getDireccion());
   
   
        cbst.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }
}
