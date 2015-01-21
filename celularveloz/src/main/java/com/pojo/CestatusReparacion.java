/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author rubens
 */
public class CestatusReparacion {

     private int id_estatusreparacion;
    private String descripcion;
    
    public CestatusReparacion() 
    {
    }

    public CestatusReparacion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public CestatusReparacion(int id_estatusreparacion, String descripcion){
        this.id_estatusreparacion= id_estatusreparacion;
        this.descripcion= descripcion;
    }

    public int getId_estatusreparacion() {
        return id_estatusreparacion;
    }

    public void setId_estatusreparacion(int id_estatusreparacion) {
        this.id_estatusreparacion = id_estatusreparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
