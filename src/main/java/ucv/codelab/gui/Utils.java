package ucv.codelab.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public interface Utils {

    public static final Font H1 = new Font("Tahoma", Font.BOLD, 36);
    public static final Font H2 = new Font("Tahoma", Font.PLAIN, 18);
    public static final Font H3 = new Font("Tahoma", Font.PLAIN, 13);

    public static final Color BACKGROUND = new Color(241, 228, 105);
    public static final Color BOTON = new Color(168, 252, 97);
    public static final Dimension DEFAULT_SIZE = new Dimension(1280, 720);
    
    public static JTextField configureText(String txt, Font letra, int w, int h) {
        JTextField textField = new JTextField(txt);
        textField.setFont(letra);
        textField.setBorder(null);
        textField.setBackground(null);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(w, h));
        return textField;
    }

    public static JTextField editableText(String txt, Font letra, int w, int h) {
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
