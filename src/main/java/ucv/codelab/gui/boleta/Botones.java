package ucv.codelab.gui.boleta;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ucv.codelab.Conexion;
import ucv.codelab.Main;
import ucv.codelab.cache.Client;
import ucv.codelab.cache.SubOrder;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.interfaz.Menu;
import ucv.codelab.mensaje.SendEmail;

public class Botones extends JPanel implements Utils {

    private final JButton regresar = new JButton("Regresar");
    private final JButton enviarComprobante = new JButton("Enviar Comprobante");
    private final JButton comprar = new JButton("Confirmar Compra");

    private final Client client;
    private final Comprobante comprobante;

    public Botones(Client client, Comprobante comprobante) {
        this.client = client;
        this.comprobante = comprobante;

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
        enviarComprobante.addActionListener((ActionEvent e) -> {
            String correo = JOptionPane.showInputDialog(null, "Ingrese el correo de destino", client.email);
            
            // Si se cancela el envio retorna
            if (correo == null || correo == "") {
                return;
            }

            // Cambia temporalmente el correo de contacto
            String antiguoCorreo = client.email;
            client.email = correo;

            // Si el correo no se logra enviar correctamente, regresa localmente al valor
            // anterior
            if (!SendEmail.send(client)) {
                client.email = antiguoCorreo;
                return;
            }

            // Si es que se logra enviar, actualiza tambien en la base de datos
            Conexion.updateClient(client);
        });
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

            // Sube la orden a la base de datos y obtiene su ID
            client.getCurrentOrder().setStatus("SOLD");
            int orderId = Conexion.uploadOrder(client);

            // Actualiza el numero de orden local
            client.getCurrentOrder().setID(orderId);
            comprobante.setNumeroBoleta(client.getCurrentOrder().getID());

            // Para todos los productos
            for (SubOrder subOrder : client.getCurrentOrder().getItems()) {
                int nuevoStock = subOrder.getProduct().getStock() - subOrder.getQuantity();

                // Actualiza el stock en la memoria local
                subOrder.getProduct().setStock(nuevoStock);

                // Luego en la BDD
                Conexion.updateStock(subOrder.getProduct(), nuevoStock);

                // Finalmente sube la subOrden
                Conexion.uploadSubOrder(subOrder, orderId);

                Menu.middlePanel.refreshStock(subOrder.getProduct().NAME);
            }

            // Deshabilita boton de comprar y habilita el de enviar comprobante
            comprar.setVisible(false);
            enviarComprobante.setVisible(true);

            // Cancela las busquedas previas
            Menu.bottomPanel.cancelar();
        };
    }
}
