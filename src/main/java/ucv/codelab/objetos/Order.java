package ucv.codelab.objetos;

import java.sql.Timestamp;
import java.util.HashSet;

public class Order {

    private int id;
    // Al crear un pedido, se debe añadir aqui
    public HashSet<OrderDetails> items = new HashSet<OrderDetails>();
    private int clientId;
    private final Timestamp date;
    private float total;
    private String status;

    // Si un cliente tiene una venta en curso, se continua con la venta
    public Order(int id, int clientId, Timestamp date, float total, String status) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.total = total;
        //Status: OPEN, CLOSE, CANCELED
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    // Retorna la fecha y hora en milisegundos
    public long getDateTime() {
        return date.getTime();
    }

    public float getTotal() {
        for(OrderDetails o : items){
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
}
