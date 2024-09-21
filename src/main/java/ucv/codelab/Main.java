package ucv.codelab;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Order;
import ucv.codelab.objetos.OrderDetails;
import ucv.codelab.objetos.Product;

public class Main {

    private static HashSet<Product> products = new HashSet<Product>();

    public static void main(String[] args) {

        // Conecta a la base de datos
        String url = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "pruebas";
        Conexion.crearConexion(url, "root", "");

        // Si el cliente no existe, retorna
        // TODO Creacion de cliente
        if (!Conexion.clientExists("88888888"))
            return;
        // Caso contrario, devuelve el dato en cache
        Client cliente = Cache.getClient("88888888");

        // Cliente crea una orden
        // TODO 

        // Cliente consulta un producto y los que coincidan se añaden a la lista
        products = Cache.getProducts("redmi");

        System.out.println(products);

        // Cliente añade un producto
        // TODO

        // Cliente compra y se cierra la venta
        // TODO

        // TODO probablemente seria mejor guardar solo los detalles de la orden y las
        // preguntas de items hacerlas seguido

        // Datos de prueba
        Product p1 = new Product(100000000, "Item 01", null, 12.30f, 10);
        Product p2 = new Product(100000001, "Item 02", null, 45.60f, 20);
        Product p3 = new Product(100000002, "Item 03", null, 78.90f, 30);

        Order order = new Order(0, cliente.getId(), Timestamp.valueOf(LocalDateTime.now()), 0, "O");
        System.out.println("Compra a realizarse por el cliente: " + cliente.getName());

        order.items.add(new OrderDetails(0, order.getId(), p1.getId(), 10, p1.getPrice()));
        order.items.add(new OrderDetails(0, order.getId(), p2.getId(), 5, p2.getPrice()));
        order.items.add(new OrderDetails(0, order.getId(), p3.getId(), 3, p3.getPrice()));

        System.out.println("Total: " + order.getTotal());
    }
}