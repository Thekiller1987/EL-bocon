/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Milton
 *  * Correciones Waskar
 */
public class POJOProveedor {
    
    String nombre;
    String direccion;
    String telefono;
    int id_proveedor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public POJOProveedor(String nombre, String direccion, String telefono, int id_proveedor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_proveedor = id_proveedor;
    }
    
    
    
}
