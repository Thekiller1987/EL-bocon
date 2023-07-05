/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Milton/waskar
 */
public class POJOProducto {

    public POJOProducto(int id, String nombre, String descripcion, String precioCompra, String precioVenta, String porcentajeAlcohol, String cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.porcentajeAlcohol = porcentajeAlcohol;
        this.cantidad = cantidad;
    }

    public POJOProducto(String nombre, String descripcion, String precioCompra, String precioVenta, String porcentajeAlcohol, String cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.porcentajeAlcohol = porcentajeAlcohol;
        this.cantidad = cantidad;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getPorcentajeAlcohol() {
        return porcentajeAlcohol;
    }

    public void setPorcentajeAlcohol(String porcentajeAlcohol) {
        this.porcentajeAlcohol = porcentajeAlcohol;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    int id;
   String nombre;
   String descripcion;
   String precioCompra;
    String precioVenta;
    String porcentajeAlcohol;
    String cantidad;
}