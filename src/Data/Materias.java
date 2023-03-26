/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author bruce
 */
public class Materias {
    private ArrayList <MateriaPrima> materiasPrimas;
    
     public Materias(){
        this.materiasPrimas= new ArrayList();
    }
    
    public void addKiosk(MateriaPrima materiasPrima){
        materiasPrimas.add(materiasPrima);
    }
    
    public int getLength(){
        return materiasPrimas.size();
    }
    public MateriaPrima getKioskRecord(int pos){
        return materiasPrimas.get(pos);
    }
    
    public MateriaPrima searchKioskId(int id){
        MateriaPrima resultMateriaPrimas = new MateriaPrima();
        
        
        for (int i = 0; i < materiasPrimas.size(); i++) {
           MateriaPrima materiaPrima = materiasPrimas.get(i);
           if(materiaPrima.getId()==id){
               resultMateriaPrimas= materiaPrima;
           }
        }
        
        return resultMateriaPrimas;
    }
    
}
