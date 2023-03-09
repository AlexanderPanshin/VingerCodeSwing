package gui;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextAreaDeshifrovka extends JTextArea {
    public TextAreaDeshifrovka(){
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
