package ucv.codelab.gui.boleta;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import ucv.codelab.Conexion;
import ucv.codelab.cache.Client;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;

public class Boleta extends JPanel implements Utils {

    private Client client;

    public Boleta(HashSet<ProductSlot> listaCompras) {
        setLayout(new GridBagLayout());

        // Primero carga el cliente
        cargarCliente();

        // Luego carga las subordenes
        for (ProductSlot productSlot : listaCompras) {
            client.addSubOrder(productSlot);
        }

        // Crea la constante de GridBag
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(20, 20, 0, 0);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(new Datos(client.getCurrentOrder()), constraints);

        constraints.insets = new Insets(20, 0, 0, 20);
        constraints.anchor = GridBagConstraints.NORTHEAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        add(new Comprobante(), constraints);

        constraints.insets = new Insets(10, 20, 0, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        add(new DetallesCompra(client), constraints);

        constraints.insets = new Insets(10, 20, 0, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(new Total(client.getCurrentOrder()), constraints);

        // Configura la linea divisora
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(null);
        separador.setBackground(Color.LIGHT_GRAY);
        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(separador, constraints);
        
        constraints.insets = new Insets(0, 20, 10, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(new Botones(client), constraints);
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
