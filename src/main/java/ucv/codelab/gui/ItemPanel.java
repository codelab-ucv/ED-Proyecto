package ucv.codelab.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ucv.codelab.cache.Product;

public class ItemPanel extends JPanel {

    /**
     * Objeto del producto usado en el panel
     */
    private final Product product;
    /**
     * Cuadro de texto para la cantidad de productos
     */
    private final JTextField txtCantidad;
    /**
     * Tamaño que ocupa la imagen y su precio
     */
    private static final int IMAGE_SIDE = 198;

    /**
     * Crea un nuevo cuadro con los datos e imagen del item, así como un cuadrante
     * para modificar la cantidad
     * 
     * @param product Producto a mostrar en el recuadro
     */
    public ItemPanel(Product product) {
        // Inicia los datos del producto
        this.product = product;

        // Da el borde y tamaño a cada panel
        setBorder(new LineBorder(Color.BLACK));
        setPreferredSize(new Dimension(220, 268));

        // Crea la constante de GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Configura el texto del precio
        JLabel imagen = new JLabel("Precio unitario: S/ " + product.PRICE);
        imagen.setHorizontalTextPosition(JLabel.CENTER);
        imagen.setVerticalTextPosition(JLabel.TOP);
        // Configura la imagen
        imagen.setIcon(resizeImage(product.IMAGE_PATH));
        imagen.setHorizontalAlignment(JLabel.CENTER);
        imagen.setVerticalAlignment(JLabel.TOP);
        // Configura el recuadro
        imagen.setBorder(new LineBorder(Color.BLACK));
        imagen.setPreferredSize(new Dimension(IMAGE_SIDE, IMAGE_SIDE));
        // Configura la posición del componente
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
        JTextField nombre = Utils.configureText(product.NAME, Utils.H3, 160, 38);
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

        // Configura el cuadro de texto
        txtCantidad = Utils.editableText("0", Utils.H3, 28, 38);
        txtCantidad.setHorizontalAlignment(JTextField.CENTER);
        txtCantidad.addFocusListener(new FocusListener() {
            private String initialValue;

            @Override
            public void focusGained(FocusEvent e) {
                initialValue = txtCantidad.getText();
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Si se intenta ingresar mas stock del que hay realmente
                    if (Integer.parseInt(txtCantidad.getText()) > product.getStock()) {
                        // Establece la compra en lo máximo posible
                        txtCantidad.setText(product.getStock() + "");
                    }
                } catch (NumberFormatException exception) {
                    // Si se ingresa un valor invalido establece en el valor anterior
                    txtCantidad.setText(initialValue);
                }

                updatePrice();
            }
        });

        constraints.insets = new Insets(0, 0, 10, 10);
        constraints.anchor = GridBagConstraints.SOUTHEAST; // Alineado abajo a la derecha
        constraints.fill = GridBagConstraints.NONE; // No se estira el componente
        constraints.gridx = 1; // Columna 1
        constraints.gridy = 1; // Fila 1
        constraints.gridwidth = 1; // Ocupa una columna
        constraints.gridheight = 1; // Ocupa una fila
        constraints.weightx = 0; // No se estira en ancho
        constraints.weighty = 0; // No se estira en alto
        add(txtCantidad, constraints);
    }

    // Permite cambiar el tamaño a la imagen
    /**
     * Cambia el tamaño original de la imagen por uno soportado, restando los
     * márgenes usados por el texto del precio
     * 
     * @param path Ubicación de la imagen a usar
     * @return Devuelve la imagen con el tamaño ya establecido
     */
    private static ImageIcon resizeImage(String path) {
        Image img = new ImageIcon(path).getImage();
        int margen = 25;
        ImageIcon imgIcon = new ImageIcon(
                img.getScaledInstance(IMAGE_SIDE - margen, IMAGE_SIDE - margen, Image.SCALE_SMOOTH));
        return imgIcon;
    }

    /**
     * Llama a Main para actualizar el recuadro del precio final
     */
    private void updatePrice() {
        App.panelPrincipal.updateFinalPrice(this);
    }

    /**
     * Obtiene el precio total de la compra
     * 
     * @return Devuelve la cantidad seleccionada * precio unitario
     */
    public float getTotalPrice() {
        return Integer.parseInt(txtCantidad.getText()) * product.PRICE;
    }

}
