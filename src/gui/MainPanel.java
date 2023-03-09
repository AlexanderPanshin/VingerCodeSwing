package gui;

import jdk.jfr.StackTrace;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;

public class MainPanel extends JFrame {
    public static JTextArea deshifrovka;
    public static JTextArea shifrovka;
    public static JFrame mainPanel;
    public MainPanel(){
        super("Шифратор/Дешифратор");
        mainPanel = this;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           e.printStackTrace();
        }


        JPanel panelDes = new JPanel();
        JLabel labelDesh = new LabelDeshfrovka();
        JScrollPane jScrollPane1 = new JScrollPane(deshifrovka = new TextAreaDeshifrovka());
        labelDesh.setSize(new Dimension(500,150));
        GroupLayout layout = new GroupLayout(panelDes);
        Font font = deshifrovka.getFont();
        deshifrovka.setFont( font.deriveFont( 16.f ) );
        deshifrovka.getAccessibleContext().setAccessibleDescription("Текст в обычном виде здесь.");
        //Создаем группу в горизонтальной оси
        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential and a parallel groups
        GroupLayout.SequentialGroup h1 = layout.createSequentialGroup();
        GroupLayout.ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        h2.addComponent(labelDesh, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        //Add a container gap to the sequential group h1
        h1.addContainerGap();
        // Add the group h2 to the group h1
        h1.addGroup(h2);
        h1.addContainerGap();
        //Add the group h1 to hGroup
        hGroup.addGroup(GroupLayout.Alignment.TRAILING,h1);
        //Create the horizontal group
        layout.setHorizontalGroup(hGroup);
        //Create a parallel group for the vertical axis
        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential group
        GroupLayout.SequentialGroup v1 = layout.createSequentialGroup();
        //Add a container gap to the sequential group v1
        v1.addContainerGap();
        //Add a label to the sequential group v1
        v1.addComponent(labelDesh);
        v1.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        //Add scroll panel to the sequential group v1
        v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
        v1.addContainerGap();
        //Add the group v1 to vGroup
        vGroup.addGroup(v1);
        //Create the vertical group
        layout.setVerticalGroup(vGroup);
        pack();
        panelDes.setLayout(layout);
        deshifrovka.setComponentPopupMenu(new RMouseMenu(deshifrovka));
        //deshifrovka.setInheritsPopupMenu();

        JPanel panelCentrer = new JPanel(new FlowLayout());
        panelCentrer.add(new ButtonCentrSgif());
        panelCentrer.add(new SlectMenuItem(this));
        panelCentrer.add(new ButtonCentrShifr());

        //pansel shifr
        JPanel panelShifr = new JPanel();
        JLabel labelShifr = new PanelShifr();
        JScrollPane jScrollPane2 = new JScrollPane(shifrovka = new TextAreaShifr());
        labelShifr.setSize(new Dimension(500,150));
        GroupLayout layout2 = new GroupLayout(panelShifr);
        Font font1 = shifrovka.getFont();
        shifrovka.setFont( font1.deriveFont( 16.f ) );
        shifrovka.getAccessibleContext().setAccessibleDescription("Текст в зашифрованном виде здесь.");
        //Создаем группу в горизонтальной оси
        GroupLayout.ParallelGroup hGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential and a parallel groups
        GroupLayout.SequentialGroup h12 = layout2.createSequentialGroup();
        GroupLayout.ParallelGroup h22 = layout2.createParallelGroup(GroupLayout.Alignment.TRAILING);
        h22.addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        h22.addComponent(labelShifr, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        //Add a container gap to the sequential group h1
        h12.addContainerGap();
        // Add the group h2 to the group h1
        h12.addGroup(h22);
        h12.addContainerGap();
        //Add the group h1 to hGroup
        hGroup2.addGroup(GroupLayout.Alignment.TRAILING,h12);
        //Create the horizontal group
        layout2.setHorizontalGroup(hGroup2);
        //Create a parallel group for the vertical axis
        GroupLayout.ParallelGroup vGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential group
        GroupLayout.SequentialGroup v12 = layout2.createSequentialGroup();
        //Add a container gap to the sequential group v1
        v12.addContainerGap();
        //Add a label to the sequential group v1
        v12.addComponent(labelShifr);
        v12.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        //Add scroll panel to the sequential group v1
        v12.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
        v12.addContainerGap();
        //Add the group v1 to vGroup
        vGroup2.addGroup(v12);
        //Create the vertical group
        layout2.setVerticalGroup(vGroup2);
        pack();
        panelShifr.setLayout(layout2);
        //konec panel shifr
        shifrovka.setComponentPopupMenu(new RMouseMenu(shifrovka));

        //Ьок для красоты
        JPanel panelbx = new JPanel();
        panelbx.setLayout(new BoxLayout(panelbx, BoxLayout.Y_AXIS));
        panelbx.add(panelCentrer);
        panelbx.add(PanelKey.getKeyPanel());
        //Бокс для рксоты


        JMenuBar jm = new JMenuBar();
        jm.add(new FileMenuBar());
        jm.add(new SpravkaMenuBar());
        setJMenuBar(jm);

        setLayout(new GridLayout(3,1));
        add(panelDes);
        add(panelbx);
        add(panelShifr);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        setSize(600,600);
        setVisible(true);
    }

}
