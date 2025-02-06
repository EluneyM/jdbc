package com.cursojdbc.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cursojdbc.entidades.Familia;

public class FamiliaDAO extends DAO {
    public void guardarFamilia(Familia familia) throws Exception {
        if (familia == null) {
            throw new Exception("La familia no puede ser nula");
        }
        String sql = "INSERT INTO familias (id_familia, nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ("
                + familia.getIdFamilia() + ",'"
                + familia.getNombre() + "',"
                + familia.getEdadMinima() + ","
                + familia.getEdadMaxima() + ","
                + familia.getNumHijos() + ",'"
                + familia.getEmail() + "',"
                + familia.getIdCasaFamilia() + "');";
        insertarModificarEliminarDataBase(sql);
    }

    public void eliminarFamiliaPorId(int id) throws Exception {
        String sql = "DELETE FROM familias WHERE id_familia = " + id;
        insertarModificarEliminarDataBase(sql);
    }

    public List<Familia> listarTodasLasFamilias() throws Exception, SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM familias";
        consultarDataBase(sql);
        List<Familia> familias = new ArrayList<>();
        while (resultSet.next()) {
            familias.add(traerFamilia());
        }
        for (Familia f : familias) {
            System.out.println(f.toString());
        }
        desconectarDataBase();
        return familias;

    }

    public void actualizarFamilia(Familia familia) throws Exception {
        if (familia == null) {
            throw new Exception("La familia no puede ser nula");
        }
        String sql = "UPDATE familias SET nombre = '" + familia.getNombre()
                + "', edad_minima = " + familia.getEdadMinima()
                + ", edad_maxima = " + familia.getEdadMaxima()
                + ", num_hijos = " + familia.getNumHijos()
                + ", email = '" + familia.getEmail()
                + "', id_casa_familia = " + familia.getIdCasaFamilia()
                + "WHERE id_familia = " + familia.getIdFamilia();
        insertarModificarEliminarDataBase(sql);
    }

    public Familia buscarFamiliaPorId(int id) throws Exception {
        String sql = "SELECT * FROM familias WHERE id_familia = " + id;
        consultarDataBase(sql);
        resultSet.next();
        Familia familia = traerFamilia();
        desconectarDataBase();
        System.out.println(familia.toString());
        return familia;

    }

    public Familia traerFamilia() throws Exception {
        Familia familia = new Familia();
        familia.setIdFamilia(resultSet.getInt("id_familia"));
        familia.setNombre(resultSet.getString("nombre"));
        familia.setEdadMinima(resultSet.getInt("edad_minima"));
        ;
        familia.setEdadMaxima(resultSet.getInt("edad_maxima"));
        familia.setNumHijos(resultSet.getInt("num_hijos"));
        familia.setEmail(resultSet.getString("email"));
        familia.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        return familia;
    }

}
