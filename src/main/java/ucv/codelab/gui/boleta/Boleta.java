package ucv.codelab.gui.boleta;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ucv.codelab.Conexion;
import ucv.codelab.cache.Client;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;

public class Boleta extends JFrame implements Utils {

    public JPanel panel = new JPanel(new GridBagLayout());

    private Client client;

    public Boleta(HashSet<ProductSlot> listaCompras) {
        setSize(new Dimension(720, 500));

        cargarCliente();

        // Crea la constante de GridBag
        GridBagConstraints topConstraints = new GridBagConstraints();

        // Configura el titulo
        JTextField titulo = Utils.configureText("Tienda Artel", H2, 200, 60);
        topConstraints.insets = new Insets(5, 5, 5, 5);
        topConstraints.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 0; // Fila 0
        topConstraints.gridwidth = 2; // Ocupa 2 columnas
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        panel.add(titulo, topConstraints);

        // Configura el titulo
        JTextField cliente = Utils.configureText(client.NAME, H3, 200, 60);
        topConstraints.insets = new Insets(0, 5, 0, 5);
        topConstraints.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 1; // Columna 1
        topConstraints.gridy = 1; // Fila 1
        topConstraints.gridwidth = 2; // Ocupa 2 columnas
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        panel.add(cliente, topConstraints);

        add(panel);
    }

    private void cargarCliente() {
        String dni, nombre;

        // Ingresa el DNI
        do {
            dni = JOptionPane.showInputDialog(null, "Ingrese el DNI del cliente",
                    "Busqueda de cliente", JOptionPane.PLAIN_MESSAGE);
        } while (dni == null || dni.equals(""));

        // Si es que el cliente ya existe retorna
        if (Conexion.clientExists(dni)) {
            // Descarga los datos 
            client = Conexion.getClient(dni);
            return;
        }

        // Si no existe, pregunta por el nombre del cliente
        do {
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente",
                    "Busqueda de cliente", JOptionPane.PLAIN_MESSAGE);
        } while (nombre == null || nombre.equals(""));

        // Crea de manera local el cliente usando el dni y nombre insertados
        client = new Client(dni, nombre, "", "");
    }
}
