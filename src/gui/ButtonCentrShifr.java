package gui;

import logik.ShifCezerya;
import logik.ShifrA1Z26;
import logik.ShifrVinigira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCentrShifr extends JButton {
    public ButtonCentrShifr(){
        super("Зашифровать");
        Font font = getFont();
        setFont( font.deriveFont( 16.f ) );
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shifr  = (String) SlectMenuItem.getSlectMenuItem().getSelectedItem();
                switch (shifr){
                    case "Шифр Виженера":
                        ShifrVinigira sv = new ShifrVinigira(PanelKey.areaKeyPanel.getText());
                        MainPanel.shifrovka.setText(sv.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "Шифр Цезаря":
                        int sdvig = Integer.parseInt(PanelKey.areaKeyPanel.getText());
                        ShifCezerya sc = new ShifCezerya(sdvig);
                        MainPanel.shifrovka.setText(sc.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "A1Z26":
                        ShifrA1Z26 sa = new ShifrA1Z26();
                        MainPanel.shifrovka.setText(sa.shifrator3(MainPanel.deshifrovka.getText()));
                }


            }
        });
    }
    public JButton getButtonCentrShifr(){
        return this;
    }

}
