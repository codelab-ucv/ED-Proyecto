package ucv.codelab.cache;

public class Client {

    public final String NAME;
    public final String DNI;

    private Order currentOrder;

    // El id del cliente solo se usa para las ordenes
    public Client(String name, String dni) {
        this.NAME = name;
        this.DNI = dni;
        currentOrder = new Order(DNI);
    }

    public void addSubOrder(SubOrder subOrder){
        if(currentOrder == null)currentOrder = new Order(DNI);
        currentOrder.addItem(subOrder);
    }
}
