package com.pojo;

public class Nota {

    private int folio;
    private String fecharecepcion;
    private String fechaentrega;
    private Usuario u;
    private Cliente c;
    private String login;
    private int id_cliente;
    private String imei;
    private String modelo;
    private double total;
    private double anticipo;
    private String descripcionnota;
    private String descripcionreparacion;
    private double resto;
    private int id_estatusnota;
    private int id_estatusreparacion;
    private String observaciones;
    private String obsreparacion;
    

    
    public Nota() 
    {
    }

    public Nota(int folio, String fecharecepcion, String fechaentrega, String login, int id_cliente, String imei, String modelo, double total, double anticipo, int id_estatusnota, int id_estatusreparacion, String observaciones, String obsreparacion) {
        this.folio = folio;
        this.fecharecepcion = fecharecepcion;
        this.fechaentrega = fechaentrega;
        this.login = login;
        this.id_cliente = id_cliente;
        this.imei = imei;
        this.modelo = modelo;
        this.total = total;
        this.anticipo = anticipo;
        this.id_estatusnota = id_estatusnota;
        this.id_estatusreparacion = id_estatusreparacion;
        this.observaciones = observaciones;
        this.obsreparacion = obsreparacion;
    }
    
    
    
    
    
    public Nota(int folio) {
        this.folio = folio;
    }

    public Nota(int folio, String fecharecepcion, String fechaentrega, Usuario u, Cliente c,String imei, double total, double anticipo, double resto,
            String observaciones, String modelo) {
        this.folio = folio;
        this.fecharecepcion = fecharecepcion;
        this.fechaentrega = fechaentrega;
        this.u = u;
        this.c = c;
        this.imei= imei;
        this.total = total;
        this.anticipo = anticipo;
        this.resto = resto;
        this.observaciones = observaciones;
        this.modelo= modelo;
    }

    public Nota(String fechaentrega, Usuario u, Cliente c, String imei, String modelo, double total, double anticipo, double resto, String observaciones) {
        this.fechaentrega = fechaentrega;
        this.u = u;
        this.c = c;
        this.imei = imei;
        this.modelo = modelo;
        this.total = total;
        this.anticipo = anticipo;
        this.resto = resto;
        this.observaciones = observaciones;
    }
    
    
    

    public Nota(int folio, String fecharecepcion, String fechaentrega, String login, int id_cliente, String imei, String modelo, double total, double anticipo, double resto, int id_estatusnota, int id_estatusreparacion, String observaciones, String obsreparacion) {
        this.folio = folio;
        this.fecharecepcion = fecharecepcion;
        this.fechaentrega = fechaentrega;
        this.login = login;
        this.id_cliente = id_cliente;
        this.imei = imei;
        this.modelo=modelo;
        this.total = total;
        this.anticipo = anticipo;
        this.resto = resto;
        this.id_estatusnota = id_estatusnota;
        this.id_estatusreparacion = id_estatusreparacion;
        this.observaciones = observaciones;
        this.obsreparacion = obsreparacion;
    }
    
    public Nota(int folio, String fecharecepcion, String fechaentrega, String login, int id_cliente, String imei, String modelo, double total, double anticipo, String descripcionnota, String descripcionreparacion, String observaciones, String obsreparacion) {
        this.folio = folio;
        this.fecharecepcion = fecharecepcion;
        this.fechaentrega = fechaentrega;
        this.login = login;
        this.id_cliente = id_cliente;
        this.imei = imei;
        this.modelo = modelo;
        this.total = total;
        this.anticipo = anticipo;
        this.descripcionnota = descripcionnota;
        this.descripcionreparacion = descripcionreparacion;
        this.observaciones = observaciones;
        this.obsreparacion = obsreparacion;
    }
    

    public Nota(int folio, String fecharecepcion, String fechaentrega, Usuario u, Cliente c, String imei, double total, double anticipo, double resto, int id_estatusnota, int id_estatusreparacion, String observaciones, String obsreparacion) {
        this.folio = folio;
        this.fecharecepcion = fecharecepcion;
        this.fechaentrega = fechaentrega;
        this.u = u;
        this.c = c;
        this.imei = imei;
        this.total = total;
        this.anticipo = anticipo;
        this.resto = resto;
        this.id_estatusnota = id_estatusnota;
        this.id_estatusreparacion = id_estatusreparacion;
        this.observaciones = observaciones;
        this.obsreparacion = obsreparacion;
    }

    public String getObsreparacion() {
        return obsreparacion;
    }

    public void setObsreparacion(String obsreparacion) {
        this.obsreparacion = obsreparacion;
    }

    public String getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
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

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
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

    public double getResto() {
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }

    public int getId_estatusnota() {
        return id_estatusnota;
    }

    public void setId_estatusnota(int id_estatusnota) {
        this.id_estatusnota = id_estatusnota;
    }

    public int getId_estatusreparacion() {
        return id_estatusreparacion;
    }

    public void setId_estatusreparacion(int id_estatusreparacion) {
        this.id_estatusreparacion = id_estatusreparacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcionnota() {
        return descripcionnota;
    }

    public void setDescripcionnota(String descripcionnota) {
        this.descripcionnota = descripcionnota;
    }

    public String getDescripcionreparacion() {
        return descripcionreparacion;
    }

    public void setDescripcionreparacion(String descripcionreparacion) {
        this.descripcionreparacion = descripcionreparacion;
    }
    
    
    
}
