package ucv.codelab.cache;

public class SubOrder {
    
    // Los id solo se usan si se obtienen datos de la base
    @Deprecated
    public final int ID;
    @Deprecated
    public final int ORDER_ID;
    @Deprecated
    public final int PRODUCT_ID;

    private Order order;
    private Product product;
    private int quantity = 0;

    /**
     * Crea una sub orden de manera local, sin subirlo a la bdd
     * 
     * @param order    Orden principal
     * @param product  Producto seleccionado
     * @param quantity Cantidad esperada a comprar
     */
    public SubOrder(Order order, Product product, int quantity) {
        this.ID = -1;
        this.ORDER_ID = order.ID;
        this.PRODUCT_ID = product.ID;

        this.product = product;
        this.quantity = 0;
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
