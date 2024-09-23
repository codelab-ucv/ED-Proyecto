package ucv.codelab.objetos;

import java.sql.Timestamp;
import java.util.HashSet;

public class Order {

    private final int id;
    // Al crear un pedido, se debe añadir aqui
    @Deprecated
    public HashSet<OrderDetails> items = new HashSet<OrderDetails>();
    private final int clientId;
    private Timestamp date;
    private float total;
    private String status;

    // Si un cliente tiene una venta en curso, se continua con la venta
    public Order(int id, int clientId, Timestamp date, float total, String status) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.total = total;
        // Status: OPEN, CLOSE, CANCELED
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    // Retorna la fecha y hora en milisegundos
    public long getDateTime() {
        return date.getTime();
    }

    // Refresca el tiempo solo si la orden esta abierta
    public void refreshDateTime() {
        if (status.equals("OPEN")) {
            date = new Timestamp(System.currentTimeMillis());
        }
    }

    public float getTotal() {
        for (OrderDetails o : items) {
            total += o.getUnitPrice() * o.getQuantity();
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addItem(Product item, int quantity) {
        int finalStock = item.getStock() - quantity;
        if (finalStock >= 0) {
            item.setStock(item.getStock() - quantity);
            items.add(new OrderDetails(1, this.getId(), item.getId(), quantity, item.getPrice()));
        }
        else{
            System.out.println("El pedido sobrepasa el stock, no se ha añadido a la compra.");
        }

    }
}
