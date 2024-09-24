package ucv.codelab;

import java.util.ArrayList;
import java.util.HashSet;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Product;

public class Cache {

    // Solo guarda los clientes y productos que has buscado
    // DNI:Client || Name:Client
    private static HashSet<Client> clients = new HashSet<Client>();
    private static HashSet<Product> products = new HashSet<Product>();

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static Client getClient(String dni) {
        for (Client client : clients) {
            if (client.DNI.equals(dni))
                return client;
            System.out.println(client);
        }
        return null;
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static ArrayList<Product> getProducts(String name) {
        ArrayList<Product> filteredProducts = new ArrayList<Product>();

        for (Product product : products) {
            if (product.NAME.toLowerCase().contains(name.toLowerCase()))
                filteredProducts.add(product);
        }

        return filteredProducts;
    }

    public static void preOrder(int idProduct, int quantity) {

    }

    public static void cancelBuy(Product product, int quantity) {

    }
}
