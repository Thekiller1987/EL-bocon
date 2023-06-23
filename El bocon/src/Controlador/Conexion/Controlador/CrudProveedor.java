package Controlador.Conexion.Controlador;

import Controlador.Conexion.conexion;
import Modelo.POJOProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CrudProveedor {
    private final conexion con = new conexion();
    private final Connection cn = (Connection) con.conectar();
    
    
    public ArrayList mostrarDatosCombo(){
        
        ArrayList<POJOProveedor> proveedor = new ArrayList();
        try{
             CallableStatement cbstc = cn.prepareCall("{call llenarProveedor}");
            ResultSet rs = cbstc.executeQuery();
             while (rs.next()) {
                 POJOProveedor prov = new POJOProveedor();
                 prov.setIdProveedor(Integer.parseInt(rs.getString("Id_proveedor")));
                 prov.setNombre(rs.getString("NombreProveedor"));
                 proveedor.add(prov);
             }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e);
        }
        return proveedor;
    }

    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Id_proveedor","Nombre", "Marca", "Ruc", "Telefono"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call ObtenerProveedores}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Id_proveedor");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Marca");
                registro[3] = rs.getString("Ruc");
                registro[4] = rs.getString("Telefono");

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
        String[] titulos = {"Id_proveedor","Nombre", "Marca", "Ruc", "Telefono"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarProveedores(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
              registro[0] = rs.getString("Id_proveedor");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Marca");
                registro[3] = rs.getString("Ruc");
                registro[4] = rs.getString("Telefono");

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


public void actualizar(POJOProveedor pro) {
    try {

        CallableStatement cs = cn.prepareCall( "{call ActualizarProveedor(?, ?, ?, ?, ?)}");
        cs.setInt(1, pro.getIdProveedor());
        cs.setString(2, pro.getNombre());
        cs.setString(3, pro.getMarca());
        cs.setString(4, pro.getRuc());
        cs.setString(5, pro.getNumero());
        cs.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    public void eliminar(String Id_proveedor) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarProveedor(?)}");
            cbst.setString(1, Id_proveedor);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}