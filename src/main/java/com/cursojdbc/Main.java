package com.cursojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();

        // Consulta
        try (
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT codigo_cliente, nombre_cliente, limite_credito FROM cliente")
            ) 
        {
            while (rs.next()) {
                int x = rs.getInt("codigo_cliente");
                String s = rs.getString("nombre_cliente");
                double d = rs.getDouble("limite_credito");
                System.out.println("Fila = " + x + " " + s + " " + d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Sentencia preparada

        try (
            PreparedStatement ps = conexion.prepareStatement("UPDATE cliente SET nombre_cliente = 'GoldFish Garden Actualizado' WHERE id_cliente < ?");
        ) {
            ps.setInt(1, 5);
            int n = ps.executeUpdate();

            System.out.println("Executado con éxito!" + n);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cerrarConexion(conexion);
    }

    public static Connection getConnection() {
        String host = "localhost"; // localhost
        String port = "3306"; // por defecto es el puerto que utiliza
        String name = "root"; // usuario de la base de datos
        String password = "rootpassword"; // password de la base de datos
        String database = "vivero"; // nombre de la base de datos recien creada, en este caso vivero.
        // Esto especifica una zona horaria, no es obligatorio de utilizar, pero en
        // algunas zonas genera conflictos de conexión si no existiera
        String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
        // esto indica la ruta de conexion, que es la combinacion de
        // host,usuario,puerto, nombre de la base de datos a la cual queremos
        // conectarnos y la zona horaria (si se precisara).

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, name, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el conector JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión:" + e.getMessage());
            }
        }
    }
}