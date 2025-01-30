package com.cursojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static Connection conexion;
    public static void main(String[] args) throws Exception {
        conexion = getConnection();

        //buscarClientes(conexion);

        //buscarClientePorCodigo(4);

        buscarClientesPorEmpleado(11);

        cerrarConexion(conexion);
    }

    // Realiza un método llamado  buscarClientesPorEmpleado(codigo) que reciba el código del empleado como parámetro y muestre todos los clientes asociados a un empleado en particular. Puedes elegir qué campos mostrar en tu método.
    public static void buscarClientesPorEmpleado(int codigo) {
        String sql = "SELECT * FROM cliente c JOIN empleado e ON c.id_empleado = e.id_empleado WHERE e.codigo_empleado =  " + codigo;

        try {
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             int count = 0;
             while (rs.next()) {
                  int codigoCliente = rs.getInt("codigo_cliente");
                  String nombre = rs.getString("nombre_contacto");
                  String apellido = rs.getString("apellido_contacto");
                  int codigoEmpleado = rs.getInt("codigo_empleado");
                  String telefono = rs.getString("telefono");
                  count++;
                  System.out.println(count + " - " + codigoCliente + " - " + "codigo empleado: " + codigoEmpleado + " - " + nombre + " " + apellido + " -  " + telefono);
             }
             // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
             rs.close();
             stmt.close();
        } catch (SQLException e) {
             System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // Realiza un método llamado buscarClientePorCodigo(codigo) que reciba como parámetro el código del cliente y muestre por pantalla los datos que tiene el cliente guardado en la base de datos. 
    public static void buscarClientePorCodigo(int codigo) {
        String sql = "SELECT * FROM cliente WHERE codigo_cliente =  " + codigo;
        try {
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             int count = 0;
             while (rs.next()) {
                  int codigoCliente = rs.getInt("codigo_cliente");
                  String nombre = rs.getString("nombre_contacto");
                  String apellido = rs.getString("apellido_contacto");
                  String telefono = rs.getString("telefono");
                  count++;
                  System.out.println(count + " - " + codigoCliente + " - " + nombre + " " + apellido + " -  " + telefono);
             }
             // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
             rs.close();
             stmt.close();
        } catch (SQLException e) {
             System.out.println("Error en la consulta: " + e.getMessage());
        }
    }


    //Crea un método llamado buscarClientes() dentro de tu clase App. Este método debe conectarse a la base de datos y recuperar la información de los clientes almacenados en la base de datos vivero. La consulta SQL debe recuperar el nombre, apellido y teléfono de todos los clientes. Los resultados deben imprimirse en consola.

    public static void buscarClientes(Connection conexion) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
          try {
               Statement stmt = conexion.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               int count = 0;
               while (rs.next()) {
                    String nombre = rs.getString("nombre_contacto");
                    String apellido = rs.getString("apellido_contacto");
                    String telefono = rs.getString("telefono");
                    count++;
                    System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
               }
               // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
               rs.close();
               stmt.close();
          } catch (SQLException e) {
               System.out.println("Error en la consulta: " + e.getMessage());
          }
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