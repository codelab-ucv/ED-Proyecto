package ucv.codelab.gui.boleta;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ucv.codelab.Conexion;
import ucv.codelab.Main;
import ucv.codelab.cache.Client;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.interfaz.Menu;

public class Botones extends JPanel implements Utils {

    private final JButton regresar = new JButton("Regresar");
    private final JButton enviarComprobante = new JButton("Enviar Comprobante");
    private final JButton comprar = new JButton("Confirmar Compra");

    private final Client client;

    public Botones(Client client) {
        this.client = client;

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        regresar.setBackground(BOTON);
        regresar.setFont(H2);
        regresar.setPreferredSize(new Dimension(200, 50));
        regresar.addActionListener(regresar());
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(regresar, constraints);

        enviarComprobante.setBackground(BOTON);
        enviarComprobante.setFont(H2);
        enviarComprobante.setPreferredSize(new Dimension(200, 50));
        enviarComprobante.setVisible(false);
        //enviarComprobante.addActionListener(enviarComprobante());
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(enviarComprobante, constraints);

        comprar.setBackground(BOTON);
        comprar.setFont(H2);
        comprar.setPreferredSize(new Dimension(200, 50));
        comprar.addActionListener(comprar());
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(comprar, constraints);
    }

    private ActionListener regresar() {
        return (ActionEvent e) -> {
            Main.mostrarProductos();
        };
    }

    private ActionListener comprar() {
        return (ActionEvent e) -> {
            // Sube el cliente a la base de datos
            Conexion.updateClient(client);

            // Actualiza el numero de orden local
            // Actualiza el stock de cada producto en la BDD, en la memoria y sube la subOrden
            // Deshabilita boton de comprar y habilita el de enviar comprobante
            comprar.setVisible(false);
            enviarComprobante.setVisible(true);

            // Cancela las busquedas previas
            Menu.bottomPanel.cancelar();
        };
    }
}
