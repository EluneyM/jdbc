package com.cursojdbc.servicios;

import java.util.List;

import com.cursojdbc.entidades.Familia;
import com.cursojdbc.persistencia.FamiliaDAO;

public class FamiliaServicio {
    private FamiliaDAO fd;

    public FamiliaServicio() {
        this.fd = new FamiliaDAO();
    }

    public Familia crearNuevaFamilia(String nombre, int edadMinima, int edadMaxima,
            int nroHijos, String email, int idCasaFamilia) throws Exception {

        validacionNombre(nombre);
        Familia familia = new Familia(nombre, edadMinima, edadMaxima, nroHijos, email, idCasaFamilia);
        fd.guardarFamilia(familia);
        return familia;
    }

    public void validacionNombre(String nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre no puede ser nulo.");
        }
    }

    public void obtenerTodasLasFamilias() throws Exception {
        List<Familia> listaFamilias = fd.listarTodasLasFamilias();

        for (Familia familia : listaFamilias) {
            System.out.println(familia.toString());
            System.out.println("-------------------------------------");
        }
    }

    public void eliminarFamilia(Integer id) throws Exception {
        if (id == null) {
            System.out.println("El id no puede ser nulo");
        } else {
            fd.eliminarFamiliaPorId(id);
        }
    }

    public List<Familia> listarFamiliasConHijos() throws Exception {
        return fd.listarFamiliasConHijos();
    }
}
