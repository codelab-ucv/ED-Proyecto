package ucv.codelab.cache;

import ucv.codelab.gui.components.ProductSlot;

public class Client {

    public final String NAME;
    public final String DNI;
    public String email;
    public String phone;

    private Order currentOrder;

    // El id del cliente solo se usa para las ordenes
    public Client(String dni, String name, String email, String phone) {
        this.DNI = dni;
        this.NAME = name;
        this.email = email;
        this.phone = phone;
        currentOrder = new Order(DNI);
    }

    public void addSubOrder(ProductSlot productSlot) {
        if (currentOrder == null) {
            currentOrder = new Order(DNI);
        }
        currentOrder.addItem(new SubOrder(currentOrder, productSlot.getProduct(), productSlot.getQuantity()));
    }

    public Order getCurrentOrder() {
        if (currentOrder == null) {
            currentOrder = new Order(DNI);
        }
        return currentOrder;
    }
}
