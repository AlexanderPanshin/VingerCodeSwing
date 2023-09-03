package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelKey extends JPanel {
    static int iter = 0;
    static JLabel labelKeyPanel;
    static JTextArea areaKeyPanel;

    static JComboBox<String> comboBox;

    static JScrollPane sc;
    private static JPanel panelKey;

    private PanelKey(){
        setLayout(new FlowLayout());
        labelKeyPanel = new JLabel("Введите ключевое слово -> ");

        Font font1 = labelKeyPanel.getFont();
        labelKeyPanel.setFont( font1.deriveFont( 16.f ) );
        add(labelKeyPanel);
        areaKeyPanel = new JTextArea("Введите ключ ",3,20);
        areaKeyPanel.getAccessibleContext().setAccessibleDescription("Здесь введите ключ шифровкию. Может быть любая фраза.");
        areaKeyPanel.setBackground(Color.orange);
        areaKeyPanel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(iter<1) {
                    areaKeyPanel.setText("");
                    iter++;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        areaKeyPanel.setLineWrap(true);
        areaKeyPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiersEx() > 0) {
                        areaKeyPanel.transferFocusBackward();
                    } else {
                        areaKeyPanel.transferFocus();
                    }
                    e.consume();
                }
            }
        });
        Font font = areaKeyPanel.getFont();
        areaKeyPanel.setFont( font.deriveFont( 16.f ) );
        add(new JScrollPane(areaKeyPanel));

    }
    public static JPanel getKeyPanel(){
        if (panelKey == null){
            panelKey = new PanelKey();
        }
        return  panelKey;
    }
    public static void addEnRu(){
        String [] mass = {"Ru","En"};
        comboBox = new JComboBox<>(mass);
        panelKey.add(comboBox);
        panelKey.validate();
    }
    public static void  removeEnRu(){
        if(comboBox!=null) {
            panelKey.remove(comboBox);
            panelKey.validate();
            panelKey.repaint();
        }
    }

    public static JComboBox<String> getComboBox() {
        return comboBox;
    }
}
