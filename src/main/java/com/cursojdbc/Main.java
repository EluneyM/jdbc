package com.cursojdbc;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cursojdbc.entidades.Cliente;
import com.cursojdbc.servicios.ClienteServicio;
import com.cursojdbc.servicios.PedidoServicio;

public class Main {
    public static Connection conexion;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ClienteServicio servicioCliente = new ClienteServicio();
        PedidoServicio pedidoServicio = new PedidoServicio();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Pedidos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 3) {
                System.out.println("Saliendo...");
                break;
            }

            try {

                switch (opcion) {
                    case 1:
                        menuCliente(servicioCliente, scanner);
                        break;
                    case 2:
                        menuPedido(pedidoServicio, scanner);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static void menuCliente(ClienteServicio servicioCliente, Scanner scanner) throws Exception {
        System.out.println("\nOpciones Cliente:");
        System.out.println("1. Guardar Cliente");
        System.out.println("2. Buscar Cliente por Código");
        System.out.println("3. Listar Todos los Clientes");
        System.out.println("4. Volver");
        System.out.print("Elige una opción: ");
        int opcionCliente = scanner.nextInt();

        switch (opcionCliente) {
            case 1:
                System.out.println("Ingrese los datos del cliente:");

                System.out.print("Código Cliente: ");
                int codigoCliente = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Nombre Cliente: ");
                String nombreCliente = scanner.nextLine();

                System.out.print("Nombre Contacto: ");
                String nombreContacto = scanner.nextLine();

                System.out.print("Apellido Contacto: ");
                String apellidoContacto = scanner.nextLine();

                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();

                System.out.print("Fax: ");
                String fax = scanner.nextLine();

                System.out.print("Ciudad: ");
                String ciudad = scanner.nextLine();

                System.out.print("Región: ");
                String region = scanner.nextLine();

                System.out.print("País: ");
                String pais = scanner.nextLine();

                System.out.print("Código Postal: ");
                String codigoPostal = scanner.nextLine();

                System.out.print("ID Empleado: ");
                int idEmpleado = scanner.nextInt();

                System.out.print("Límite de Crédito: ");
                double limiteCredito = scanner.nextDouble();

                servicioCliente.crearNuevoCliente(
                        codigoCliente,
                        nombreCliente,
                        nombreContacto,
                        apellidoContacto,
                        telefono,
                        fax,
                        ciudad,
                        region,
                        pais,
                        codigoPostal,
                        idEmpleado,
                        limiteCredito);

                System.out.println("Cliente guardado.");
                break;
            case 2:
                System.out.print("Ingresa el código del cliente: ");
                int codigoBuscarCliente = scanner.nextInt();
                servicioCliente.buscarClientePorCodigo(codigoBuscarCliente);
                break;
            case 3:
                System.out.println("Lista de Clientes:");
                List<Cliente> listaClientes = servicioCliente.listarClientes();

                for (Cliente cliente : listaClientes) {
                    System.out.println(cliente.toString() + "\n");
                }
                break;
            case 4:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void menuPedido(PedidoServicio servicioPedido, Scanner scanner) throws Exception {
        System.out.println("\nOpciones Pedido:");
        System.out.println("1. Guardar Pedido");
        System.out.println("2. Volver");
        System.out.print("Elige una opción: ");
        int opcionPedido = scanner.nextInt();

        switch (opcionPedido) {
            case 1:
                System.out.println("Ingrese los datos del pedido:");

                scanner.nextLine();

                System.out.print("Código Pedido: ");
                String codigoPedido = scanner.nextLine();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                System.out.print("Fecha de Pedido (yyyy-MM-dd): ");
                String fechaPedidoStr = scanner.nextLine();
                Date fechaPedido = dateFormat.parse(fechaPedidoStr);

                System.out.print("Fecha Esperada (yyyy-MM-dd): ");
                String fechaEsperadaStr = scanner.nextLine();
                Date fechaEsperada = dateFormat.parse(fechaEsperadaStr);

                System.out.print("Fecha de Entrega (yyyy-MM-dd): ");
                String fechaEntregaStr = scanner.nextLine();
                Date fechaEntrega = dateFormat.parse(fechaEntregaStr);

                System.out.print("Estado: ");
                String estado = scanner.nextLine();

                System.out.print("Comentarios: ");
                String comentarios = scanner.nextLine();

                System.out.print("ID Cliente: ");
                int idCliente = scanner.nextInt();

                servicioPedido.guardarPedido(codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado,
                        comentarios, idCliente);
                System.out.println("Pedido guardado.");
                break;
            case 2:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }
}