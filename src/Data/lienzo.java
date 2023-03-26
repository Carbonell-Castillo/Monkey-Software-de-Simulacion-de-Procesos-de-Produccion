/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Data;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author diego
 */
public class lienzo extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form lienzo
     */
    
    private int x = getWidth(); // Coordenada de origen en x
    private int y = getHeight();// Cordenada de origen en y
    int contador = 1; // Contador de las vueltas que ha dado
    private Color color; // Variable para cambiar el color a la figura
    
    Thread hilo;
    
    
    private boolean tope;

    public lienzo() {
        initComponents();
        hilo = new Thread(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(204, 255, 0));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void paint(Graphics g) {
        
        // Configuracion del rectangulo de fondo
        g.setColor(null);
        
        /*
            Se dibujara el rectangulo en las coordenadas 0,0
            con un ancho del largo del JPanel
            y una altura del alto del JPanel
        */
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //Cofiguracion de los otros rectangulos
        g.setColor(Color.RED);
        g.fillRect(0, 0, 20, 20);
        
        // Configuracion del circulo 
        g.setColor(color);
        
        /*
            Se dibujara el circulo en las coordenadas 0,0
            con un tamaño de 30 de ancho y 30 de altura
        */
        g.fillOval(x, y, 30, 30);

    }

    public void inicio() {
        hilo.start();
    }

    public void pausar() {
        hilo.suspend();
    }
    
    public void continuar() {
        hilo.resume();
    }

    @Override
    public void run() {
        
        try {
            // Ciclo while para que ejecute la animacion sin parar
            while (true) {
                if(x == 10 && y == 10) {
                    contador++; // Contador para cuando el circulo llegue a las coordenadas (10,10)
                }
                
                /*
                    Verificacion de que el circulo llego al tope de en
                    dirrecion horizontal hacia la derecha
                */
                /*  
                    Se resta el tamaño de la ancho con 40
                    porque el circulo tiene 30 de ancho
                */
                while (x <= jPanel1.getWidth() - 90) {
                    
                    Thread.sleep(100); // Velocidad con la que mueve el circulo
                    x += 10;
                    repaint(); // Se llama al metodo para redibujar el circulo
                }

                this.color = Color.RED;
                
                /*
                    Verificacion de que el circulo llego al tope de en
                    dirrecion vertical hacia abajo
                */
                
                /*  
                    Se resta el tamaño de la altura con 40
                    porque el circulo tiene 30 de altura
                */
                while (y <= jPanel1.getHeight() - 40) { 
                    Thread.sleep(100); // Velocidad con la que mueve el circulo
                    y += 10;
                    repaint(); // Se llama al metodo para redibujar el circulo
                }
                
                this.color = Color.GREEN;
                
                /*
                    Verificacion de que el circulo llego al tope de en
                    dirrecion horizontal hacia la izquierda
                */
                while (x > 10) {
                    Thread.sleep(100); // Velocidad con la que mueve el circulo
                    x -= 10;
                    repaint(); // Se llama al metodo para redibujar el circulo
                }
                
                this.color = Color.BLUE;
                
                /*
                    Verificacion de que el circulo llego al tope de en
                    dirrecion horizontal hacia arriba
                */
                while (y > 10) {
                    Thread.sleep(100); // Velocidad con la que mueve el circulo
                    y -= 10;
                    repaint(); // Se llama al metodo para redibujar el circulo
                }
                
                this.color = Color.YELLOW;
                System.out.println(contador);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getTope() {
        return this.tope;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
