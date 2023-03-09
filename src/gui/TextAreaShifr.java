package gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaShifr extends JTextArea {
    public TextAreaShifr(){
        setColumns(20);
        setLineWrap(true);
        setRows(5);
        setWrapStyleWord(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiersEx() > 0) {
                        transferFocusBackward();
                    } else {
                        transferFocus();
                    }
                    e.consume();
                }
            }
        });
    }
    public JTextArea getTextAreaDesh(){
        return this;
    }
}
