package com.cursojdbc.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Cliente;

public class ClienteDAO extends DAO {
    public void guadarCliente(Cliente cliente) throws Exception {
        // verificar que el cliente no sea nulo
        if (cliente == null) {
            throw new Exception("Cliente Nulo!!!");
        }
        // script sql
        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ('"
                + cliente.getNombre() + "', "
                + "'" + cliente.getCalle() + "', "
                + cliente.getNumero() + ", "
                + cliente.getCodigoPostal() + ", "
                + "'" + cliente.getPais() + "', "
                + "'" + cliente.getEmail() + "')";
        // metodo DAO
        insertarModificarEliminarDataBase(sql);
    }

    public void eliminarClientePorId(int id) throws Exception {
        // script sql
        String sql = "DELETE FROM clientes WHERE id_cliente =" + id;
        // método DAO
        insertarModificarEliminarDataBase(sql);
    }

    public List<Cliente> listarClientes() throws Exception {
        // script sql
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM cliente";
        // método sql
        consultarDataBase(sql);
        // nueva lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        // ciclo while
        while (resultSet.next()) {
            clientes.add(crearCliente());
        }
        //
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) throws Exception {
        // script sql
        String sql = "UPDATE SET ('"
                + cliente.getNombre() + "', "
                + "'" + cliente.getCalle() + "', "
                + cliente.getNumero() + ", "
                + cliente.getCodigoPostal() + ", "
                + "'" + cliente.getPais() + "', "
                + "'" + cliente.getEmail() + "'"
                + ") WHERE id_cliente = " + cliente.getIdCliente();
        insertarModificarEliminarDataBase(sql);
    }

    public Cliente buscarClientePorID(int id) throws Exception {
        // script sql
        String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes WHERE id = "
                + id;
        // método DAO
        consultarDataBase(sql);
        //
        Cliente cliente = crearCliente();
        return cliente;
    }

    public Cliente crearCliente() throws Exception {
        // validar resulSet
        if (resultSet == null) {
            throw new Exception("No existe el registro!!");
        }
        // crear un nuevo cliente
        return new Cliente(resultSet.getInt("id_cliente"),
                resultSet.getString("nombre"),
                resultSet.getString("calle"),
                resultSet.getInt("numero"),
                resultSet.getInt("codigo_postal"),
                resultSet.getString("ciudad"),
                resultSet.getString("pais"),
                resultSet.getString("email"));
    }

}
