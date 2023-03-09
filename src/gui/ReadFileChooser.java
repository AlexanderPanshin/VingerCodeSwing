package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileChooser extends JFileChooser {
    public ReadFileChooser(int i) {
        int position = i;
        setDialogTitle("Открыть файл");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".txt", "txt");
        setFileFilter(filter);
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = showSaveDialog(MainPanel.mainPanel);
        if(result == 0){
            File file = getSelectedFile().getAbsoluteFile();
            StringBuffer sb = new StringBuffer();
            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (position){
                case 1:
                    MainPanel.shifrovka.setText(sb.toString());
                    break;
                case 2:
                    MainPanel.deshifrovka.setText(sb.toString());
            }
        }
    }
}
