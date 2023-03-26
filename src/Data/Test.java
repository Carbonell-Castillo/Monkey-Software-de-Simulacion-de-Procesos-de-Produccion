/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author bruce
 */

    import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel jInventario = new JPanel();
        jInventario.setBounds(50, 50, 200, 200); // Establece la posición y tamaño del panel
        CirclePanel circlePanel = new CirclePanel(50); // Crea un panel con radio de 50
        jInventario.add(circlePanel); // Agrega el panel al jInventario
        frame.add(jInventario); // Agrega el jInventario al JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

class CirclePanel extends JPanel {
    private int radius;
    
    public CirclePanel(int radius) {
        this.radius = radius;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = getWidth() / 2 - radius;
        int y = getHeight() / 2 - radius;
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, 2 * radius, 2 * radius);
    }
}


