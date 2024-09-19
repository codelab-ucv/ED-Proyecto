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

    // Solo guarda los clientes que has buscado
    public static HashMap<String, Client> clients = new HashMap<String, Client>();
    
    // Solo guarda los productos que has buscado
    public static HashSet<Product> products = new HashSet<Product>();
    // Solo guarda las ordenes pendientes
    public static HashMap<Integer, Order> pending = new HashMap<Integer, Order>();
    public static HashSet<OrderDetails> orderDetails = new HashSet<OrderDetails>();

    public static Order makeOrder(int clientId) {
        // Retornar si ese cliente tiene una orden abierta
        if (pending.containsKey(clientId))
            return pending.get(clientId);
        // TODO Crear la orden en la bdd y obtenerla, codigo temporal OPEN, SOLD, CANCELED
        Order order = new Order(11000000, clientId, Timestamp.valueOf(LocalDateTime.now()), 0, "OPEN");

        // Añade los datos a la cache y devuelve la orden
        pending.put(clientId, order);
        return order;
    }

    public static void addItem(int orderId, Product productId) {
        OrderDetails details = new OrderDetails(11000000, orderId, productId.getId(), 1, productId.getPrice());
        orderDetails.add(details);
    }

    // TODO Añadir una funcion para actualizar precios al abrir la orden y otra para
    // eliminarla
}
