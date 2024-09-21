package ucv.codelab;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Order;
import ucv.codelab.objetos.OrderDetails;
import ucv.codelab.objetos.Product;

public class Cache {

    // Solo guarda los clientes y productos que has buscado
    // DNI:Client || Name:Client
    private static HashMap<String, Client> clients = new HashMap<String, Client>();
    private static HashMap<String, Product> products = new HashMap<String, Product>();

    // Solo guarda las ordenes pendientes
    public static HashMap<Integer, Order> pending = new HashMap<Integer, Order>();
    public static HashSet<OrderDetails> orderDetails = new HashSet<OrderDetails>();

    @Deprecated
    public static Order makeOrder(int clientId) {
        // Retornar si ese cliente tiene una orden abierta
        if (pending.containsKey(clientId))
            return pending.get(clientId);
        /*
         * TODO Crear la orden en la bdd y obtenerla, codigo temporal OPEN, SOLD,
         * CANCELED
         */
        Order order = new Order(11000000, clientId, Timestamp.valueOf(LocalDateTime.now()), 0, "OPEN");

        // Añade los datos a la cache y devuelve la orden
        pending.put(clientId, order);
        return order;
    }

    public static void addClient(Client client) {
        clients.put(client.getDni(), client);
    }

    public static Client getClient(String dni) {
        return clients.get(dni);
    }

    public static void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public static HashSet<Product> getProducts(String name) {
        HashSet<Product> filteredProducts = new HashSet<Product>();

        for (String productName : products.keySet()) {
            if (productName.toLowerCase().contains(name.toLowerCase())) {
                filteredProducts.add(products.get(productName));
            }
        }

        return filteredProducts;
    }
}
