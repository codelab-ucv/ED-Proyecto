package ucv.codelab.objetos;

public class Product {

    private final int id;
    private final String name;
    private final String description;
    private float price;
    private int stock;

    // El id del producto solo se usa para los detalles de las ordenes
    // El producto solo se añade de manera local luego de subirlo a la bdd
    public Product(int id, String name, String description, float price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
