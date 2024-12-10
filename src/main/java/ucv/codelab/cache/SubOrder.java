package ucv.codelab.cache;

public class SubOrder {

    private Order order;
    private Product product;
    private int quantity = 0;

    /**
     * Crea una sub orden de manera local, sin subirlo a la bdd
     *
     * @param order Orden principal
     * @param product Producto seleccionado
     * @param quantity Cantidad esperada a comprar
     */
    public SubOrder(Order order, Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
