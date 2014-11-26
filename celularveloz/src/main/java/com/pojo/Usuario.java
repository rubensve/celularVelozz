package com.pojo;

public class Usuario {
    
    private String login;
    private String password;
    private String nombre;
    private String apellido;
    private String rol;
    
    public Usuario(){
        
    }
    
    public Usuario(String login){
        this.login= login;
    }
    
    public Usuario(String login, String password, String nombre, String apellido, String rol){
        this.login= login;
        this.password= password;
        this.nombre= nombre;
        this.apellido= apellido;
        this.rol= rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
