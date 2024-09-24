package ucv.codelab.objetos;

public class OrderDetails {

    // Los id solo se usan si se obtienen datos de la base
    public final int ID;
    public final int ORDER_ID;
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
    public OrderDetails(Order order, Product product, int quantity) {
        this.ID = -1;
        this.ORDER_ID = order.ID;
        this.PRODUCT_ID = product.ID;

        this.product = product;
        modifyQuantity(quantity);
    }

    public float getUnitPrice() {
        return product.PRICE;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Si hay el stock disponible, modifica la cantidad separada por el cliente y
     * actualiza el precio final de la orden
     * 
     * @param quantity La nueva cantidad a comprar
     * @return {@code true} Si la compra/devolución es correcta, {@code false} solo
     *         si el stock no es suficiente
     */
    public boolean modifyQuantity(int quantity) {
        // Si la cantidad nueva - la actual es > 0 es una compra
        int temporal = quantity - this.quantity;
        // Si la compra/devolucion es valida, separa la cache y guarda los detalles
        if (product.validTransaction(temporal)) {
            this.quantity = quantity;
            order.updateTotal();
            return true;
        }
        return false;
    }
}
