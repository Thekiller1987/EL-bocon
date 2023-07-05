/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author waska
 */
public class POJOFacturacion {
    
    int id_facturacion;
    String fecha;

    public POJOFacturacion(int id_facturacion, String fecha) {
        this.id_facturacion = id_facturacion;
        this.fecha = fecha;
    }
    

    public int getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(int id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   

    
    
}