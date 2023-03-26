/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.Observable;

/**
 *
 * @author diego
 */
public class temporizador extends Observable implements Runnable{
    
    /*
        Se define esta clase como Observable para actualizar el valor del timepo
        a las clases Observer
    */
    private int horas, minutos, segundos;

    // Constructo de la clase de temporizador
    public temporizador(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    
    
    @Override
    public void run() {
        String tiempo;
        
        try {
            while (true) {                
                tiempo = "";
                
                if(horas < 10) {
                    tiempo += "0" + horas;
                } else {
                    tiempo += horas;
                }
                
                tiempo += ":";
                
                if(minutos < 10) {
                    tiempo += "0" + minutos;
                } else {
                    tiempo += minutos;
                }
                tiempo += ":";
                if(segundos < 10) {
                    tiempo += "0" + segundos;
                } else {
                    tiempo += segundos;
                }
                
                /*
                    Enviamos la variable que cambio 
                    a las clases observer
                */
                this.setChanged();
                this.notifyObservers(tiempo);
                this.clearChanged();
                
                Thread.sleep(1000);
                
                segundos++;
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        horas++;
                        if (horas == 24) {
                            horas=0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
