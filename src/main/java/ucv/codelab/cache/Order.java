package ucv.codelab.cache;

import java.sql.Timestamp;
import java.util.HashSet;

public class Order {

    /**
     * Utiliza el valor -1 en caso de que sea una orden local, solo usa un ID
     * único en caso de que sea una orden recuperada de la base de datos
     */
    public final int ID;
    public final String DNI;

    private Timestamp date = null;
    private float total;
    private String status;

    private final HashSet<SubOrder> itemList = new HashSet<>();

    /**
     * Se crea la orden de manera local con el DNI del cliente
     *
     * @param clientDni
     */
    public Order(String clientDni) {
        this.ID = -1;
        this.DNI = clientDni;

        this.total = 0;
        this.status = "OPEN";
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getDate() {
        return date;
    }

    public float getTotal() {
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

    public HashSet<SubOrder> getItems() {
        return itemList;
    }

    protected void addItem(SubOrder subOrder) {
        itemList.add(subOrder);
    }
}
