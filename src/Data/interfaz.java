/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Data;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class interfaz extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form interfaz
     */
    
    // Se inicializa el objeto de clase temporizador 
    temporizador temporizador = new temporizador(0, 0, 0);
    /*
       Se inicializa el hilo de la clase de temporizador
    */
    Thread reloj = new Thread(temporizador);
    
    public interfaz() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bninicio = new javax.swing.JButton();
        bnpausar = new javax.swing.JButton();
        bncontinuar = new javax.swing.JButton();
        lblcontador = new javax.swing.JLabel();
        lienzo1 = new Data.lienzo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        bninicio.setText("Inicio");
        bninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bninicioActionPerformed(evt);
            }
        });

        bnpausar.setText("Pausa");
        bnpausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnpausarActionPerformed(evt);
            }
        });

        bncontinuar.setText("Continuar");
        bncontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncontinuarActionPerformed(evt);
            }
        });

        lblcontador.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblcontador.setText("00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(lblcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bninicio)
                                .addGap(83, 83, 83)
                                .addComponent(bnpausar)
                                .addGap(61, 61, 61)
                                .addComponent(bncontinuar)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblcontador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bninicio)
                    .addComponent(bnpausar)
                    .addComponent(bncontinuar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bninicioActionPerformed
        
        bninicio.setEnabled(false);
        // Se ejecuta el lienzo donde se ejecutara la animacion
        lienzo1.setColor(Color.yellow);
        lienzo1.inicio();
       
        // Se agrega el cambio resibido en la clase Observable(temporizador)
        temporizador.addObserver(this);
        // Se ejecuta el hilo del temporizador
        reloj.start();
        
        
    }//GEN-LAST:event_bninicioActionPerformed

    private void bnpausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnpausarActionPerformed
        
        // Se pausea los hilos 
        lienzo1.pausar();
        reloj.suspend();
    }//GEN-LAST:event_bnpausarActionPerformed

    private void bncontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncontinuarActionPerformed
        
        // Se continua el hilo que se termino
        lienzo1.continuar();
        reloj.resume();
    }//GEN-LAST:event_bncontinuarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bncontinuar;
    private javax.swing.JButton bninicio;
    private javax.swing.JButton bnpausar;
    private javax.swing.JLabel lblcontador;
    private Data.lienzo lienzo1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        /*
        Se agrega el texto actualizado en el label del contador
        el arg es el objeto tiempo que se recibe de la clase Observable(temporizador)
        
        */
        lblcontador.setText((String) arg);
    }
}
