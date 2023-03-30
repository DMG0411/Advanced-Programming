package LabWork;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;

    DrawingPanel drawingPanel;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    public MainFrame() {
        super("Drawing Game");
        init();
    }

    private void init(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,(int)width-200,(int)height-200);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);

        add(configPanel,BorderLayout.NORTH);
        add(drawingPanel,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
