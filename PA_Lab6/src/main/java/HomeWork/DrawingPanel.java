package HomeWork;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 500;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    private boolean[][] hasEdge;
    private final int[][] coloredEdges = new int[20][20];
    private boolean gameOver = false;
    private int winner = 0;

    private int player = 1;

    BufferedImage img;
    Graphics2D graphics2D;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            private int firstVertexIndex = -1;

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(Arrays.deepToString(coloredEdges));
                int mouseX = e.getX();
                int mouseY = e.getY();
                for (int i = 0; i < numVertices; i++) {
                    int dx = mouseX - x[i];
                    int dy = mouseY - y[i];
                    if (dx * dx + dy * dy <= 25) { // Check if mouse is within 5 pixels of vertex
                        System.out.println("Clicked on vertex 'i':" + i);
                        if (firstVertexIndex == -1) {
                            System.out.println("first vertex clicked");
                            firstVertexIndex = i;
                        } else {
                            System.out.println("second vertex clicked");
                            if (hasEdge[firstVertexIndex][i] && player == 1 && coloredEdges[firstVertexIndex][i] == 0 && coloredEdges[i][firstVertexIndex] == 0) {
                                coloredEdges[firstVertexIndex][i] = 1;
                                coloredEdges[i][firstVertexIndex] = 1;
                                graphics2D.setColor(Color.red);
                                graphics2D.drawLine(x[firstVertexIndex], y[firstVertexIndex], x[i], y[i]);
                                player = 2;
                            } else if (hasEdge[firstVertexIndex][i] && player == 2 && coloredEdges[firstVertexIndex][i] == 0 && coloredEdges[i][firstVertexIndex] == 0) {
                                coloredEdges[firstVertexIndex][i] = 2;
                                coloredEdges[i][firstVertexIndex] = 2;
                                graphics2D.setColor(Color.blue);
                                graphics2D.drawLine(x[firstVertexIndex], y[firstVertexIndex], x[i], y[i]);
                                player = 1;
                            } else if (coloredEdges[firstVertexIndex][i] != 0 && coloredEdges[i][firstVertexIndex] != 0) {
                                JOptionPane.showMessageDialog(frame, "THIS EDGE IS NOT AVAILABLE! CHOOSE ANOTHER ONE!");
                            } else if (firstVertexIndex == i) {
                                JOptionPane.showMessageDialog(frame, "THERE IS NO EDGE FROM AND TO THE SAME NODE!");
                            } else {
                                JOptionPane.showMessageDialog(frame, "NO EDGE! BETWEEN VERTICES: " + firstVertexIndex + " AND " + i);
                                System.out.println("NO EDGE! BETWEEN VERTICES: " + firstVertexIndex + " AND " + i);
                            }
                            firstVertexIndex = -1;
                        }
                    }
                    repaint();
                }
                checkGameOver();
                System.out.println("The winner is: " + winner);
            }

        });
    }

    private void createOffscreenImage() {
        img = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics2D = img.createGraphics();
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, W, H);
    }

    final void createBoard(int numVerticesReceived, double edgeProbabilityReceived) {
        numVertices = numVerticesReceived;
        edgeProbability = edgeProbabilityReceived;
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        this.hasEdge = new boolean[numVertices][numVertices];
        graphics2D.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                double rand = Math.random();
                if (rand < edgeProbability) {
                    graphics2D.drawLine(x[i], y[i], x[j], y[j]);
                    hasEdge[i][j] = true;
                    hasEdge[j][i] = true;
                }
            }
        }
    }

    private void drawVertices() {
        graphics2D.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics2D.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    private boolean isTriangle(int player) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (coloredEdges[i][j] == player) {
                    for (int k = j + 1; k < numVertices; k++) {
                        if (coloredEdges[j][k] == player && coloredEdges[k][i] == player) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void checkGameOver() {
        int RED = 1;
        int BLUE = 2;
        if (isTriangle(RED)) {
            gameOver = true;
            winner = BLUE;
            JOptionPane.showMessageDialog(frame, "Congratulations! BLUE player wins!");
        } else if (isTriangle(BLUE)) {
            gameOver = true;
            winner = RED;
            JOptionPane.showMessageDialog(frame, "Congratulations! RED player wins!");
        } else {
            gameOver = true;
            for (int i = 0; i < numVertices; i++) {
                for (int j = i + 1; j < numVertices; j++) {
                    if (coloredEdges[i][j] == 0) {
                        gameOver = false;
                        break;
                    }
                }
            }
            if (gameOver) {
                winner = 0; // draw
            }
        }
    }

    public void exportToPNG(File file) {
        try {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            paint(image.getGraphics());
            ImageIO.write(image, "png", file);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(img, 0, 0, this);
    }
}
