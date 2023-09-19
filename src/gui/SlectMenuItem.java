package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SlectMenuItem extends JComboBox<String> {
    ArrayList<Character> massNum =  new ArrayList<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
    private int iterSelect = 0;
    private static JComboBox<String> selectMenu;
    private MainPanel mp;
    public SlectMenuItem(MainPanel mp){
        super();
        this.mp = mp;
        selectMenu = this;
        String[] items = {
                "Шифр Виженера",
                "Шифр Цезаря",
                "A1Z26",
                "Атбаш",
                "Base64",
                "Плейфера",
                "HEX",
                "BIN"
        };
        Font font = getFont();
        setFont( font.deriveFont( 16.f ) );
        Arrays.stream(items).toList().forEach(super::addItem);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> box = (JComboBox<String>) e.getSource();
                String selcted = (String) box.getSelectedItem();

                if (selcted.equals(items[0])){
                    PanelKey.labelKeyPanel.setText("Введите ключевое слово -> ");
                    PanelKey.areaKeyPanel.setText("Введите ключ");
                    PanelKey.areaKeyPanel.getAccessibleContext().setAccessibleDescription("Здесь введите ключ шифровкию. Может быть любая фраза.");
                    PanelKey.areaKeyPanel.setEnabled(true);
                    PanelKey.iter = 0;
                    PanelKey.removeEnRu();
                    iterSelect = 0;
                }
                if (selcted.equals(items[1])){
                    PanelKey.labelKeyPanel.setText("Введите число смещения до 33 -> ");
                    PanelKey.areaKeyPanel.setText("Введите число");
                    PanelKey.areaKeyPanel.getAccessibleContext().setAccessibleDescription("Здесь введите число сдвига. Только число до 33");
                    PanelKey.areaKeyPanel.setEnabled(true);
                    PanelKey.iter = 0;
                    PanelKey.removeEnRu();
                    iterSelect = 0;
                }
                if (selcted.equals(items[3])||selcted.equals(items[2])||selcted.equals(items[4])||selcted.equals(items[6])||selcted.equals(items[7])){
                    PanelKey.labelKeyPanel.setText("Ничего писать не надо -> ");
                    PanelKey.areaKeyPanel.setEnabled(false);
                    PanelKey.iter = 0;
                    PanelKey.removeEnRu();
                    iterSelect = 0;
                }
                if (selcted.equals(items[5])){
                    PanelKey.labelKeyPanel.setText("Введите ключевое слово -> ");
                    PanelKey.areaKeyPanel.setText("Введите ключ");
                    PanelKey.areaKeyPanel.getAccessibleContext().setAccessibleDescription("Здесь введите ключ шифровкию. Может быть любая фраза.");
                    PanelKey.areaKeyPanel.setEnabled(true);
                    if(iterSelect<1){
                        PanelKey.addEnRu();
                        iterSelect++;
                    }
                    PanelKey.iter = 0;
                }
            }
        });
    }
    public static JComboBox<String> getSlectMenuItem(){
        return selectMenu;
    }

}
