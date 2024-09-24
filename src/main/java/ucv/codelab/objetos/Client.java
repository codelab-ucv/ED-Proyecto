package ucv.codelab.objetos;

public class Client {

    public final int ID;
    public final String NAME;
    public final String DNI;
    private String email;
    private String phone;
    private String address;

    private Order currentOrder;

    // El id del cliente solo se usa para las ordenes
    public Client(int id, String name, String dni, String email, String phone, String address) {
        this.ID = id;
        this.NAME = name;
        this.DNI = dni;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order getCurrrentOrder() {
        // Si tiene una orden en memoria y está abierta
        if (currentOrder != null && currentOrder.getStatus().equals("OPEN"))
            return currentOrder;

        // TODO crear orden en la bdd
        currentOrder = new Order(ID);

        return currentOrder;
    }

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

    // Vende la orden actual
    public void soldOrder() {
        // Actualiza valores
        currentOrder.updateTotal();
        currentOrder.refreshDateTime();
        currentOrder.sell();

        // TODO subir orden, reducir stock de bdd, actualizar las ID de order y details
    }
}
