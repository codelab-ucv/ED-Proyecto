package ucv.codelab.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ucv.codelab.cache.Product;

public class ItemPanel extends JPanel {

    private final Product producto = new Product(1, "Producto de pruebas", "", 15.5f, 20);

    public ItemPanel() {
        //lA IMAGEN TENDRA 256 X 256 DE ANCHO
        setBorder(new LineBorder(Color.BLACK));
        // Borrar luego
        setPreferredSize(new Dimension(220, 268));

        //Crea la constante de GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Imagen ocupará 1x1

        // Configura la imagen 
        JLabel imagen = new JLabel("");
        imagen.setBorder(new LineBorder(Color.BLACK));
        imagen.setPreferredSize(new Dimension(198, 198));
        imagen.setIcon(new ImageIcon(producto.IMAGE_PATH));
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.NORTH; // Alineado al centro norte
        constraints.fill = GridBagConstraints.NONE; // No se estira el componente
        constraints.gridx = 0; // Columna 0
        constraints.gridy = 0; // Fila 0
        constraints.gridwidth = 2; // Ocupa 2 columnas
        constraints.gridheight = 1; // Ocupa una fila
        constraints.weightx = 0; // No se estira en ancho
        constraints.weighty = 0; // No se estira en alto
        add(imagen, constraints);

        // Configura el nombre del producto
        JTextField nombre = Utils.configureText(producto.NAME, Utils.H3, 160, 38);
        constraints.insets = new Insets(0, 10, 10, 10);
        constraints.anchor = GridBagConstraints.SOUTHWEST; // Alineado abajo a la izquierda
        constraints.fill = GridBagConstraints.NONE; // No se estira el componente
        constraints.gridx = 0; // Columna 0
        constraints.gridy = 1; // Fila 1
        constraints.gridwidth = 1; // Ocupa una columna
        constraints.gridheight = 1; // Ocupa una fila
        constraints.weightx = 0; // No se estira en ancho
        constraints.weighty = 0; // No se estira en alto
        add(nombre, constraints);

        JTextField precioUnitario = Utils.configureText("Precio unitario: S/ " + producto.PRICE, Utils.H3, 20, 20);

        //add(nombre);

        //add(precioUnitario);

        // Configura el cuadro de texto
        JTextField txtCantidad = Utils.editableText("0", Utils.H3, 28, 38);
        txtCantidad.setHorizontalAlignment(JTextField.CENTER);
        constraints.insets = new Insets(0, 0, 10, 10);
        constraints.anchor = GridBagConstraints.SOUTHEAST; // Alineado a la derecha
        constraints.fill = GridBagConstraints.NONE; // No se estira el componente
        constraints.gridx = 1; // Columna 1
        constraints.gridy = 1; // Fila 1
        constraints.gridwidth = 1; // Ocupa una columna
        constraints.gridheight = 1; // Ocupa una fila
        constraints.weightx = 0; // No se estira en ancho
        constraints.weighty = 0; // No se estira en alto
        add(txtCantidad, constraints);
    }
}
