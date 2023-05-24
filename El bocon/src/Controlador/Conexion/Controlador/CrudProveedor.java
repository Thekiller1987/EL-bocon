package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
import Modelo.POJOProveedor;
import Vista.proveedores1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CrudProveedor {
    private final conexion con = new conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Nombre", "Marca", "Ruc", "Telefono"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call MostrarProveedores}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Nombre");
                registro[1] = rs.getString("Marca");
                registro[2] = rs.getString("Ruc");
                registro[3] = rs.getString("Telefono");

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
        String[] titulos = {"Nombre", "Marca", "Ruc", "Telefono"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarProveedores(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Nombre");
                registro[1] = rs.getString("Marca");
                registro[2] = rs.getString("Ruc");
                registro[3] = rs.getString("Telefono");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarProveedores(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void Guardar(POJOProveedor proveedor) {
        try {
            CallableStatement cbst = cn.prepareCall("{call AgregarProveedor(?,?,?,?)}");
            cbst.setString(1, proveedor.getNombre());
            cbst.setString(2, proveedor.getMarca());
            cbst.setString(3, proveedor.getRuc());
            cbst.setString(4, proveedor.getNumero());
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actualizar(POJOProveedor proveedor) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ModificarProveedor(?,?,?,?)}");
            cbst.setString(1, proveedor.getNombre());
            cbst.setString(2, proveedor.getMarca());
            cbst.setString(3, proveedor.getRuc());
            cbst.setString(4, proveedor.getNumero());
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void eliminar(String nombre) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarProveedor(?)}");
            cbst.setString(1, nombre);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}