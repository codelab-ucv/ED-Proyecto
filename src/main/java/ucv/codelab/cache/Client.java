package ucv.codelab.cache;

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

    public void addSubOrder(SubOrder subOrder) {
        if (currentOrder == null) {
            currentOrder = new Order(DNI);
        }
        currentOrder.addItem(subOrder);
    }
}
