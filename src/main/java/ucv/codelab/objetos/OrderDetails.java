package ucv.codelab.objetos;

public class OrderDetails {

    private final int id;
    private final int orderId;
    private final int productId;
    private int quantity;
    private float unitPrice;

    // Esta clase puede estar incluida dentro de una lista en la clase Orden
    public OrderDetails(int id, int orderId, int productId, int quantity, float unitPrice) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
