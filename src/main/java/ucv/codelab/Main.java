package ucv.codelab;

import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ucv.codelab.gui.Utils;
import ucv.codelab.gui.boleta.Boleta;
import ucv.codelab.gui.components.ProductSlot;
import ucv.codelab.gui.interfaz.Menu;

public class Main {

    public static Menu panelPrincipal = new Menu();
    private static Boleta boleta;

    private static final JFrame frame = new JFrame();

    public static void main(String[] args) {
        if (!Conexion.crearConexion()) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // Configurar el frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Utils.DEFAULT_SIZE);
        frame.setMinimumSize(Utils.DEFAULT_SIZE);
        frame.setTitle("Sistema de Ventas de la tienda Artel");
        frame.add(panelPrincipal);

        frame.setVisible(true);
    }

    public static void mostrarBoleta(HashSet<ProductSlot> listaCompras) {
        // Si hay alguna boleta en el frame, la borra
        if (boleta != null) {
            frame.remove(boleta);
        }
        //Crea la nueva boleta
        boleta = new Boleta(listaCompras);
        frame.add(boleta);

        // Oculta el menu de compras y muestra la boleta
        panelPrincipal.setVisible(false);
        // Debe eliminar el panelPrincipal del frame, para que siga cambiando de tamaño
        frame.remove(panelPrincipal);

        boleta.setVisible(true);
    }

    public static void mostrarProductos() {
        // Muestra el menu de compras
        panelPrincipal.setVisible(true);
        // Vuelve a añadir el panel principal al frame
        frame.add(panelPrincipal);

        // Oculta y luego elimina la boleta creada
        boleta.setVisible(false); // Si no se oculta, se queda el botón congelado
        boleta = null;
    }
}
