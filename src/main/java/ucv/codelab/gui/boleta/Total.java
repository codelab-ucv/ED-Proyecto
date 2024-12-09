package ucv.codelab.gui.boleta;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ucv.codelab.cache.Order;
import ucv.codelab.gui.Utils;

public class Total extends JPanel implements Utils {

    private final JTable jTable = new JTable();
    private final DefaultTableModel tableModel = new DefaultTableModel(0, 2);

    public Total(Order order) {
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        float subTotal = 0.82f * order.getTotal();
        float igv = order.getTotal() - subTotal;

        tableModel.addRow(new Object[]{"Sub total:", subTotal});
        tableModel.addRow(new Object[]{"IGV (18%):", igv});
        tableModel.addRow(new Object[]{"Total:", order.getTotal()});
        jTable.setModel(tableModel);

        configurarColumnas(0, 100);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1; // Permite que el espacio del componente ocupe todo el panel y se ubique a la derecha
        constraints.weighty = 0;
        add(jTable, constraints);
    }

    private void configurarColumnas(int columna, int ancho) {
        TableColumn column = jTable.getColumnModel().getColumn(columna);
        column.setResizable(false);
        column.setPreferredWidth(ancho);

        // Establece el formato de las celdas
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        defaultTableCellRenderer.setFont(Utils.H2);
        defaultTableCellRenderer.setBackground(new Color(125, 214, 223));
        column.setCellRenderer(defaultTableCellRenderer);
    }
}
