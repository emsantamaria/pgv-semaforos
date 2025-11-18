package com.semaforos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Eliminado el uso de Semaphore porque el diseño anterior bloqueaba el hilo

public class Semaforo implements Runnable {
    public static final Object LOCK = new Object();
    public static volatile String estado = "ROJO";

    List<String> colores=new ArrayList<>(Arrays.asList("ROJO","AMBAR","VERDE"));
    String colorActual="ROJO";

    void rojo(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void ambar(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void verde(){
           long milis=System.currentTimeMillis()+3000;
           while (System.currentTimeMillis()<milis) {
            
           }
    }

    @Override
    public void run() {
        long deadline = System.currentTimeMillis() + 20000;
        while ( System.currentTimeMillis() < deadline) {
            System.out.println("Semaforo en "+colorActual);
            switch (colorActual) {
                case "ROJO":
                    rojo();
                    break;
                case "VERDE":
                    verde();
                    break;
                default:
                    ambar();
                    break;
            }
            estado = colorActual;
            
            int index=colores.indexOf(colorActual)+1;
            if(index==colores.size()){
                index=0;
            }
            colorActual=colores.get(index);
        }
       
        System.out.println("El semaforo ha terminado su ciclo");
    }
public static void main(String[] args) {
    Thread semaforo=new Thread (new Semaforo(),"semaforo");
    semaforo.start();
}
    

}
