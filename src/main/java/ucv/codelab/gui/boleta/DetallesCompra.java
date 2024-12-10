package ucv.codelab.gui.boleta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ucv.codelab.cache.Client;
import ucv.codelab.gui.Utils;
import ucv.codelab.gui.components.ProductSlot;

public class DetallesCompra extends JPanel implements Utils {

    private final JScrollPane scrollPane = new JScrollPane();

    private String[][] data;
    private final String[] columnNames = {"Codigo", "Producto", "Cantidad", "Valor Unitario", "Importe de Venta"};
    private final JTable table = new JTable();
    private final DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

    public DetallesCompra(Client client, HashSet<ProductSlot> listaCompras) {
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JTextField cliente = Utils.configureText("Cliente: " + client.NAME, H2, 200, 20);
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        add(cliente, constraints);

        JTextField dni = Utils.configureText("DNI: " + client.DNI, H2, 200, 20);
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.NORTHEAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        add(dni, constraints);

        // Configura la cabecera
        table.getTableHeader().setFont(Utils.H3);
        table.getTableHeader().setBackground(Color.WHITE);
        table.setEnabled(false);
        table.setModel(tableModel);

        // Configura las columnas
        configurarColumnas(0, 60);
        configurarColumnas(1, 630);
        configurarColumnas(2, 60);
        configurarColumnas(3, 80);
        configurarColumnas(4, 120);

        scrollPane.setPreferredSize(new Dimension(200, 80));
        scrollPane.setViewportView(table);
        constraints.insets = new Insets(10, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        add(scrollPane, constraints);

        for (ProductSlot ps : listaCompras) {
            tableModel.addRow(new Object[] {ps.getProduct().ID, ps.getProduct().NAME, ps.getQuantity(), ps.getProduct().PRICE, ps.getTotalPrice()});
        }
    }

    private void configurarColumnas(int columna, int ancho) {
        TableColumn column = table.getColumnModel().getColumn(columna);
        column.setResizable(false);
        column.setPreferredWidth(ancho);

        // Establece el formato de las celdas
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(0);
        defaultTableCellRenderer.setFont(Utils.H2);
        defaultTableCellRenderer.setBackground(Color.WHITE);
        column.setCellRenderer(defaultTableCellRenderer);
    }
}
