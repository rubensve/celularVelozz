package com.pojo;


public class Nota {

    private int folio;
    private String fecharecibido;
    private String fechaentrega;
    private String login;
    private int id_usuario;
    private Usuario u; 
    private Cliente e;
    private String imei;
    private double total;
    private double anticipo;
    private double resta;
    private String observaciones;
    private String estatusNota;
    private String estatusReparacion;
    private String obsreparacion;
    private String modelo;
    
    public Nota(){
        
    }
    
    public Nota(int folio) {
        this.folio = folio;
    }

    public Nota(int folio, String fecharecibido, String fechaentrega, String login, int id_usuario, String imei,
            double total, double anticipo, double resta, String estatusNota, String estatusReparacion,
            String observaciones, String obsreparacion, String modelo) 
    {
        this.folio = folio;
        this.fecharecibido = fecharecibido;
        this.fechaentrega = fechaentrega;
        this.login = login;
        this.id_usuario = id_usuario;
        this.imei = imei;
        this.total = total;
        this.anticipo = anticipo;
        this.resta = resta;
        this.estatusNota= estatusNota;
        this.estatusReparacion= estatusReparacion;
        this.observaciones= observaciones;
        this.obsreparacion= obsreparacion;
        this.modelo= modelo;
        
    }

    public Nota(int folio, String fecharecibido, String fechaentrega, Usuario u, Cliente e, String imei, double total, double anticipo, double resta,
            String observaciones, String modelo) {
        this.folio = folio;
        this.fecharecibido = fecharecibido;
        this.fechaentrega = fechaentrega;
        this.u = u;
        this.e = e;
        this.imei = imei;
        this.total = total;
        this.anticipo = anticipo;
        this.resta = resta;
        this.observaciones= observaciones;
        this.modelo= modelo;
    }

    public Nota(int folio, String estatusNota, String estatusReparacion, String obsreparacion) {
        this.folio = folio;
        this.estatusNota = estatusNota;
        this.estatusReparacion = estatusReparacion;
        this.obsreparacion= obsreparacion;
    }

    
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecharecibido() {
        return fecharecibido;
    }

    public void setFecharecibido(String fecharecibido) {
        this.fecharecibido = fecharecibido;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public Cliente getE() {
        return e;
    }

    public void setE(Cliente e) {
        this.e = e;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public double getResta() {
        return resta;
    }

    public void setResta(double resta) {
        this.resta = resta;
    }

    public String getEstatusNota() {
        return estatusNota;
    }

    public void setEstatusNota(String estatusNota) {
        this.estatusNota = estatusNota;
    }

    public String getEstatusReparacion() {
        return estatusReparacion;
    }

    public void setEstatusReparacion(String estatusReparacion) {
        this.estatusReparacion = estatusReparacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObsreparacion() {
        return obsreparacion;
    }

    public void setObsreparacion(String obsreparacion) {
        this.obsreparacion = obsreparacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
}
