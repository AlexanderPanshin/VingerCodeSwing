import gui.MainPanel;
import logik.ShifrBase64;
import logik.ShifrPleifera;

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
