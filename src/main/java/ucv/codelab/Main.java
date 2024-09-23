package ucv.codelab;

import java.util.ArrayList;
import java.util.Scanner;

import ucv.codelab.objetos.Client;
import ucv.codelab.objetos.Product;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Conecta a la base de datos
        Conexion.crearConexion();

        // Si el cliente no existe, retorna
        // TODO Creacion de cliente
        if (!Conexion.clientExists("88888888"))
            return;
        // Caso contrario, devuelve el dato en cache
        Client cliente = Cache.getClient("88888888");

        // Cliente consulta un producto y los que coincidan se añaden a la lista
        ArrayList<Product> products = Cache.getProducts("redmi");
        System.out.println("PRODUCTOS DISPONIBLES:");
        System.out.println("=======================");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }

        // Cliente añade un producto
        System.out.println("=======================");
        System.out.print("Ingrese el producto a su eleccion: ");
        int eleccion = sc.nextInt();
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidad = sc.nextInt();
        System.out.println(products.get(eleccion - 1).getStock());

        cliente.getCurrrentOrder().addItem(products.get(eleccion - 1), cantidad);

        System.out.println("Total: " + cliente.getCurrrentOrder().getTotal());
        cliente.soldOrder();
        System.out.println(products.get(eleccion - 1).getStock());
    }

    public static void exit() {
        System.exit(0);
    }
}