package com.cursojdbc.entidades;

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
}
