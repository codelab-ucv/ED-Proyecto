package ucv.codelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ucv.codelab.objetos.Client;

public class Conexion {

    private static Connection conn;

    /**
     * Retorna la instancia actual de la conexion.
     */
    public static Connection getConn() {
        return Conexion.conn;
    }

    /**
     * Conecta a la base de datos
     */
    public static boolean crearConexion(String url, String user, String password) {
        try {
            // Cierra la conexion antigua (si existe)
            if (conn != null && !conn.isClosed())
                conn.close();

            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);

            // Descargar datos
            return downloadData();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        }
    }

    /**
     * Descarga los datos de la tabla. Envia el mensaje con el error en caso de que
     * no se logre descargar los valores y estos todavía existan
     * 
     * @return Retorna {@code true} si logra leer y descargar las tablas.
     */
    private static boolean downloadData() {
        try {
            return true;
        } catch (Exception e) {
            System.err.println("Error al descargar datos de la base: " + e.getMessage());
            return false;
        }
    }

    /**
     * Verifica si un cliente existe en la base de datos
     * 
     * @param dni DNI del cliente
     * @return Retorna {@code false} si el cliente no está en la base de datos, caso
     *         contrario lo añade a la cache y retorna {@code true}
     */
    public static boolean clientExists(String dni) {
        try {
            PreparedStatement stClient = getConn().prepareStatement("SELECT * FROM clients WHERE dni=?");
            stClient.setString(1, dni);

            ResultSet rsClient = stClient.executeQuery();
            if (rsClient.next()) {
                // Si existe, añade el dato a la cache y retorna true
                Client client = new Client(rsClient.getInt("id"), rsClient.getString("name"), rsClient.getString("dni"),
                        rsClient.getString("email"), rsClient.getString("phone"), rsClient.getString("address"));
                Cache.clients.put(dni, client);
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el cliente: " + e.getMessage());
        }
        // En cualquier otra situacion retorna true;
        return false;
    }
}
