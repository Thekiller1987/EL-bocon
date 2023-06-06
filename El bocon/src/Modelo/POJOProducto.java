/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Milton
 */
public class POJOProducto {
<<<<<<< HEAD

    public POJOProducto(int id_producto, String nombre, int cantidad, float precio, String descripcion, int id_proveedor, int id_marca, int id_categoria, float porcentaje_alcohol) {
=======
  private int id_producto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private double porcentaje_alcohol;
    private int id_proveedor;
    private int id_marca;
    private int id_categoria;
    
    public POJOProducto(int id_producto, String nombre, int cantidad, double precio, String descripcion, double porcentaje_alcohol, int id_proveedor, int id_marca, int id_categoria) {
>>>>>>> c301547ebbb5c0141f2e3b1e2206f5339d0636cd
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentaje_alcohol = porcentaje_alcohol;
        this.id_proveedor = id_proveedor;
        this.id_marca = id_marca;
        this.id_categoria = id_categoria;
    }
<<<<<<< HEAD

    public POJOProducto(int Producto, String nombreProducto, String cantidadProducto, String descripcionProducto, String categoriaProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    



=======
    
    // Getters y setters
    
>>>>>>> c301547ebbb5c0141f2e3b1e2206f5339d0636cd
    public int getId_producto() {
        return id_producto;
    }
    
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPorcentaje_alcohol() {
        return porcentaje_alcohol;
    }
    
    public void setPorcentaje_alcohol(double porcentaje_alcohol) {
        this.porcentaje_alcohol = porcentaje_alcohol;
    }
    
    public int getId_proveedor() {
        return id_proveedor;
    }
    
<<<<<<< HEAD
    int id_producto;
    String nombre;
    int cantidad;
    float precio;
    String descripcion;
    int id_proveedor;
    int id_marca;
    int id_categoria;
    float porcentaje_alcohol;
 
=======
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    public int getId_marca() {
        return id_marca;
    }
    
    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
    
    public int getId_categoria() {
        return id_categoria;
    }
    
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
>>>>>>> c301547ebbb5c0141f2e3b1e2206f5339d0636cd
}
