/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author bruce
 */
public class CirclePanel extends JPanel {
    private int radius;

    private Color color;
    public CirclePanel(int radius, int size) {
        this.radius = radius;
        this.setPreferredSize(new Dimension(size, size));
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        if (isOpaque()) {
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
        
        int x = getWidth() / 2 - radius;
        int y = getHeight() / 2 - radius;

        g2d.setColor(color);
        g2d.fillOval(x, y, 2 * radius, 2 * radius);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}


