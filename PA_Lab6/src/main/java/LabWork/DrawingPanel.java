package LabWork;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    final MainFrame frame;

    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    BufferedImage img;
    Graphics2D graphics2D;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
//        edgeProbability = (Double) frame.configPanel.linesComboBox.getSelectedItem();
        createOffscreenImage();
        repaint();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W,H));
    }

    private void createOffscreenImage() {
        img = new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics2D = img.createGraphics();
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON
        );
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,800,600);
    }

}
