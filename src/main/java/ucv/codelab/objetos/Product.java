package ucv.codelab.objetos;

public class Product {

    public final int ID;
    public final String NAME;
    public final String DESCRIPTION;
    public final float PRICE;

    private int stock;

    /**
     * Crea una copia del producto registrado en la base de datos. El único dato
     * variable es el stock que se verifica al realizar una venta.
     * 
     * @param id          ID del producto
     * @param name        Nombre del producto, usado para la búsqueda
     * @param description Descripcion opcional del producto
     * @param price       Precio unitario del producto
     * @param stock       Stock disponible en la cache, se verifica en la base de
     *                    datos al momento de realizar la venta
     */
    public Product(int id, String name, String description, float price, int stock) {
        this.ID = id;
        this.NAME = name;
        this.DESCRIPTION = description;
        this.PRICE = price;
        this.stock = stock;
    }

    /**
     * Obtiene el stock de la cache, este no se verifica con la base de datos hasta
     * culminar la venta
     * 
     * @return Stock actual
     */
    public int currentStock() {
        return stock;
    }

    /**
     * Sincroniza el stock local con el stock local, debe cancelarse las compras
     * primero
     * 
     * @param stockNube
     */
    public void synchronizeStock(int stockNube) {
        this.stock = stockNube;
    }

    /**
     * Actualiza el stock de un producto en cache
     * 
     * @param quantity Ingresar un valor positivo para hacer compras y un valor
     *                 negativo para hacer las devoluciones
     * @return Retorna {@code false} si la cantidad a comprar es mayor que la del
     *         stock, todos los demás casos retorna {@code true}
     */
    public boolean validTransaction(int quantity) {
        // Si el stock actual es mayor que la cantidad a separar (devoluciones son
        // negativas asi que se vuelve +)
        if (stock - quantity > 0) {
            stock -= quantity;
            return true;
        }

        return false;
    }

}
