/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POJO_Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waskar
 */
public class CRUD_Cliente {
    
     private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql = "";

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellidos", "DNI", "RUC", "Edad", "sexo", "Telefono", "Direccion"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[9];

        sql = "sp_buscar_cliente ?";
        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, buscar);
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getString(9);
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(POJO_Cliente dts) {
        sql = "{call sp_guardar_clientes (?,?,?,?,?,?,?,?,?)}";

        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, dts.getCodigo());
            cst.setString(2, dts.getNombres());
            cst.setString(3, dts.getApellidos());
            cst.setString(4, dts.getDni());
            cst.setString(5, dts.getRuc());
            cst.setInt(6, dts.getEdad());
            cst.setString(7, dts.getSexo());
            cst.setString(8, dts.getTelefono());
            cst.setString(9, dts.getDireccion());

            int n = cst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(POJO_Cliente dts) {
        sql = "{call sp_editar_clientes (?,?,?,?,?,?,?,?,?)}";

        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, dts.getCodigo());
            cst.setString(2, dts.getNombres());
            cst.setString(3, dts.getApellidos());
            cst.setString(4, dts.getDni());
            cst.setString(5, dts.getRuc());
            cst.setInt(6, dts.getEdad());
            cst.setString(7, dts.getSexo());
            cst.setString(8, dts.getTelefono());
            cst.setString(9, dts.getDireccion());

            int n = cst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(POJO_Cliente dts) {
        sql = "{call sp_eliminar_cliente(?)}";

        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setString(1, dts.getCodigo());

            int n = cst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public int generarIdCliente() {
        String sql = "SELECT MAX(idcliente) AS id FROM clientes";
        int cod = 0;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cod = rs.getInt("id") + 1;
            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error SQL: " + e1.getMessage());
        }

        return cod;
    }

}