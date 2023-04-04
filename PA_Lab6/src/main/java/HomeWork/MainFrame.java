package HomeWork;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;

    static DrawingPanel drawingPanel;

    double w = 1000;
    double h = 800;

    public MainFrame() {
        super("Drawing Game");
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, (int) w - 200, (int) h - 200);

        configPanel = new ConfigPanel(this);
        configPanel.setBackground(Color.lightGray);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
