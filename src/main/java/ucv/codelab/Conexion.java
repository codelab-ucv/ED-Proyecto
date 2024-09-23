package ucv.codelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Product;

public class Conexion {

    private static Connection conn;

    /**
     * Retorna la instancia actual de la conexion.
     */
    public static Connection getConn() {
        return Conexion.conn;
    }

    /**
     * Crea la conexion a base de datos
     * 
     * @return {@code true} si se logra establecer la conexion
     */
    public static boolean crearConexion() {
        // Ingresa los datos de pruebas
        String url = "jdbc:mysql://localhost:3306/pruebas";
        String user = "root";
        String password = "";

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);

            // Descargar datos
            return downloadProducts();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            Main.exit();
            return false;
        }
    }

    /**
     * Descarga los productos de la base de datos
     * 
     * @return Retorna {@code true} si logra leer y descargar las tablas.
     * @throws SQLException
     */
    private static boolean downloadProducts() throws SQLException {
        Statement stProduct = conn.createStatement();
        ResultSet rsProduct = stProduct.executeQuery("SELECT * FROM products");

        while (rsProduct.next()) {
            Cache.addProduct(new Product(rsProduct.getInt("id"), rsProduct.getString("name"),
                    rsProduct.getString("description"), rsProduct.getFloat("price"), rsProduct.getInt("stock")));
        }
        return true;
    }

    /**
     * Verifica si un cliente existe en la base de datos o en la cache
     * 
     * @param dni DNI del cliente
     * @return Retorna {@code false} si el cliente no está en la base de datos, caso
     *         contrario lo añade a la cache y retorna {@code true}
     */
    public static boolean clientExists(String dni) {
        if (Cache.getClient(dni) != null) {
            return true;
        }

        try {
            PreparedStatement stClient = getConn().prepareStatement("SELECT * FROM clients WHERE dni=?");
            stClient.setString(1, dni);

            ResultSet rsClient = stClient.executeQuery();
            if (rsClient.next()) {
                // Si existe, añade el dato a la cache y retorna true
                Cache.addClient(new Client(rsClient.getInt("id"), rsClient.getString("name"), rsClient.getString("dni"),
                        rsClient.getString("email"), rsClient.getString("phone"), rsClient.getString("address")));
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el cliente: " + e.getMessage());
        }
        // En cualquier otra situacion retorna false;
        return false;
    }
}
