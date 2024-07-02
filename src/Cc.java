/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Albert
 */
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Cc extends JApplet {

    double angle = -45 * Math.PI / 180;
    double magnitude = 100;

    JButton translatePositiveX;
    JButton translateNegativeX;
    JButton translatePositiveY;
    JButton translateNegativeY;
    JButton translatePositiveZ;
    JButton translateNegativeZ;
    JButton rotatePositiveX;
    JButton rotateNegativeX;
    JButton rotatePositiveY;
    JButton rotateNegativeY;
    JButton rotatePositiveZ;
    JButton rotateNegativeZ;
    JButton zoomIn;
    JButton zoomOut;
    JButton reset;

    private double initial[][] = {
        {1.5, 0, 0, 0},
        {0, 1.5, 0, 0},
        {0, 0, 1.5, 0},
        {0, 0, 0, 1}
    };
   private final double initialState[][] = {
    {1.5, 0, 0, 0},
    {0, 1.5, 0, 0},
    {0, 0, 1.5, 0},
    {0, 0, 0, 1}
};


    private final double transformations[][][] = {
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, magnitude},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, magnitude},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, -magnitude},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, -magnitude},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, magnitude},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, -magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, magnitude},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, -magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, -magnitude},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, -magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, magnitude},
            {0, 0, 0, 1}
        },
        {
            {1, 0, 0, 0},
            {0, 1, 0, -magnitude},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        }
    };

    Timer timer = new Timer(5, (ActionEvent e) -> {
        double a = 2 * Math.PI / 180;
        if (translatePositiveX.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 1.15},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }
        if (translateNegativeX.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, -1.15},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }
        if (translatePositiveY.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, -1.1},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }
        if (translateNegativeY.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 1.1},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }
        if (translatePositiveZ.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1.1},
                {0, 0, 0, 1}
            });
        }
        if (translateNegativeZ.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, -1.1},
                {0, 0, 0, 1}
            });
        }

        if (rotatePositiveX.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(a), -Math.sin(a), 0},
                {0, Math.sin(a), Math.cos(a), 0},
                {0, 0, 0, 1}
            });
        }
        if (rotateNegativeX.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1, 0, 0, 0},
                {0, Math.cos(-a), -Math.sin(-a), 0},
                {0, Math.sin(-a), Math.cos(-a), 0},
                {0, 0, 0, 1}
            });
        }
        if (rotatePositiveY.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {Math.cos(-a), 0, Math.sin(-a), 0},
                {0, 1, 0, 0},
                {-Math.sin(-a), 0, Math.cos(-a), 0},
                {0, 0, 0, 1}
            });
        }
        if (rotateNegativeY.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {Math.cos(a), 0, Math.sin(a), 0},
                {0, 1, 0, 0},
                {-Math.sin(a), 0, Math.cos(a), 0},
                {0, 0, 0, 1}
            });
        }
        if (rotatePositiveZ.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {Math.cos(a), -Math.sin(a), 0, 0},
                {Math.sin(a), Math.cos(a), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }
        if (rotateNegativeZ.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {Math.cos(-a), -Math.sin(-a), 0, 0},
                {Math.sin(-a), Math.cos(-a), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            });
        }

        if (zoomIn.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {1.02, 0, 0, 0},
                {0, 1.02, 0, 0},
                {0, 0, 1.02, 0},
                {0, 0, 0, 1}
            });
        }
        if (zoomOut.getModel().isPressed()) {
            initial = multiplyMatrices(initial, new double[][]{
                {0.98, 0, 0, 0},
                {0, 0.98, 0, 0},
                {0, 0, 0.98, 0},
                {0, 0, 0, 1}
            });
        }

        repaint();
    });

    public Cc() {
        initComponents();
        timer.start();
    }
    private void initComponents() {
//    this.setTitle("Prac Cubo");
//    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
//    this.setResizable(false);

    JPanel cubePanel = new JPanel() {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D gg = (Graphics2D) g;
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gg.translate(295, 225);
            Point origin;
            Point destination;
            double[][] aux = initial.clone();
            for (int i = 0; i < 15; i++) {
                aux = multiplyMatrices(aux, transformations[i]);
                origin = get2DCoordinates(aux);
                destination = get2DCoordinates(multiplyMatrices(aux, transformations[i + 1]));
                gg.setColor(Color.black); // Change cube color to black
                gg.drawLine(origin.x, origin.y, destination.x, destination.y);
            }
        }
    };
    cubePanel.setPreferredSize(new Dimension(620, 620));
    cubePanel.setBackground(new Color(140, 200, 250)); // Change background color to purple

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(135, 200, 235)); // Change background color to purple
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    translateNegativeX = new JButton("X -");
    translatePositiveX = new JButton("X +");
    translateNegativeY = new JButton("Y -");
    translatePositiveY = new JButton("Y +");
    translateNegativeZ = new JButton("Z -");
    translatePositiveZ = new JButton("Z +");

    rotateNegativeX = new JButton("X -");
    rotatePositiveX = new JButton("X +");
    rotateNegativeY = new JButton("Y -");
    rotatePositiveY = new JButton("Y +");
    rotateNegativeZ = new JButton("Z -");
    rotatePositiveZ = new JButton("Z +");

    zoomOut = new JButton("-");
    zoomIn = new JButton("+");
    reset = new JButton("Reset");

    // Set the background color of the buttons to a pastel green
    Color pastelGreen = new Color(135, 206, 235);

    translateNegativeX.setBackground(pastelGreen);
    translatePositiveX.setBackground(pastelGreen);
    translateNegativeY.setBackground(pastelGreen);
    translatePositiveY.setBackground(pastelGreen);
    translateNegativeZ.setBackground(pastelGreen);
    translatePositiveZ.setBackground(pastelGreen);
    rotateNegativeX.setBackground(pastelGreen);
    rotatePositiveX.setBackground(pastelGreen);
    rotateNegativeY.setBackground(pastelGreen);
    rotatePositiveY.setBackground(pastelGreen);
    rotateNegativeZ.setBackground(pastelGreen);
    rotatePositiveZ.setBackground(pastelGreen);
    zoomOut.setBackground(pastelGreen);
    zoomIn.setBackground(pastelGreen);
    reset.setBackground(pastelGreen);

    buttonPanel.add(translateNegativeX);
    buttonPanel.add(translatePositiveX);
    buttonPanel.add(translateNegativeY);
    buttonPanel.add(translatePositiveY);
    buttonPanel.add(translateNegativeZ);
    buttonPanel.add(translatePositiveZ);

    buttonPanel.add(rotateNegativeX);
    buttonPanel.add(rotatePositiveX);
    buttonPanel.add(rotateNegativeY);
    buttonPanel.add(rotatePositiveY);
    buttonPanel.add(rotateNegativeZ);
    buttonPanel.add(rotatePositiveZ);

    buttonPanel.add(zoomOut);
    buttonPanel.add(zoomIn);
    buttonPanel.add(reset);

    reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            initial = initialState.clone();
            repaint();
        }
    });

    this.add(buttonPanel, BorderLayout.NORTH);
    this.add(cubePanel, BorderLayout.CENTER);
//    this.pack();
}

 
    double[][] multiplyMatrices(double[][] matrixOne, double[][] matrixTwo) {
        double[][] resultMatrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    resultMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
        return resultMatrix;
    }

    Point get2DCoordinates(double[][] matrix) {
        return new Point((int) (matrix[0][3] - matrix[2][3] * Math.cos(angle)), (int) (matrix[1][3] - matrix[2][3] * Math.sin(angle)));
    }

//    public static void main(String[] args) {
//        Cc obj = new Cc();
//        obj.setVisible(true);
//    }
}