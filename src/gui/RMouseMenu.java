package gui;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RMouseMenu extends JPopupMenu {
    public RMouseMenu(JTextArea ta) {
        super("Контекстное меню");
        JMenuItem jm = new JMenuItem(new DefaultEditorKit.CutAction());
        jm.setText("Вырезать");
        JMenuItem jm1 = new JMenuItem(new DefaultEditorKit.CopyAction());
        jm1.setText("Копировать");
        JMenuItem jm2 = new JMenuItem(new DefaultEditorKit.PasteAction());
        jm2.setText("Вставить");
        jm2.setEnabled(true);
        add(jm);
        add(jm1);
        add(jm2);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jm.setEnabled(ta.getSelectionStart() != ta.getSelectionEnd());
                jm1.setEnabled(ta.getSelectionStart() != ta.getSelectionEnd());
                jm2.setEnabled(Toolkit.getDefaultToolkit()
                        .getSystemClipboard().isDataFlavorAvailable(DataFlavor.stringFlavor));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //show(ta, ta.getMousePosition().y, ta.getMousePosition().y);
    }
}
