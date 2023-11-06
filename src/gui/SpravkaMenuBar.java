package gui;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
                JLabel label = new JLabel();

                JEditorPane ep = new JEditorPane("text/html", "<html>Описание принципа работы программы\n" +
                        "                                Можно найти <a href=\\\"http://site.ru\\\">Помощь</a></html>");

                // handle link events
                ep.addHyperlinkListener(new HyperlinkListener()
                {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent e)
                    {
                        if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://github.com/AlexanderPanshin/VingerCodeSwing")); // roll your own link launcher or use Desktop if J6+
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (URISyntaxException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                });
                ep.setEditable(false);
                ep.setBackground(label.getBackground());

                // show
                JOptionPane.showMessageDialog(null, ep);
                /*JOptionPane.showMessageDialog(MainPanel.mainPanel,
                        "<html><i>Описание принципа работы программы</i><br>" +
                                "Можно найти <a href=\"http://site.ru\">указатель ссылки</a>","Помощь",JOptionPane.INFORMATION_MESSAGE);*/

            }
        });
    }
}
