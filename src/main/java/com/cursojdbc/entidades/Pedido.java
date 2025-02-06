package com.cursojdbc.entidades;

import java.security.InvalidParameterException;
import java.util.Date;

public class Pedido {
    private int idPedido;
    private String codigoPedido;
    private Date fechaPedido;
    private Date fechaEsperada;
    private Date fechaEntrega;
    private String estado;
    private String comentarios;
    private int idCliente;

    private Pedido(int idPedido, String codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
            String estado, String comentarios, Integer idCliente) {
        this.idPedido = idPedido;
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEsperada = fechaEsperada;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.comentarios = comentarios;
        this.idCliente = idCliente;
    }

    /**
     * TODO: Se puede mejorar la validación
     */
    private static void validar(String codigoPedido, Date fechaPedido) throws InvalidParameterException {
        if (codigoPedido == null) {
            throw new InvalidParameterException("El codigo del pedido no puede ser nulo.");
        }
        if (fechaPedido == null) {
            throw new InvalidParameterException("La fecha del pedido no puede ser nula.");
        }
    }

    public static Pedido makeWithId(int id, String codigoPedido, Date fechaPedido, Date fechaEsperada,
            Date fechaEntrega,
            String estado, String comentarios, Integer idCliente) {

        validar(codigoPedido, fechaPedido);

        return new Pedido(0, codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentarios, idCliente);
    }

    public static Pedido make(String codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
            String estado, String comentarios, Integer idCliente) {

        validar(codigoPedido, fechaPedido);

        return new Pedido(0, codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentarios, idCliente);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public Date getFechaEsperada() {
        return fechaEsperada;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setFechaEsperada(Date fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", codigoPedido=" + codigoPedido + ", fechaPedido=" + fechaPedido
                + ", fechaEsperada=" + fechaEsperada + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado
                + ", comentarios=" + comentarios + ", idCliente=" + idCliente + "]";
    }
}
