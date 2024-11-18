package ucv.codelab.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ucv.codelab.gui.App;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;

public class BottomPanel extends JPanel implements Utils {

    private final JTextField txtPrecio;

    private final JButton btnCancelar;
    private final JButton btnComprar;

    public BottomPanel() {
        // Configurar el panel inferior
        setLayout(new GridBagLayout());
        setBackground(null);
        setPreferredSize(new Dimension(600, 60));

        // Crea la constante de GridBag
        GridBagConstraints bottomConstraints = new GridBagConstraints();

        // Configura el boton para cancelar
        btnCancelar = new JButton("Cancelar Todo");
        btnCancelar.setBackground(new Color(168, 252, 97));
        btnCancelar.setFont(H2);
        btnCancelar.setPreferredSize(new Dimension(200, 50));
        btnCancelar.addActionListener(cancelar());
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 0; // Columna 0
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        add(btnCancelar, bottomConstraints);

        // Configura el texto del precio
        txtPrecio = Utils.configureText("Precio: S/ 0.00", H2, 200, 50);
        txtPrecio.setHorizontalAlignment(JTextField.CENTER);
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 1; // Columna 1
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        add(txtPrecio, bottomConstraints);

        // Configura el boton para comprar
        btnComprar = new JButton("Comprar");
        btnComprar.setBackground(new Color(168, 252, 97));
        btnComprar.setFont(H2);
        btnComprar.setPreferredSize(new Dimension(200, 50));
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.EAST; // Alineado a la derecha
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 2; // Columna 2
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        add(btnComprar, bottomConstraints);
    }

    private final HashSet<ProductSlot> listaCompras = new HashSet<>();

    /**
     * Reestablece los datos escritos en los cuadros de texto, elimina la lista
     * de compras actual y elimina los filtros de búsqueda aplicados
     *
     * @return Accion del boton cancelar
     */
    private ActionListener cancelar() {
        return (ActionEvent e) -> {
            App.topPanel.setUserName("");
            App.topPanel.setDni("Ingrese el DNI");
            App.middlePanel.setSearchedProduct("Ingrese el producto");
            
            for (ProductSlot i : listaCompras) {
                i.resetQuantity();
            }
            listaCompras.clear();
            txtPrecio.setText("Precio: S/ 0.00");
            
            App.middlePanel.cancelarBusqueda();
        };
    }

    // Añade un item a la lista de compras y actualiza el precio final
    public void addProductSelected(ProductSlot item) {
        listaCompras.add(item);

        float precioFinal = 0;

        for (ProductSlot i : listaCompras) {
            precioFinal += i.getTotalPrice();
        }

        DecimalFormat formateador = new DecimalFormat("####.##");

        txtPrecio.setText("Precio: S/ " + formateador.format(precioFinal));
    }

    /**
     * Deben de crearse las ordenes y subordenes al realizar la venta, para
     * subir los datos a la nube
     *
     * @param item
     */
    public void soldOrder(ProductSlot item) {
        // TODO acciones al presionar comprar
    }
}
