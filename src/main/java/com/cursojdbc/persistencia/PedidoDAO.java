package com.cursojdbc.persistencia;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Pedido;

public class PedidoDAO extends DAO {
    public List<Pedido> obtenerPedido() throws Exception {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();

        try {
            consultarDataBase(sql);
            while (resultSet.next()) {
                Pedido pedido = Pedido.makeWithId(
                        resultSet.getInt("id_pedido"),
                        resultSet.getString("codigo_pedido"),
                        resultSet.getDate("fecha_pedido"),
                        resultSet.getDate("fecha_esperada"),
                        resultSet.getDate("fecha_entrega"),
                        resultSet.getString("estado"),
                        resultSet.getString("comentarios"),
                        resultSet.getInt("id_cliente"));

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar los pedidos: " + e.getMessage(), e);
        } finally {
            desconectarDataBase();
        }

        return pedidos;
    }

    public List<Pedido> guardarPedido(Pedido pedido) throws Exception {
        if (pedido == null) {
            throw new Exception("El pedido no puede ser nulo");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, id_cliente) VALUES ('"
                + pedido.getCodigoPedido() + "', '"
                + dateFormat.format(pedido.getFechaPedido()) + "', '"
                + dateFormat.format(pedido.getFechaEsperada()) + "', '"
                + dateFormat.format(pedido.getFechaEntrega()) + "', '"
                + pedido.getEstado() + "', '"
                + pedido.getComentarios() + "', '"
                + pedido.getIdCliente() + "')";

        insertarModificarEliminarDataBase(sql);

        return obtenerPedido();
    }
}
