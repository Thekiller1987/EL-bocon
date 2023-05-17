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
}
