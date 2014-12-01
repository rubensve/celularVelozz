package com.pojo;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private int id;

    public Cliente(){
        
    }
    
    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nombre, String apellido, String telefono) {
        this.id= id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    

    public Cliente(String nombre, String apellido, String telefono)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
