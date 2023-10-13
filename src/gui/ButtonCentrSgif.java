package gui;

import logik.*;

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
                        break;
                    case "Атбаш":
                        ShifrAtbash shifrAtbash= new ShifrAtbash();
                        MainPanel.deshifrovka.setText((shifrAtbash.deshifrator(MainPanel.shifrovka.getText())));
                        break;
                    case "Base64":
                        ShifrBase64 shifrBase64 = new ShifrBase64();
                        MainPanel.deshifrovka.setText((shifrBase64.deshifrator(MainPanel.shifrovka.getText())));
                        break;
                    case "Плейфера":
                        ShifrPleifera shifrPleifera = new ShifrPleifera(PanelKey.areaKeyPanel.getText());
                        MainPanel.deshifrovka.setText(shifrPleifera.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                    case "HEX":
                        ShifrHex shifrHex = new ShifrHex();
                        MainPanel.deshifrovka.setText(shifrHex.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                    case "BIN":
                        ShifrBin shifrBin = new ShifrBin();
                        MainPanel.deshifrovka.setText(shifrBin.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                    case "\\xxx (C string)":
                        ShifrCString shifrCString = new ShifrCString();
                        MainPanel.deshifrovka.setText(shifrCString.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                    case "ROT13":
                        ShifrRot13 shifrRot13 = new ShifrRot13();
                        MainPanel.deshifrovka.setText(shifrRot13.deshifrator(MainPanel.shifrovka.getText()));
                        break;
                }


            }
        });
    }
    public JButton getButtonCentrSgif(){
        return this;
    }
}
