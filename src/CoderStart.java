import gui.MainPanel;
import logik.ShifCezerya;
import logik.ShifrA1Z26;
import logik.ShifrVinigira;

import javax.swing.*;

public class CoderStart  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainPanel m1 = new MainPanel();
            }
        });

    }

}
