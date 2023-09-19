package gui;

import logik.*;

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
                        break;
                    case "Атбаш":
                        ShifrAtbash shifrAtbash = new ShifrAtbash();
                        MainPanel.shifrovka.setText(shifrAtbash.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "Base64":
                        ShifrBase64 shifrBase64 = new ShifrBase64();
                        MainPanel.shifrovka.setText(shifrBase64.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "Плейфера":
                        ShifrPleifera shifrPleifera = new ShifrPleifera(PanelKey.areaKeyPanel.getText());
                        MainPanel.shifrovka.setText(shifrPleifera.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "HEX":
                        ShifrHex shifrHex = new ShifrHex();
                        MainPanel.shifrovka.setText(shifrHex.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                    case "BIN":
                        ShifrBin shifrBin = new ShifrBin();
                        MainPanel.shifrovka.setText(shifrBin.shifrator(MainPanel.deshifrovka.getText()));
                        break;
                }


            }
        });
    }
    public JButton getButtonCentrShifr(){
        return this;
    }

}
