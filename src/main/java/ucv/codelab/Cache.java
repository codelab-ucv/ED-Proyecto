package ucv.codelab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Order;
import ucv.codelab.objetos.Product;

public class Cache {

    // Solo guarda los clientes y productos que has buscado
    // DNI:Client || Name:Client
    private static HashSet<Client> clients = new HashSet<Client>();
    private static HashSet<Product> products = new HashSet<Product>();

    // Solo guarda las ordenes pendientes
    public static HashMap<Integer, Order> pending = new HashMap<Integer, Order>();

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static Client getClient(String dni) {
        for (Client c : clients) {
            if (c.getDni().equals(dni))
                return c;
            System.out.println(c);
        }
        return null;
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static ArrayList<Product> getProducts(String name) {
        ArrayList<Product> filteredProducts = new ArrayList<Product>();

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase()))
                filteredProducts.add(p);
        }

        return filteredProducts;
    }

    public static void preOrder(int idProduct, int quantity) {

    }

    public static void cancelBuy(Product product, int quantity) {

    }
}
