package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpravkaMenuBar extends JMenu {
    public SpravkaMenuBar() {
        super("Справка");
        JMenuItem help = new JMenuItem("Помощь");
        JMenuItem program = new JMenuItem("О программе");
        add(help);
        add(program);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainPanel.mainPanel,
                        "<html><i>Описание принципа работы программы</i><br>" +
                                "Можно найти ","Помощь",JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }
}
