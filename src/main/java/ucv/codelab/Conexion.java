package ucv.codelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ucv.codelab.cache.Product;
import ucv.codelab.gui.App;

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
            App.addProduct(new Product(rsProduct.getInt("id"), rsProduct.getString("name"),
                    rsProduct.getString("image"), rsProduct.getFloat("price"), rsProduct.getInt("stock")));
        }
        return true;
    }
}
