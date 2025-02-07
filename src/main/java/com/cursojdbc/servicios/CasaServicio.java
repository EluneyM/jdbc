package com.cursojdbc.servicios;

import java.time.LocalDate;
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
}
