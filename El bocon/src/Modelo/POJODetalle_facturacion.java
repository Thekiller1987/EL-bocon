/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Milton
 *  *Correciones Waskar
 * 
 */
public class POJODetalle_facturacion {
 
    int id_producto;
    int id_facturacion;
    int cantidad;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public POJODetalle_facturacion(int id_producto, int id_facturacion, int cantidad) {
        this.id_producto = id_producto;
        this.id_facturacion = id_facturacion;
        this.cantidad = cantidad;
    }
    
    
    
}
