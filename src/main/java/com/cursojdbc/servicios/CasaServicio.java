package com.cursojdbc.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Casa;
import com.cursojdbc.persistencia.CasaDAO;

public class CasaServicio {
    private CasaDAO cd;

    public CasaServicio() {
        this.cd = new CasaDAO();
    }

    public void crearCasa(
            String calle,
            int numero,
            String codigoPostal,
            String ciudad,
            String pais,
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            int tiempoMinimo,
            int tiempoMaximo,
            double precioHabitacion,
            String tipoVivienda) throws Exception {

        // TODO: falta validación
        cd.guardarCasa(new Casa(
                calle,
                numero,
                codigoPostal,
                ciudad,
                pais,
                fechaDesde,
                fechaHasta,
                tiempoMinimo,
                tiempoMaximo,
                precioHabitacion,
                tipoVivienda));
    }

    public void actualizarCasa(
            int idCasa,
            String calle,
            int numero,
            String codigoPostal,
            String ciudad,
            String pais,
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            int tiempoMinimo,
            int tiempoMaximo,
            double precioHabitacion,
            String tipoVivienda) throws Exception {
        // TODO: falta validación
        cd.actualizarCasa(new Casa(
                idCasa,
                calle,
                numero,
                codigoPostal,
                ciudad,
                pais,
                fechaDesde,
                fechaHasta,
                tiempoMinimo,
                tiempoMaximo,
                precioHabitacion,
                tipoVivienda));
    }

    public List<Casa> listarCasas() throws Exception {
        return cd.listarTodasLasCasas();
    }

    public Casa buscarCasaPorId(int id) throws Exception {
        return cd.buscarCasaPorId(id);
    }

    public void eliminarCasaPorId(int id) throws Exception {
        cd.eliminarCasaPorId(id);
    }

    public void listarCasasDisponibles(String pais, LocalDate fechaDesde, int cantidadDias) throws Exception {
        ArrayList<Casa> casasDisponibles = cd.listarCasasDisponibles(pais, fechaDesde, cantidadDias);
        if (casasDisponibles.isEmpty()) {
            System.out.println("No se encontraron casas disponibles");
        }

        if (cantidadDias <= 0) {
            System.out.println("Cantidad de días debe ser mayor a cero.");
        }

        if (fechaDesde == null) {
            System.out.println("Ninguna fecha puede ser null");
        } else {
            System.out.println("Las casas disponibles son: ");
            for (Casa casa : casasDisponibles) {
                System.out.println("ID: " + casa.getIdCasa());
                System.out.println("Pais: " + casa.getPais());
                System.out.println("Fecha desde: " + casa.getFechaDesde());
                System.out.println("Fecha hasta: " + casa.getFechaHasta());
                System.out.println("--------------------------");
            }

        }
    }
}
