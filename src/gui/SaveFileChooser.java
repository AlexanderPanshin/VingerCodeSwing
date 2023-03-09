package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class SaveFileChooser extends JFileChooser {

    public SaveFileChooser() {
        File file;
        setDialogTitle("Сохранения файла");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text", "txt");
        setFileFilter(filter);
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = showSaveDialog(MainPanel.mainPanel);
        if(result == 0){
            if(!getSelectedFile().getAbsolutePath().contains(".txt")){
                file = new File(getSelectedFile().getAbsolutePath()+".txt");
            }else {
                file = new File(getSelectedFile().getAbsolutePath());
            }
            StringBuffer bf  = new StringBuffer();
            bf.append("Обычный текст :");
            bf.append(System.lineSeparator());
            bf.append(MainPanel.deshifrovka.getText());
            bf.append(System.lineSeparator());
            bf.append("Ключ :");
            bf.append(System.lineSeparator());
            bf.append(PanelKey.areaKeyPanel.getText());
            bf.append(System.lineSeparator());
            bf.append("Шифрованный текст");
            bf.append(System.lineSeparator());
            bf.append(MainPanel.shifrovka.getText());

            try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8))
            {
                out.print(bf.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(MainPanel.mainPanel, "Данные успешно сохранены "+System.lineSeparator()+file, "Удача",JOptionPane.INFORMATION_MESSAGE);
        }
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
}
