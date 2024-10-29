package ucv.codelab.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class App extends JFrame {

    public JPanel panel = new JPanel(new GridBagLayout());

    private final Font h1 = new Font("Tahoma", Font.BOLD, 36);
    private final Font h2 = new Font("Tahoma", Font.PLAIN, 18);
    private final Font h3 = new Font("Tahoma", Font.PLAIN, 13);

    private JTextField valorNombre;
    private JTextField valorDni;
    private JTextField cuadroBusqueda;
    private JTextField txtPrecio;

    private JButton btnBuscar;
    private JButton btnCancelar;
    private JButton btnComprar;

    private JPanel listaProductos;

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }

    public App() {
        // Configurar el frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension size = new Dimension(1280, 720);
        setSize(size);
        setMinimumSize(size);
        setTitle("Sistema de Ventas de la tienda Artel");

        // Configura el panel y layout
        add(panel);
        panel.setBackground(new Color(241, 228, 105));

        //Crea la constante de GridBag
        GridBagConstraints panelConstraints = new GridBagConstraints();

        // Configurar el panel superior
        JPanel topLayout = new JPanel(new GridBagLayout());
        topLayout.setBackground(null);
        topLayout.setPreferredSize(new Dimension(600, 120));
        panelConstraints.insets = new Insets(5, 5, 0, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 0; // Fila 0
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 0; // No se estira en alto
        panel.add(topLayout, panelConstraints);
        loadTopPanel(topLayout);

        // Configurar el panel central
        JPanel centralLayout = new JPanel(new GridBagLayout());
        centralLayout.setBackground(null);
        panelConstraints.insets = new Insets(5, 5, 5, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.BOTH; // Se estira ambos lados
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 1; // Fila 2
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 1; // Se estira 100% en alto  
        panel.add(centralLayout, panelConstraints);
        loadCentralPanel(centralLayout);

        // Configurar el panel inferior
        JPanel bottomLayout = new JPanel(new GridBagLayout());
        bottomLayout.setBackground(null);
        bottomLayout.setPreferredSize(new Dimension(600, 60));
        panelConstraints.insets = new Insets(0, 5, 5, 5);
        panelConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        panelConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        panelConstraints.gridx = 0; // Columna 0
        panelConstraints.gridy = 2; // Fila 2
        panelConstraints.gridwidth = 1; // Ocupa una columna
        panelConstraints.gridheight = 1; // Ocupa una fila
        panelConstraints.weightx = 1; // Se estira 100% en ancho
        panelConstraints.weighty = 0; // No se estira en alto   
        panel.add(bottomLayout, panelConstraints);
        loadBottomPanel(bottomLayout);

        valorDni.requestFocus();
    }

    private void loadTopPanel(JPanel topPanel) {
        //Crea la constante de GridBag
        GridBagConstraints topConstraints = new GridBagConstraints();

        // Configura el titulo
        JTextField titulo = configureText("Tienda Artel", h1, 200, 60);
        topConstraints.insets = new Insets(5, 5, 4, 5);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 0; // Fila 0
        topConstraints.gridwidth = 4; // Ocupa 4 columnas
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        topPanel.add(titulo, topConstraints);

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
        topPanel.add(separador, topConstraints);

        // Configura la palabra Nombre Completo
        JTextField txtNombre = configureText("Nombre Completo:", h3, 120, 40);
        topConstraints.insets = new Insets(4, 15, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 0; // Columna 0
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        topPanel.add(txtNombre, topConstraints);

        // Configura el valor del nombre
        valorNombre = configureText("", h3, 200, 40);
        topConstraints.insets = new Insets(4, 5, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira en ancho
        topConstraints.gridx = 1; // Columna 1
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 1; // Se estira 100% en ancho
        topConstraints.weighty = 0; // No se estira en alto
        topPanel.add(valorNombre, topConstraints);

        // Configura la palabra DNI
        JTextField txtDni = configureText("DNI:", h3, 40, 40);
        topConstraints.insets = new Insets(4, 5, 5, 0);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 2; // Columna 2
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        topPanel.add(txtDni, topConstraints);

        // Configura el valor del DNI
        valorDni = editableText("Ingrese el DNI", h3, 90, 40);
        topConstraints.insets = new Insets(4, 5, 5, 15);
        topConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        topConstraints.fill = GridBagConstraints.NONE; // No se estira
        topConstraints.gridx = 3; // Columna 3
        topConstraints.gridy = 2; // Fila 2
        topConstraints.gridwidth = 1; // Ocupa una columna
        topConstraints.gridheight = 1; // Ocupa una fila
        topConstraints.weightx = 0; // No se estira en ancho
        topConstraints.weighty = 0; // No se estira en alto
        topPanel.add(valorDni, topConstraints);
    }

    private void loadCentralPanel(JPanel centralPanel) {
        //Crea la constante de GridBag
        GridBagConstraints centralConstraints = new GridBagConstraints();

        // Configura el cuadro de busqueda
        cuadroBusqueda = editableText("Ingrese el producto", h2, 600, 50);
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.HORIZONTAL; // Se estira solo horizontal
        centralConstraints.gridx = 0; // Columna 0
        centralConstraints.gridy = 0; // Fila 0
        centralConstraints.gridwidth = 1; // Ocupa una columna
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 1; // Se estira 100% en ancho
        centralConstraints.weighty = 0; // No se estira en alto
        centralPanel.add(cuadroBusqueda, centralConstraints);

        // Configura el boton para buscar
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(168, 252, 97));
        btnBuscar.setFont(h2);
        btnBuscar.setPreferredSize(new Dimension(100, 50));
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.NONE; // El cuadrante no se estira
        centralConstraints.gridx = 1; // Columna 1
        centralConstraints.gridy = 0; // Fila 0
        centralConstraints.gridwidth = 1; // Ocupa una columna
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 0; // No se estira en ancho
        centralConstraints.weighty = 0; // No se estira en alto
        centralPanel.add(btnBuscar, centralConstraints);

        // Configura el panel de resultados
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(Color.BLACK));
        System.out.println(scrollPane);
        scrollPane.setPreferredSize(new Dimension(100, 100));
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.BOTH; // Se estira ambos lados
        centralConstraints.gridx = 0; // Columna 0
        centralConstraints.gridy = 1; // Fila 0
        centralConstraints.gridwidth = 2; // Ocupa dos columnas
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 1; // Se estira 100% en ancho
        centralConstraints.weighty = 1; // Se estira 100% en alto
        centralPanel.add(scrollPane, centralConstraints);

        // Añade el JPanel de los resultados
        listaProductos = new JPanel();
        listaProductos.setBackground(new Color(241, 228, 105));

        scrollPane.setViewportView(listaProductos);
    }

    private void loadBottomPanel(JPanel bottomPanel) {
        //Crea la constante de GridBag
        GridBagConstraints bottomConstraints = new GridBagConstraints();

        // Configura el boton para cancelar
        btnCancelar = new JButton("Cancelar Todo");
        btnCancelar.setBackground(new Color(168, 252, 97));
        btnCancelar.setFont(h2);
        btnCancelar.setPreferredSize(new Dimension(200, 50));
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.WEST; // Alineado a la izquierda
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 0; // Columna 0
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        bottomPanel.add(btnCancelar, bottomConstraints);

        // Configura el texto del precio
        txtPrecio = configureText("Precio: S/ 0.00", h2, 200, 50);
        txtPrecio.setHorizontalAlignment(JTextField.CENTER);
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 1; // Columna 1
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        bottomPanel.add(txtPrecio, bottomConstraints);

        // Configura el boton para comprar
        btnComprar = new JButton("Comprar");
        btnComprar.setBackground(new Color(168, 252, 97));
        btnComprar.setFont(h2);
        btnComprar.setPreferredSize(new Dimension(200, 50));
        bottomConstraints.insets = new Insets(5, 20, 5, 20);
        bottomConstraints.anchor = GridBagConstraints.EAST; // Alineado a la derecha
        bottomConstraints.fill = GridBagConstraints.NONE; // No se estira el componente
        bottomConstraints.gridx = 2; // Columna 2
        bottomConstraints.gridy = 0; // Fila 0
        bottomConstraints.gridwidth = 1; // Ocupa una columna
        bottomConstraints.gridheight = 1; // Ocupa una fila
        bottomConstraints.weightx = 1; // Estira solo la cuadrícula
        bottomConstraints.weighty = 0; // No se estira en alto
        bottomPanel.add(btnComprar, bottomConstraints);
    }

    private JTextField configureText(String txt, Font letra, int w, int h) {
        JTextField textField = new JTextField(txt);
        textField.setFont(letra);
        textField.setBorder(null);
        textField.setBackground(null);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(w, h));
        return textField;
    }

    private JTextField editableText(String txt, Font letra, int w, int h) {
        JTextField textField = new JTextField(txt);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(txt)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText(txt);
                }
            }
        });
        textField.setFont(letra);
        textField.setBorder(new LineBorder(Color.BLACK));
        textField.setBackground(Color.WHITE);
        textField.setPreferredSize(new Dimension(w, h));
        return textField;
    }
}
