package ucv.codelab.gui.panels;

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

    private final JTextField valorNombre;
    private final JTextField valorDni;

    public TopPanel() {
        // Configurar el panel superior
        setLayout(new GridBagLayout());
        setBackground(null);
        setPreferredSize(new Dimension(600, 120));

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

        // Configura la palabra Nombre Completo
        JTextField txtNombre = Utils.configureText("Nombre Completo:", H3, 120, 40);
        topConstraints.insets = new Insets(4, 15, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(txtNombre, topConstraints);

        // Configura el valor del nombre
        valorNombre = Utils.configureText("", H3, 200, 40);
        topConstraints.insets = new Insets(4, 5, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira en ancho
        topConstraints.gridx = 1; // Columna 1
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(valorNombre, topConstraints);

        // Configura la palabra DNI
        JTextField txtDni = Utils.configureText("DNI:", H3, 40, 40);
        topConstraints.insets = new Insets(4, 5, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 2; // Columna 2
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(txtDni, topConstraints);

        // Configura el valor del DNI
        valorDni = Utils.editableText("Ingrese el DNI", H3, 90, 40);
        topConstraints.insets = new Insets(4, 5, 5, 15);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 3; // Columna 3
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        add(valorDni, topConstraints);
    }

    public String getUserName() {
        return valorNombre.getText();
    }

    public String getDni() {
        return valorDni.getText();
    }

    public void setUserName(String userName) {
        valorNombre.setText(userName);
    }

    public void setDni(String dni) {
        valorDni.setText(dni);
    }
}
