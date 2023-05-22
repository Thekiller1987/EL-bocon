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

    public POJOFacturacion(String id_facturacion, Date fecha, int DNI, String id_empelado) {
        this.id_facturacion = id_facturacion;
        this.fecha = fecha;
        this.DNI = DNI;
        this.id_empelado = id_empelado;
    }

    public String getId_facturacion() {
        return id_facturacion;
    }

    public void setId_facturacion(String id_facturacion) {
        this.id_facturacion = id_facturacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getId_empelado() {
        return id_empelado;
    }

    public void setId_empelado(String id_empelado) {
        this.id_empelado = id_empelado;
    }
    String id_facturacion;
    Date fecha;
    int DNI;
    String id_empelado;
    
}
