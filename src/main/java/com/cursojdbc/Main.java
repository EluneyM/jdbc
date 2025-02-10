package com.cursojdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cursojdbc.servicios.EstanciaServicio;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opcion = -1;

        do {
            try {
                // Mostrar el menú
                System.out.println("Seleccione una opción:");
                System.out
                        .println("1. Buscar y listar familias con al menos 3 hijos y edad máxima inferior a 10 años.");
                System.out.println("2. Buscar y listar casas disponibles para agosto de 2020 en Reino Unido.");
                System.out.println("3. Buscar y listar familias con email Hotmail.");
                System.out.println("4. Consultar casas disponibles a partir de una fecha y número de días.");
                System.out.println("5. Buscar clientes que realizaron una estancia y la casa donde se alojaron.");
                System.out.println("6. Buscar estancias reservadas por un cliente, mostrar nombre, país y ciudad.");
                System.out.println("7. Incrementar el precio por día en un 5% para casas del Reino Unido.");
                System.out.println("8. Obtener número de casas por país.");
                System.out.println("9. Buscar casas del Reino Unido comentadas como 'limpias'.");
                System.out.println("10. Insertar nuevas estancias verificando disponibilidad.");
                System.out.println("0. Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        buscarFamiliasConHijos();
                        break;
                    case 2:
                        buscarCasasDisponiblesReinoUnido();
                        break;
                    case 3:
                        buscarFamiliasConEmailHotmail();
                        break;
                    case 4:
                        consultarCasasDisponibles();
                        break;
                    case 5:
                        buscarClientesConEstancias();
                        break;
                    case 6:
                        buscarEstanciasReservadasPorCliente();
                        break;
                    case 7:
                        incrementarPrecioPorDia();
                        break;
                    case 8:
                        obtenerNumeroCasasPorPais();
                        break;
                    case 9:
                        buscarCasasLimpiasReinoUnido();
                        break;
                    case 10:
                        insertarNuevaEstancia();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }

        } while (opcion != 0);

        sc.close();
    }

    // Métodos que deben ser implementados
    private static void buscarFamiliasConHijos() {
        // Llamar al método que consulta las familias con al menos 3 hijos y edad máxima
        // inferior a 10 años
    }

    private static void buscarCasasDisponiblesReinoUnido() {
        // Llamar al método que consulta las casas disponibles entre el 1 y el 31 de
        // agosto de 2020 en Reino Unido
    }

    private static void buscarFamiliasConEmailHotmail() {
        // Llamar al método que consulta las familias con email Hotmail
    }

    private static void consultarCasasDisponibles() {
        // Llamar al método que consulta las casas disponibles a partir de una fecha
        // dada y un número de días específico
    }

    private static void buscarClientesConEstancias() {
        // Llamar al método que consulta clientes que realizaron estancias y las casas
        // donde se alojaron
    }

    private static void buscarEstanciasReservadasPorCliente() {
        // Llamar al método que consulta las estancias reservadas por un cliente y
        // mostrar información de la casa
    }

    private static void incrementarPrecioPorDia() {
        // Llamar al método que incrementa el precio por día de las casas en Reino Unido
        // en un 5%
    }

    private static void obtenerNumeroCasasPorPais() {
        // Llamar al método que obtiene el número de casas por país
    }

    private static void buscarCasasLimpiasReinoUnido() {
        // Llamar al método que busca casas del Reino Unido con comentarios de "limpias"
    }

    private static void insertarNuevaEstancia() throws Exception {
        System.out.println("Introduzca el ID del cliente:");
        int idCliente = sc.nextInt();

        System.out.println("Introduzca el ID de la casa:");
        int idCasa = sc.nextInt();

        sc.nextLine(); // Limpiar el buffer del scanner después de leer un número entero

        System.out.println("Introduzca el nombre del huésped:");
        String nombreHuesped = sc.nextLine();

        System.out.println("Introduzca la fecha de inicio (formato: YYYY-MM-DD):");
        String fechaDesdeStr = sc.nextLine();
        LocalDate fechaDesde = LocalDate.parse(fechaDesdeStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Introduzca la fecha de fin (formato: YYYY-MM-DD):");
        String fechaHastaStr = sc.nextLine();
        LocalDate fechaHasta = LocalDate.parse(fechaHastaStr, DateTimeFormatter.ISO_LOCAL_DATE);

        EstanciaServicio es = new EstanciaServicio();

        es.crearEstancia(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
    }
}