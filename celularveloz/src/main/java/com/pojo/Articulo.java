package com.pojo;

public class Articulo 
{
 private Nota nota;
 private int cantidad;
 private String descripcion;
 private double costo;
 private int folio;
 
 public Articulo(){
     
 }

    public Articulo(Nota nota) {
        this.nota = nota;
    }

    public Articulo(int cantidad, String descripcion, double costo) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    public Articulo(int folio, int cantidad, String descripcion, double costo) {
        this.folio= folio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    
    

 
    public Articulo(Nota nota, int cantidad, String descripcion, double costo) {
        this.nota= nota;
        this.cantidad = cantidad;   
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public void setNota(Nota n){
        this.nota = n;
    }
    
    public Nota getNota(){
        return nota;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }
}
