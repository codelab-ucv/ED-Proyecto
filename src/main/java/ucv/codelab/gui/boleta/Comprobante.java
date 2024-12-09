package ucv.codelab.gui.boleta;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ucv.codelab.gui.Utils;

public class Comprobante extends JPanel implements Utils {

    private final JTextField numeroBoleta;

    public Comprobante() {
        setBorder(new LineBorder(Color.BLACK));
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 0, 0, 0); // Todos estan pegados
        constraints.anchor = GridBagConstraints.CENTER; // Todos estan alineados al centro
        constraints.fill = GridBagConstraints.BOTH; // Todos se estiran por igual
        constraints.gridx = 0; // Todos estan en la única columna 0
        constraints.gridwidth = 1; // Todos ocupan una columna
        constraints.gridheight = 1; // Todos ocupan una fila
        constraints.weightx = 1; // Se estira 100% en ancho
        constraints.weighty = 1; // Se estira 100% en alto

        JTextField texto1 = Utils.configureText("BOLETA DE VENTA", H2, 200, 20);
        texto1.setBackground(BOTON);
        texto1.setHorizontalAlignment(JTextField.CENTER);
        constraints.gridy = 0; // Fila 0
        add(texto1, constraints);

        JTextField texto2 = Utils.configureText("ELECTRONICA", H2, 200, 20);
        texto2.setBackground(BOTON);
        texto2.setHorizontalAlignment(JTextField.CENTER);
        constraints.gridy = 1; // Fila 1
        add(texto2, constraints);

        JTextField ruc = Utils.configureText("RUC: 20745506568", H2, 200, 20);
        ruc.setHorizontalAlignment(JTextField.CENTER);
        constraints.gridy = 2; // Fila 2
        add(ruc, constraints);

        // TODO cambiar automaticamente este valor
        numeroBoleta = Utils.configureText("######", H2, 200, 20);
        numeroBoleta.setHorizontalAlignment(JTextField.CENTER);
        constraints.gridy = 3; // Fila 3
        add(numeroBoleta, constraints);
    }
}
