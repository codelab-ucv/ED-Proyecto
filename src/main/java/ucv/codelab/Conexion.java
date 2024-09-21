package ucv.codelab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

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
            return downloadProducts();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            System.exit(0);
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

    @Deprecated
    public static void hasOpenOrder(String clientId) throws SQLException {
        PreparedStatement stOrder = getConn()
                .prepareStatement("SELECT * FROM orders WHERE client_id=? AND status=OPEN");
        stOrder.setString(1, clientId);

        ResultSet rsOrder = stOrder.executeQuery();
        // TODO si el cliente no tiene ordenes creadas,
        if (rsOrder.next()) {

        }
    }

    // TODO descargar todos los productos al iniciar el programa

    /**
     * 
     * @param name
     * @return Lista con datos coincidentes
     */
    @Deprecated
    public static HashSet<Product> productList(String name) {
        // Crea una lista de productos vacia
        HashSet<Product> products = new HashSet<Product>();

        try {

            PreparedStatement stProduct = getConn().prepareStatement("SELECT * FROM products WHERE name LIKE ?");
            stProduct.setString(1, "%" + name + "%");

            ResultSet rsProduct = stProduct.executeQuery();

            while (rsProduct.next())
                products.add(new Product(rsProduct.getInt("id"), rsProduct.getString("name"),
                        rsProduct.getString("description"), rsProduct.getFloat("price"), rsProduct.getInt("stock")));

        } catch (SQLException e) {
            System.err.println("Error al consultar el producto: " + e.getMessage());
        }
        // Retorna la lista con las coincidencias
        return products;
    }
}
