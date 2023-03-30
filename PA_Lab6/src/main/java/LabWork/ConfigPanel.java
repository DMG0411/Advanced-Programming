package LabWork;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesComboBox;
    JButton drawButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        dotsLabel = new JLabel("Number of nodes");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(20,1,21,1));

        linesLabel = new JLabel("Probability to create line");
        String [] lineProbabilities = {"0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0"};
        linesComboBox = new JComboBox(lineProbabilities);

        drawButton = new JButton("Draw the masterpiece");

        add(dotsLabel);
        add(dotsSpinner);

        add(linesLabel);
        add(linesComboBox);

        add(drawButton);
    }
}
