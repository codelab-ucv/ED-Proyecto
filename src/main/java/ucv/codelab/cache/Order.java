package ucv.codelab.cache;

import java.sql.Timestamp;
import java.util.HashSet;

public class Order {

    public final String DNI;

    private Timestamp date = null;
    private String status;

    private final HashSet<SubOrder> itemList = new HashSet<>();

    /**
     * Se crea la orden de manera local con el DNI del cliente
     *
     * @param clientDni
     */
    public Order(String clientDni) {
        this.DNI = clientDni;

        this.status = "OPEN";
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getDate() {
        return date;
    }

    public float getTotal() {
        float total = 0;
        for (SubOrder subOrder : itemList) {
            total += subOrder.getQuantity() * subOrder.getProduct().PRICE;
        }
        return total;
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
