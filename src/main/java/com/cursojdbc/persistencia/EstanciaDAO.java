package com.cursojdbc.persistencia;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Estancia;

public class EstanciaDAO extends DAO {

    public void guardarEstancia(Estancia estancia) throws Exception {
        String sql = "INSERT INTO estancias(id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) ('"
                + estancia.getIdCliente() + "', '"
                + estancia.getIdCasa() + "', '"
                + estancia.getNombreHuesped() + "', '"
                + estancia.getFechaDesde() + "', '"
                + estancia.getFechaHasta() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia;
        insertarModificarEliminarDataBase(sql);
    }

    // get
    public List<Estancia> listarTodasLasEstancias() throws Exception {
        String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias";
        consultarDataBase(sql);

        List<Estancia> estancias = new ArrayList<>();

        while (resultSet.next()) {
            Estancia estancia = crearEstancia();
            estancias.add(estancia);
        }
        return estancias;
    }

    public void actualizarEstancia(int idEstancia, int idCliente, int idCasa, String nombreHuesped,
            LocalDate fechaDesde,
            LocalDate fechaHasta) throws Exception {
        String sql = "UPDATE estancias SET id_cliente = " + idCliente + ", id_casa = " + idCasa + ", nombre_huesped = '"
                + nombreHuesped + "', fecha_desde = '" + fechaDesde + "', fecha_hasta = '" + fechaHasta
                + "' WHERE id_estancia = " + idEstancia;
        insertarModificarEliminarDataBase(sql);
    }

    public Estancia buscarEstanciaPorId(int id) throws Exception {
        String sql = "SELECT * from estancias where id_estancia = " + id + ";";
        consultarDataBase(sql);
        Estancia estanciaEncontrada = null;
        while (resultSet.next()) {
            estanciaEncontrada = crearEstancia();
        }

        if (estanciaEncontrada == null) {
            System.out.printf("Estancia con ID %s no encontrada", id);
        } else {
            System.out.println(estanciaEncontrada.toString());
        }

        return estanciaEncontrada;
    }

    private Estancia crearEstancia() throws SQLException {
        return new Estancia(
                resultSet.getInt("id_estancia"),
                resultSet.getInt("id_cliente"),
                resultSet.getInt("id_casa"),
                resultSet.getString("nombre_huesped"),
                resultSet.getDate("fecha_desde").toLocalDate(),
                resultSet.getDate("fecha_hasta").toLocalDate());
    }
}
