package com.cursojdbc.servicios;

import java.security.InvalidParameterException;
import java.time.LocalDate;

import com.cursojdbc.entidades.Estancia;
import com.cursojdbc.persistencia.EstanciaDAO;

public class EstanciaServicio {
    private EstanciaDAO cd;

    public EstanciaServicio() {
        this.cd = new EstanciaDAO();
    }

    public void crearEstancia(
            int idCliente,
            int idCasa,
            String nombreHuesped,
            LocalDate fechaDesde,
            LocalDate fechaHasta) throws Exception {

        validarDatos(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);

        if (!cd.casaEstaDisponible(idCasa, fechaDesde, fechaHasta)) {
            throw new Exception("La casa no está disponible en el periodo " + fechaDesde + " - " + fechaHasta);
        }

        cd.guardarEstancia(new Estancia(
                idCliente,
                idCasa,
                nombreHuesped,
                fechaDesde,
                fechaHasta));
    }

    private void validarDatos(int idCliente,
            int idCasa,
            String nombreHuesped,
            LocalDate fechaDesde,
            LocalDate fechaHasta) throws InvalidParameterException {
        if (idCliente <= 0) {
            throw new InvalidParameterException("El ID del cliente no puede ser menor a 1.");
        }
        if (idCasa <= 0) {
            throw new InvalidParameterException("El ID de la casa no puede ser menor a 1.");
        }
        if (nombreHuesped == null) {
            throw new InvalidParameterException("El nombre del huesped no puede ser nulo.");
        }
        if (fechaDesde == null) {
            throw new InvalidParameterException("Fecha desde no puede ser nulo.");
        }
        if (fechaHasta == null) {
            throw new InvalidParameterException("Fecha hasta no puede ser nulo.");
        }
    }
}
