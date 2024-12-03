package ucv.codelab;

import javax.swing.JOptionPane;

import ucv.codelab.gui.interfaz.Menu;

public class Main {
    
    public static Menu panelPrincipal = new Menu();

    public static void main(String[] args) {
        if (!Conexion.crearConexion()) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        panelPrincipal.setVisible(true);
    }
}
