package ucv.codelab.gui.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ucv.codelab.cache.Product;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;
import ucv.codelab.gui.layouts.WrapLayout;

public class MiddlePanel extends JPanel implements Utils {

    private final JTextField cuadroBusqueda;

    private final JPanel listaProductos;

    public MiddlePanel() {
        // Configurar el panel central
        setLayout(new GridBagLayout());
        setBackground(null);

        // Crea la constante de GridBag
        GridBagConstraints centralConstraints = new GridBagConstraints();

        // Configura el cuadro de busqueda
        cuadroBusqueda = Utils.editableText("Ingrese el producto", H2, 700, 50);
        cuadroBusqueda.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                for (Component c : listaProductos.getComponents()) {
                    // Si continua con el texto default, deja todos visibles
                    if (cuadroBusqueda.getText().equals("Ingrese el producto")) {
                        c.setVisible(true);
                        continue;
                    }
                    // Caso contrario, aplica el filtro
                    c.setVisible(c.getName().toLowerCase().contains(cuadroBusqueda.getText().toLowerCase()));
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        centralConstraints.gridx = 0; // Columna 0
        centralConstraints.gridy = 0; // Fila 0
        centralConstraints.gridwidth = 1; // Ocupa una columna
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 1; // Se estira 100% en ancho
        centralConstraints.weighty = 0; // No se estira en alto
        add(cuadroBusqueda, centralConstraints);

        // Configura el panel de resultados
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(Color.BLACK));
        scrollPane.setPreferredSize(new Dimension(100, 100));
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.BOTH; // Se estira ambos lados
        centralConstraints.gridx = 0; // Columna 0
        centralConstraints.gridy = 1; // Fila 0
        centralConstraints.gridwidth = 1; // Ocupa una columna
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 1; // Se estira 100% en ancho
        centralConstraints.weighty = 1; // Se estira 100% en alto
        add(scrollPane, centralConstraints);

        // Modifica el desplazamiento del scroll
        scrollPane.getVerticalScrollBar().setUnitIncrement(70);

        // Añade el JPanel de los resultados
        listaProductos = new JPanel();
        listaProductos.setBackground(new Color(241, 228, 105));
        listaProductos.setLayout(new WrapLayout(WrapLayout.CENTER, 10, 10));

        scrollPane.setViewportView(listaProductos);
    }

    public String getSearchedProduct() {
        return cuadroBusqueda.getText();
    }

    public void setSearchedProduct(String userName) {
        cuadroBusqueda.setText(userName);
    }

    public void addProduct(Product product) {
        listaProductos.add(new ProductSlot(product));
    }

    public void cancelarBusqueda() {
        // Establece todos los componentes de la lista de productos como visibles
        for (Component c : listaProductos.getComponents()) {
            c.setVisible(true);
        }
    }
}
