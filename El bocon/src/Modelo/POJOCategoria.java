/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author waska
 */
public class POJOCategoria {

    public POJOCategoria(String id_categoria, String Nombre, String tipo_de_alcohol, String tipo_de_producto) {
        this.id_categoria = id_categoria;
        this.Nombre = Nombre;
        this.tipo_de_alcohol = tipo_de_alcohol;
        this.tipo_de_producto = tipo_de_producto;
    }
    String id_categoria;
    String Nombre;
    String tipo_de_alcohol;
    String tipo_de_producto;

    public POJOCategoria(String id_categoria, String Nombre) {
        this.id_categoria = id_categoria;
        this.Nombre = Nombre;
    }
    
    

    public POJOCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo_de_alcohol() {
        return tipo_de_alcohol;
    }

    public void setTipo_de_alcohol(String tipo_de_alcohol) {
        this.tipo_de_alcohol = tipo_de_alcohol;
    }

    public String getTipo_de_producto() {
        return tipo_de_producto;
    }

    public void setTipo_de_producto(String tipo_de_producto) {
        this.tipo_de_producto = tipo_de_producto;
    }
    
    @Override
    public String toString(){
     return  id_categoria+" - "+ Nombre;
    }
    
    
}
