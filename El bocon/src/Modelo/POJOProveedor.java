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

    public POJOProveedor(int idProveedor, String nombre, String marca, String ruc, String numero) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.marca = marca;
        this.ruc = ruc;
        this.numero = numero;
    }

    public POJOProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public POJOProveedor(int idProveedor, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    

    int idProveedor;
     String nombre;
     String marca;
     String ruc;
     String numero;

 @Override
    public String toString(){
     return  idProveedor +" - "+ nombre;
    }
}