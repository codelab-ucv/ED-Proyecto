package ucv.codelab.gui.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ucv.codelab.gui.Utils;

public class TopPanel extends JPanel implements Utils {

    public TopPanel() {
        // Configurar el panel superior
        setLayout(new GridBagLayout());
        setBackground(null);
        setPreferredSize(new Dimension(600, 80));

        // Crea la constante de GridBag
        GridBagConstraints topConstraints = new GridBagConstraints();

        // Configura el titulo
        JTextField titulo = Utils.configureText("Tienda Artel", H1, 200, 60);
        topConstraints.insets = new Insets(5, 5, 4, 5);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 0; // Fila 0
        topConstraints.gridwidth = 4; // Ocupa 4 columnas
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(titulo, topConstraints);

        // Configura la linea divisora
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setForeground(null);
        separador.setBackground(Color.BLACK);
        topConstraints.insets = new Insets(0, 5, 0, 5);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 1; // Fila 1
        topConstraints.gridwidth = 4; // Ocupa 4 columnas
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(separador, topConstraints);
    }
}
