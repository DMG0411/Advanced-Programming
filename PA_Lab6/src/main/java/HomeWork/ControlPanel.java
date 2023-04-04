package HomeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }


    private void init() {
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::exitGame);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
