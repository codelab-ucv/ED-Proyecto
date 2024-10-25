package ucv.codelab.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Main extends JFrame {

    // Relacion de 2/7/1
    public JPanel layout1 = createPanel(), layout2 = createPanel(), layout3 = createPanel();

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }

    public Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tamaño mínimo de 720p
        Dimension size = new Dimension(1280, 720);
        setSize(size);
        setMinimumSize(size);

        // Layout personalizable
        setLayout(new GridBagLayout());

        GridBagConstraints panelConstraints = new GridBagConstraints();

        // Constantes generales
        panelConstraints.insets = new Insets(5, 5, 5, 5); // Todos los componentes tienen 5 pixeles de borde
        panelConstraints.anchor = GridBagConstraints.CENTER; // Coloca el componente al centro
        panelConstraints.fill = GridBagConstraints.BOTH; // Rellena el componente tanto izquierda como derecha
        panelConstraints.gridx = 0; // Todos los paneles estan en la primera columna.
        panelConstraints.gridwidth = 1; // Todos los paneles tienen igual espacio, solo cambia cuanto se estiran.
        panelConstraints.gridheight = 1; // Todos los paneles tienen igual espacio, solo cambia el cuanto se estiran.
        panelConstraints.weightx = 1; // Todos estiran por igual el ancho

        // Panel superior
        panelConstraints.gridy = 0; // El panel está en la fila cero
        panelConstraints.weighty = 110; // Estirar la altura según los datos del boceto.
        add(layout1, panelConstraints);
        showSize(layout1);
        showSize(layout2);
        showSize(layout3);
        loadTopPanel(layout1);

        // Panel central
        panelConstraints.gridy = 1; // El panel está en la fila uno
        panelConstraints.weighty = 490; // Estirar la altura según los datos del boceto.
        add(layout2, panelConstraints);

        // Panel inferior
        panelConstraints.gridy = 2; // El panel está en la fila dos
        panelConstraints.weighty = 50; // Estirar la altura según los datos del boceto.
        add(layout3, panelConstraints);
    }

    private void showSize(Component c) {
        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(c.getSize());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    // weightx y weighty son para la relación de aspecto
    private void loadTopPanel(JPanel topPanel) {
        topPanel.setLayout(new GridBagLayout());

        JLabel titulo = new JLabel("Sistema de ventas");
        JLabel nombre = new JLabel("Nombre Completo:");
        JLabel dni = new JLabel("DNI:");
        JTextField nombreCliente = new JTextField();
        JTextField dniCliente = new JTextField();

        GridBagConstraints topConstraints = new GridBagConstraints();

        // Constantes generales
        topConstraints.insets = new Insets(5, 5, 5, 5); // Todos los componentes tienen 5 pixeles de borde     
        topConstraints.anchor = GridBagConstraints.CENTER; // Coloca el componente al centro
        topConstraints.fill = GridBagConstraints.BOTH; // Rellena el componente tanto izquierda como derecha
        topConstraints.gridheight = 1; // Todos tienen igual de alto

        // Titulo
        topConstraints.gridx = 0; // Empieza en la primera columna
        topConstraints.gridy = 0; // Empieza en la primera fila
        topConstraints.gridwidth = 4; // El titulo tiene 4 espacios de ancho
        topConstraints.weightx = 1244; // El ancho del componente (en el boceto)
        topConstraints.weighty = 50; // El alto del componente (en el boceto)
        topPanel.add(titulo, topConstraints);
        showSize(titulo);

        // Datos de la segunda fila
        topConstraints.gridy = 1; // Cambia a la segunda fila
        topConstraints.gridwidth = 1; // Todos tienen un componente de ancho
        topConstraints.weighty = 40; // El alto de los componentes (en el boceto)

        // Texto cliente
        topConstraints.gridx = 0; // Empieza en la primera columna
        topConstraints.weightx = 120; // Estira el ancho segun el boceto
        topPanel.add(nombre, topConstraints);
        showSize(nombre);

        // Nombre cliente
        topConstraints.gridx = 1; // Empieza en la segunda columna
        topConstraints.weightx = 992; // Estira el ancho segun el boceto
        topPanel.add(nombreCliente, topConstraints);
        showSize(nombreCliente);

        // Texto DNI
        topConstraints.gridx = 2; // Empieza en la quinta columna
        topConstraints.weightx = 40; // Estira el ancho segun el boceto
        topPanel.add(dni, topConstraints);
        showSize(dni);

        // DNI cliente
        topConstraints.gridx = 3; // Empieza en la quinta columna
        topConstraints.weightx = 60; // Estira el ancho segun el boceto
        topPanel.add(dniCliente, topConstraints);
        showSize(dniCliente);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK));
        //panel.setLayout(new GridBagLayout());
        return panel;
    }
}
