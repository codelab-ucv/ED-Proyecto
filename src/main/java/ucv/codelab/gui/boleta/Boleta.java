package ucv.codelab.gui.boleta;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;

public class Boleta extends JFrame implements Utils {

    public JPanel panel = new JPanel(new GridBagLayout());

    public Boleta(HashSet<ProductSlot> listaCompras) {
        setSize(new Dimension(720, 500));

        // Crea la constante de GridBag
        GridBagConstraints topConstraints = new GridBagConstraints();

        // Configura el titulo
        JTextField titulo = Utils.configureText("Tienda Artel", H1, 200, 60);
        topConstraints.insets = new Insets(5, 5, 5, 5);
        topConstraints.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 0; // Fila 0
        topConstraints.gridwidth = 1; // Ocupa 1 columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        panel.add(titulo, topConstraints);

        add(panel);
    }
}
