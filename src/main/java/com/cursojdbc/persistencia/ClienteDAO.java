package com.cursojdbc.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Cliente;

public class ClienteDAO extends DAO {

    public void guardarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, pais, codigo_postal, id_empleado, limite_credito) VALUES ('"
                + cliente.getCodigoCliente() + "', '"
                + cliente.getNombreCliente() + "', '"
                + cliente.getNombreContacto() + "', '"
                + cliente.getApellidoContacto() + "', '"
                + cliente.getTelefono() + "', '"
                + cliente.getFax() + "', '"
                + cliente.getCiudad() + "', '"
                + cliente.getRegion() + "', '"
                + cliente.getPais() + "', '"
                + cliente.getCodigoPostal() + "', '"
                + cliente.getIdEmpleado() + "', '"
                + cliente.getLimiteCredito() + "'"
                + ");";

        insertarModificarEliminarDataBase(sql);
    }

    public void  buscarClientePorCodigo(int codigo) throws Exception{
        try {
            String sql = "SELECT * from cliente where codigo_cliente = "+codigo+";";
            consultarDataBase(sql);
            Cliente clienteEncontrado = null;
            while (resultSet.next()) {
               clienteEncontrado = Cliente.make(
                    resultSet.getInt("codigo_cliente"),
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("nombre_contacto"),
                    resultSet.getString("apellido_contacto"),
                    resultSet.getString("telefono"),
                    resultSet.getString("fax"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("region"),
                    resultSet.getString("pais"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getInt("id_empleado"),
                    resultSet.getDouble("limite_credito"));
            }
            
            if (clienteEncontrado == null) {
                System.out.printf("Cliente con código %s no encontrado", codigo);
            } else {
                System.out.println(clienteEncontrado.toString());
            }

        } catch (Exception e) {
           throw e;
        }
    }

    public List<Cliente> listarTodosLosClientes() throws Exception {
        String sql = "SELECT * FROM cliente;";
        consultarDataBase(sql);

        List<Cliente> clientes = new ArrayList<>();

        while (resultSet.next()) {
            Cliente cliente = Cliente.make(
                    resultSet.getInt("codigo_cliente"),
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("nombre_contacto"),
                    resultSet.getString("apellido_contacto"),
                    resultSet.getString("telefono"),
                    resultSet.getString("fax"),
                    resultSet.getString("ciudad"),
                    resultSet.getString("region"),
                    resultSet.getString("pais"),
                    resultSet.getString("codigo_postal"),
                    resultSet.getInt("id_empleado"),
                    resultSet.getDouble("limite_credito"));

            clientes.add(cliente);
        }

        return clientes;
    }

    public void eliminarClientePorId(int id) throws Exception {
        String sql = "DELETE FROM cliente WHERE id_cliente = " + id + ";";
        insertarModificarEliminarDataBase(sql);
    }
}
