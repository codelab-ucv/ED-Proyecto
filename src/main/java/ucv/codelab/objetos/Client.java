package ucv.codelab.objetos;

public class Client {

    private final int id;
    private final String name;
    private final String dni;
    private String email;
    private String phone;
    private String address;

    // El id del cliente solo se usa para las ordenes
    public Client(int id, String name, String dni, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
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
}
