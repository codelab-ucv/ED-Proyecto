package ucv.codelab.gui.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import ucv.codelab.cache.Product;
import ucv.codelab.gui.Utils;

public class Menu extends JPanel implements Utils {

    public static final TopPanel topPanel = new TopPanel();
    public static final MiddlePanel middlePanel = new MiddlePanel();
    public static final BottomPanel bottomPanel = new BottomPanel();

    public static Menu panelPrincipal = new Menu();

    public Menu() {
        // Configura el fondo y el layout
        setLayout(new GridBagLayout());
        setBackground(Utils.BACKGROUND);

        // Crea la constante de GridBag
        GridBagConstraints panelConstraints = new GridBagConstraints();

        // Configurar el panel superior
        panelConstraints.insets = new Insets(5, 5, 0, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 0; // Fila 0
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 0; // No se estira en alto
        add(topPanel, panelConstraints);

        // Configurar el panel central
        panelConstraints.insets = new Insets(5, 5, 5, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.BOTH; // Se estira ambos lados
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 1; // Fila 2
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 1; // Se estira 100% en alto
        add(middlePanel, panelConstraints);

        // Configurar el panel inferior
        panelConstraints.insets = new Insets(0, 5, 5, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 2; // Fila 2
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 0; // No se estira en alto
        add(bottomPanel, panelConstraints);
    }

    public static void addProduct(Product product) {
        middlePanel.addProduct(product);
    }
}
