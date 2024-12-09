package ucv.codelab.gui.boleta;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JTextField;

import ucv.codelab.cache.Order;
import ucv.codelab.gui.Utils;

public class Datos extends JPanel implements Utils {

    private final JTextField fecha;

    public Datos(Order order) {
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

        JTextField nombreTienda = Utils.configureText("Tienda Artel", H2, 200, 20);
        constraints.gridy = 0; // Fila 0
        add(nombreTienda, constraints);

        JTextField direccion = Utils.configureText("Av Alfredo Mendiola 6232", H2, 200, 20);
        constraints.gridy = 1; // Fila 1
        add(direccion, constraints);

        JTextField distrito = Utils.configureText("Los Olivos - Lima - Lima", H2, 200, 20);
        constraints.gridy = 2; // Fila 2
        add(distrito, constraints);
        
        String pattern = "dd/MM/yy hh:mm aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(order.getDate());

        fecha = Utils.configureText(date, H2, 200, 20);
        constraints.gridy = 3; // Fila 3
        add(fecha, constraints);
    }
}
