package gui;

import logik.ShifCezerya;
import logik.ShifrA1Z26;
import logik.ShifrVinigira;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCentrSgif extends JButton {
    public ButtonCentrSgif(){
        super("Расшифровать");
        Font font = getFont();
        setFont( font.deriveFont( 16.f ) );
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shifr = (String) SlectMenuItem.getSlectMenuItem().getSelectedItem();
                switch (shifr){
                    case "Шифр Виженера":
                        ShifrVinigira sv = new ShifrVinigira(PanelKey.areaKeyPanel.getText());
                        MainPanel.deshifrovka.setText(sv.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                    case "Шифр Цезаря":
                        int sdvig = Integer.parseInt(PanelKey.areaKeyPanel.getText());
                        ShifCezerya sc = new ShifCezerya(sdvig);
                        MainPanel.deshifrovka.setText((sc.deshifrator(MainPanel.shifrovka.getText())));
                        break;
                    case "A1Z26":
                        ShifrA1Z26 sa = new ShifrA1Z26();
                        MainPanel.deshifrovka.setText((sa.deshifrator3(MainPanel.shifrovka.getText())));
                }


            }
        });
    }
    public JButton getButtonCentrSgif(){
        return this;
    }
}
