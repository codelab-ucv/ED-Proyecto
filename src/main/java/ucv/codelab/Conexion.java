package ucv.codelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ucv.codelab.cache.Client;
import ucv.codelab.cache.Product;
import ucv.codelab.gui.interfaz.Menu;

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
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);

            // Descargar datos
            return downloadProducts();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            //Main.exit();
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
            // Añade el producto a la lista
            Menu.addProduct(new Product(rsProduct.getInt("id"), rsProduct.getString("name"),
                    rsProduct.getString("image"), rsProduct.getFloat("price"),
                    rsProduct.getInt("stock")));
        }
        return true;
    }

    public static boolean clientExists(String document) {
        try {
            PreparedStatement stClient = conn.prepareStatement("SELECT * FROM clients WHERE dni=?");
            stClient.setString(1, document);

            ResultSet rsClient = stClient.executeQuery();
            return rsClient.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public static Client getClient(String document) {
        try {
            PreparedStatement stClient = conn.prepareStatement("SELECT * FROM clients WHERE dni=?");
            stClient.setString(1, document);

            ResultSet rsClient = stClient.executeQuery();

            Client client = null;

            if (rsClient.next()) {
                client = new Client(rsClient.getString("dni"), rsClient.getString("name"),
                        rsClient.getString("email"), rsClient.getString("phone"));
            }

            return client;
        } catch (SQLException e) {
            return null;
        }
    }
}
