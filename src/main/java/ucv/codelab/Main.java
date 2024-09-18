package ucv.codelab;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Order;
import ucv.codelab.objetos.OrderDetails;
import ucv.codelab.objetos.Product;

public class Main {
    public static void main(String[] args) {
        // Datos de prueba
        Product p1 = new Product(100000000, "Item 01", null, 12.30f, 10);
        Product p2 = new Product(100000001, "Item 02", null, 45.60f, 20);
        Product p3 = new Product(100000002, "Item 03", null, 78.90f, 30);

        Client cliente = new Client(10000000, "User Name", "88888888", "email@email.com", null, null);

        Order order = new Order(0, cliente.getId(), Timestamp.valueOf(LocalDateTime.now()), 0, "O");
        System.out.println("Compra a realizarse por el cliente: " + cliente.getName());

        order.items.add(new OrderDetails(0, order.getId(), p1.getId(), 10, p1.getPrice()));
        order.items.add(new OrderDetails(0, order.getId(), p2.getId(), 5, p2.getPrice()));
        order.items.add(new OrderDetails(0, order.getId(), p3.getId(), 3, p3.getPrice()));

        System.out.println("Total: " + order.getTotal());
    }
}