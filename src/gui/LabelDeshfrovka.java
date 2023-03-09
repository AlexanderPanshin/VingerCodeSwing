package gui;

import javax.swing.*;
import java.awt.*;

public class LabelDeshfrovka extends JLabel {
    public LabelDeshfrovka(){
        super("Текст в обычном виде ввести здесь "+ new String(Character.toChars(0x2193)));
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
