package com.cursojdbc.persistencia;

public class ProductoDAO extends DAO {

    public void eliminarProductoPorCodigo(String cod) throws Exception{
        try {
            String sql = "DELETE FROM producto WHERE codigo_producto = '"+cod+"';";
            insertarModificarEliminarDataBase(sql);

        } catch (Exception e) {
            throw e;
        }
    }
}
