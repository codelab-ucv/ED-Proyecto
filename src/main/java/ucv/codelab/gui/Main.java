package ucv.codelab.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame {

    public JPanel panel = new JPanel(new GridBagLayout());
    private final Font h1 = new Font("Tahoma", Font.BOLD, 36);
    private final Font h2 = new Font("Tahoma", Font.PLAIN, 18);
    private final Font h3 = new Font("Tahoma", Font.PLAIN, 13);

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }

    public Main() {
        // Configurar el frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension size = new Dimension(1280, 720);
        setSize(size);
        setMinimumSize(size);

        // Configura el panel y layout
        panel.setBackground(Color.BLACK);
        add(panel);

        //Crea la constante de GridBag
        GridBagConstraints panelConstraints = new GridBagConstraints();

        // Configurar el panel superior
        JPanel topLayout = new JPanel(new GridBagLayout());
        topLayout.setBackground(Color.CYAN);
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
        centralLayout.setBackground(Color.YELLOW);
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
        bottomLayout.setBackground(Color.GREEN);
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

        // Muestra los tamañas  / solo pruebas
        showSize(panel);
        showSize(topLayout);
        showSize(centralLayout);
        showSize(bottomLayout);
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

    private void loadTopPanel(JPanel topPanel) {
        //Crea la constante de GridBag
        GridBagConstraints topConstraints = new GridBagConstraints();

        // Configura el titulo
        JTextField titulo = new JTextField("Sistema de ventas");
        titulo.setFont(h1);
        titulo.setBackground(Color.LIGHT_GRAY);
        titulo.setPreferredSize(new Dimension(200, 60));
        titulo.setEditable(false);
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
        JTextField txtNombre = new JTextField("Nombre Completo:");
        txtNombre.setFont(h3);
        txtNombre.setBackground(Color.LIGHT_GRAY);
        txtNombre.setPreferredSize(new Dimension(120, 40));
        txtNombre.setEditable(false);
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
        JTextField valorNombre = new JTextField("Madgen Adrian Del Castillo Choqque");
        valorNombre.setFont(h3);
        valorNombre.setBackground(Color.LIGHT_GRAY);
        valorNombre.setPreferredSize(new Dimension(200, 40));
        valorNombre.setEditable(false);
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
        JTextField txtDni = new JTextField("DNI:");
        txtDni.setFont(h3);
        txtDni.setBackground(Color.LIGHT_GRAY);
        txtDni.setPreferredSize(new Dimension(40, 40));
        txtDni.setEditable(false);
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
        JTextField valorDni = new JTextField("74779738");
        valorDni.setFont(h3);
        valorDni.setBackground(Color.LIGHT_GRAY);
        valorDni.setPreferredSize(new Dimension(70, 40));
        valorDni.setEditable(false);
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

        // Muestra los tamaños / Solo para desarrollo
        showSize(titulo);
        showSize(txtNombre);
        showSize(valorNombre);
        showSize(txtDni);
        showSize(valorDni);
    }

    private void loadCentralPanel(JPanel centralPanel) {
        //Crea la constante de GridBag
        GridBagConstraints centralConstraints = new GridBagConstraints();

        // Configura el cuadro de busqueda
        JTextField cuadroBusqueda = new JTextField("Ingrese el producto");
        cuadroBusqueda.setFont(h2);
        cuadroBusqueda.setPreferredSize(new Dimension(600, 50));
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
        JButton botonBusqueda = new JButton("Buscar");
        botonBusqueda.setFont(h2);
        botonBusqueda.setPreferredSize(new Dimension(100, 50));
        centralConstraints.insets = new Insets(5, 5, 5, 5);
        centralConstraints.anchor = GridBagConstraints.CENTER; // Alineado al centro
        centralConstraints.fill = GridBagConstraints.NONE; // El cuadrante no se estira
        centralConstraints.gridx = 1; // Columna 1
        centralConstraints.gridy = 0; // Fila 0
        centralConstraints.gridwidth = 1; // Ocupa una columna
        centralConstraints.gridheight = 1; // Ocupa una fila
        centralConstraints.weightx = 0; // No se estira en ancho
        centralConstraints.weighty = 0; // No se estira en alto
        centralPanel.add(botonBusqueda, centralConstraints);

        // Configura el panel de resultados
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.MAGENTA);
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
        
        // Muestra los tamaños / Solo para desarrollo
        showSize(cuadroBusqueda);
        showSize(botonBusqueda);
        showSize(scrollPane);
    }

    private void loadBottomPanel(JPanel bottomPanel) {
        //Crea la constante de GridBag
        GridBagConstraints bottomConstraints = new GridBagConstraints();

        // Configura el boton para cancelar
        JButton btnCancelar = new JButton("Cancelar Todo");
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
        JTextField txtPrecio = new JTextField("Precio: S/ ");
        txtPrecio.setFont(h2);
        txtPrecio.setPreferredSize(new Dimension(200, 50));
        txtPrecio.setHorizontalAlignment(JTextField.CENTER);
        txtPrecio.setEditable(false);
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

        // Configura el boton para cancelar
        JButton btnComprar = new JButton("Comprar");
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

        // Muestra los tamaños / Solo para desarrollo
        showSize(btnCancelar);
        showSize(btnComprar);
        showSize(txtPrecio);
    }
}
