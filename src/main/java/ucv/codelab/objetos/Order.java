package ucv.codelab.objetos;

import java.sql.Time;

public class Order {

    private int id;
    private int clientId;
    private final Time date;
    private float total;

    // El id solo se debe generar si es que se guarda la venta
    public Order(int id, int clientId, Time date, float total) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.total = total;
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

    public Time getDate() {
        return date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
