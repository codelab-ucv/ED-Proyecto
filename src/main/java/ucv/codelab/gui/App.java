package ucv.codelab.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ucv.codelab.Conexion;
import ucv.codelab.cache.Product;
import ucv.codelab.gui.panels.BottomPanel;
import ucv.codelab.gui.panels.MiddlePanel;
import ucv.codelab.gui.panels.TopPanel;

public class App extends JFrame implements Utils {

    public JPanel panel = new JPanel(new GridBagLayout());

    public static final TopPanel topPanel = new TopPanel();
    public static final MiddlePanel middlePanel = new MiddlePanel();
    public static final BottomPanel bottomPanel = new BottomPanel();

    public static App panelPrincipal = new App();

    public static void main(String[] args) {
        panelPrincipal.setVisible(true);
    }

    public App() {
        // Configurar el frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Utils.DEFAULT_SIZE);
        setMinimumSize(Utils.DEFAULT_SIZE);
        setTitle("Sistema de Ventas de la tienda Artel");

        // Configura el panel y layout
        add(panel);
        panel.setBackground(Utils.BACKGROUND);

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
        panel.add(topPanel, panelConstraints);

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
        panel.add(middlePanel, panelConstraints);

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
        panel.add(bottomPanel, panelConstraints);

        Conexion.crearConexion();
    }

    public static void addProduct(Product product){
        middlePanel.addProduct(product);
    }
}
