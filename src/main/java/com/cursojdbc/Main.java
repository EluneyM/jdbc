package com.cursojdbc;

import java.sql.Connection;
import java.util.List;

import com.cursojdbc.entidades.Cliente;
import com.cursojdbc.persistencia.ClienteDAO;

public class Main {
    public static Connection conexion;
    public static void main(String[] args) throws Exception {
        Cliente cliente1 = Cliente.makeSimpleCliente("1234", "Sai", "Cervantes");
        Cliente cliente2 = Cliente.makeSimpleCliente("12345", "Luciana", "Soliz");

        ClienteDAO clienteDAO = new ClienteDAO();
        
        clienteDAO.guardarCliente(cliente1);
        clienteDAO.guardarCliente(cliente2);

        List<Cliente> listaClientes = clienteDAO.listarTodosLosClientes();

        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString() + "\n");
        }
    }
}