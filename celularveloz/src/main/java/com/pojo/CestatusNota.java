
package com.pojo;

public class CestatusNota {

    private int id_estatusnota;
    private String descripcion;
    
    public CestatusNota() 
    {
    }

    public CestatusNota(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public CestatusNota(int id_estatusnota, String descripcion){
        this.id_estatusnota=id_estatusnota;
        this.descripcion= descripcion;
    }

    public int getId_estatusnota() {
        return id_estatusnota;
    }

    public void setId_estatusnota(int id_estatusnota) {
        this.id_estatusnota = id_estatusnota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
