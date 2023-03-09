package gui;

import javax.swing.*;
import java.awt.*;

public class PanelShifr  extends JLabel{
    public PanelShifr(){
        super("Текст в зашифровоном виде ввести здесь "+ new String(Character.toChars(0x2193)));
        Font font = getFont();
        setFont( font.deriveFont( 16.f ) );
    }
    public void setLabel(String newName){
        super.setText(newName);
    }
    public JLabel getLabel(){
        return this;
    }
}
