package com.cursojdbc.entidades;

public class Cliente {
    private int idCliente;
    private String codigoCliente;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono;
    private String fax;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int idEmpleado;
    private double limiteCredito;

    public static Cliente makeSimpleCliente(String codigoCliente, String nombre, String apellido) {
        return new Cliente(codigoCliente, null, nombre, apellido, null, null, null, null, null, null, 0, 0);
    }

    public Cliente(
        String codigoCliente,
        String nombreCliente,
        String nombreContacto,
        String apellidoContacto,
        String telefono,
        String fax,
        String ciudad,
        String region,
        String pais,
        String codigoPostal,
        int idEmpleado,
        double limiteCredito
    ){
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.idEmpleado = idEmpleado;
        this.limiteCredito = limiteCredito;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public String getCodigoCliente() {
        return codigoCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public String getApellidoContacto() {
        return apellidoContacto;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getFax() {
        return fax;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getRegion() {
        return region;
    }
    public String getPais() {
        return pais;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public double getLimiteCredito() {
        return limiteCredito;
    }
    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", codigoCliente=" + codigoCliente + ", nombreCliente="
                + nombreCliente + ", nombreContacto=" + nombreContacto + ", apellidoContacto=" + apellidoContacto
                + ", telefono=" + telefono + ", fax=" + fax + ", ciudad=" + ciudad + ", region=" + region + ", pais="
                + pais + ", codigoPostal=" + codigoPostal + ", idEmpleado=" + idEmpleado + ", limiteCredito="
                + limiteCredito + "]";
    }
}
