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
 private int idProveedor;
    private String nombre;
    private String marca;
    private String ruc;
    private String numero;

    // Constructor
    public POJOProveedor(String nombre, String marca, String ruc, String numero) {
        this.nombre = nombre;
        this.marca = marca;
        this.ruc = ruc;
        this.numero = numero;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getRuc() {
        return ruc;
    }

    public String getNumero() {
        return numero;
        
}  
public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }}
  
