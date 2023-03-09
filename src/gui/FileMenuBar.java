package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenuBar extends JMenu {
    public FileMenuBar() {
        super("Файл");
        JMenu open = new JMenu("Открыть");
        JMenuItem zasifr = new JMenuItem("Зашифрованный");
        JMenuItem plain = new JMenuItem("Обычный");
        open.add(zasifr);
        open.add(plain);

        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(open);
        add(save);
        add(exit);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new SaveFileChooser();

            }
        });
        zasifr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser rc = new ReadFileChooser(1);
            }
        });
        plain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser rc = new ReadFileChooser(2);
            }
        });
    }
}
