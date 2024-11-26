package ucv.codelab.cache;

public class Product {
    
    public final int ID;
    public final String NAME;
    public final String IMAGE_URL;
    public final float PRICE;

    private int stock;

    /**
     * Crea una copia del producto registrado en la base de datos. El único dato
     * variable es el stock que se verifica al realizar una venta.
     * 
     * @param id          ID del producto
     * @param name        Nombre del producto, usado para la búsqueda
     * @param imageUrl    Imagen del producto buscado
     * @param price       Precio unitario del producto
     * @param stock       Stock disponible en la cache, se verifica en la base de
     *                    datos al momento de realizar la venta
     */
    public Product(int id, String name, String imageUrl, float price, int stock) {
        this.ID = id;
        this.NAME = name;
        this.IMAGE_URL = imageUrl;
        this.PRICE = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
