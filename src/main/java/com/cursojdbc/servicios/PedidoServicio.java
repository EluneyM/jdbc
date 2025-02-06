package com.cursojdbc.servicios;

import java.util.Date;
import java.util.List;

import com.cursojdbc.entidades.Pedido;
import com.cursojdbc.persistencia.PedidoDAO;

public class PedidoServicio {
    PedidoDAO pd = new PedidoDAO();

    public List<Pedido> guardarPedido(String codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
            String estado, String comentario, Integer idCliente) throws Exception {

        Pedido pedido = Pedido.make(codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentario,
                idCliente);

        return pd.guardarPedido(pedido);
    }

}
