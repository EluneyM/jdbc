package com.cursojdbc.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Casa;

public class CasaDAO extends DAO {

    // guardarNombreEntidad

    public void guardarCasa(Casa casa) throws Exception, SQLException, ClassNotFoundException {
        if (casa == null) {
            throw new Exception("La casa no puede ser nula");
        }

        String sql = "INSERT INTO casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) VALUES ('"
                + casa.getCalle() + "', '"
                + casa.getNumero() + "', '"
                + casa.getCodigoPostal() + "', '"
                + casa.getCiudad() + "', '"
                + casa.getPais() + "', '"
                + casa.getFechaDesde() + "', '"
                + casa.getFechaHasta() + "', '"
                + casa.getTiempoMinimo() + "', '"
                + casa.getTiempoMaximo() + "', '"
                + casa.getPrecioHabitacion() + "', '"
                + casa.getTipoVivienda() + "'"
                + ");";

        insertarModificarEliminarDataBase(sql);
    }

    // eliminarNombreEntidadPorId
    public void eliminarCasaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        String sql = "DELETE FROM casas WHERE id_casa = " + id + ";";
        insertarModificarEliminarDataBase(sql);
    }

    // listarTodosLosNombreEntidad
    public List<Casa> listarTodasLasCasas() throws Exception, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM casas;";
        consultarDataBase(sql);

        List<Casa> casas = new ArrayList<>();

        while (resultSet.next()) {
            Casa casa = crearCasa();
            casas.add(casa);
        }

        return casas;
    }

    // actualizarNombreEntidad
    public void actualizarCasa(Casa casa) throws Exception, SQLException, ClassNotFoundException {
        if (casa == null) {
            throw new Exception("La casa no puede ser nula");
        }

        String sql = "UPDATE casas SET calle = " + casa.getCalle() + ", numero = " + casa.getNumero() + ", codigo_postal = " + casa.getCodigoPostal() + ", ciudad = " + casa.getCiudad() + ", pais = " + casa.getPais() + ", fecha_desde = " + casa.getFechaDesde() + ", fecha_hasta = " + casa.getFechaHasta() + ", tiempo_minimo = " + casa.getTiempoMinimo() + ", tiempo_maximo = " + casa.getTiempoMaximo() + ", precio_habitacion = " + casa.getPrecioHabitacion() + ", tipo_vivienda = " + casa.getTipoVivienda() + " WHERE id_casa = " + casa.getIdCasa() + ";";

        insertarModificarEliminarDataBase(sql);
    }

    // buscarNombreEntidadPorId
    public Casa buscarCasaPorId(int id) throws Exception, SQLException, ClassNotFoundException {
        String sql = "SELECT * from casas where id_casa = " + id + ";";
        consultarDataBase(sql);
        Casa casaEncontrada = null;
        while (resultSet.next()) {
            casaEncontrada = crearCasa();
        }

        if (casaEncontrada == null) {
            System.out.printf("Casa con ID %s no encontrada", id);
        } else {
            System.out.println(casaEncontrada.toString());
        }

        return casaEncontrada;
    }

    private Casa crearCasa() throws SQLException {
        return new Casa(
                resultSet.getInt("id_casa"),
                resultSet.getString("calle"),
                resultSet.getInt("numero"),
                resultSet.getString("codigo_postal"),
                resultSet.getString("ciudad"),
                resultSet.getString("pais"),
                resultSet.getDate("fecha_desde").toLocalDate(),
                resultSet.getDate("fecha_hasta").toLocalDate(),
                resultSet.getInt("tiempo_minimo"),
                resultSet.getInt("tiempo_maximo"),
                resultSet.getDouble("precio_habitacion"),
                resultSet.getString("tipo_vivienda"));
    }
}
