package ucv.codelab.objetos;

import java.sql.Timestamp;
import java.util.HashSet;

import ucv.codelab.Conexion;

public class Order {

    /**
     * Utiliza el valor -1 en caso de que sea una orden local, solo usa un ID único
     * en caso de que sea una orden recuperada de la base de datos
     */
    public final int ID;
    public final int CLIENT_ID;

    private Timestamp date;
    private float total;
    private String status;

    private HashSet<OrderDetails> itemList = new HashSet<OrderDetails>();

    /**
     * Se crea la orden de manera local con el horario actual
     * 
     * @param clientId
     */
    public Order(int clientId) {
        this.ID = -1;
        this.CLIENT_ID = clientId;

        this.date = new Timestamp(System.currentTimeMillis());
        this.total = 0;
        this.status = "OPEN";
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

    /**
     * Actualiza el precio a pagar en una orden
     * 
     * @return El nuevo monto a pagar
     */
    public float updateTotal() {
        for (OrderDetails o : itemList) {
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

    /**
     * Cierra la venta
     * TODO falta completar
     */
    public void sell() {
        for (OrderDetails item : itemList) {
            if (!Conexion.checkStock(item)) {
                System.out.println("El item ");
            }
        }

        // Para cada item
    }

    /**
     * Añade un nuevo producto en la cantidad deseada.
     * 
     * @param item     Producto seleccionado
     * @param quantity Cantidad deseada a comprar, si no se puede se establece en 0
     */
    public void addItem(Product item, int quantity) {
        itemList.add(new OrderDetails(this, item, quantity));
    }

    /**
     * Obtiene la suborden del item en la lista de compras
     * 
     * @param id ID del item deseado
     * @return {@code OrderDetails} deseado en caso de encontrarlo, caso contrario
     *         retorna {@code null}.
     */
    public OrderDetails getItem(int id) {
        for (OrderDetails od : itemList) {
            if (od.ID == id)
                return od;
        }
        return null;
    }
}
