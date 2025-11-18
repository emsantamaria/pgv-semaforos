package com.semaforos;

import java.util.concurrent.Semaphore;

public class Estudiante implements Runnable{
    private String nombre;
    private static final Semaphore semaphore = new Semaphore(4);
    public Estudiante(String nombre){
        this.nombre=nombre;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Estudiante "+nombre+" ha empezado a utilizar un equipo");
            Thread.sleep(1000,10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            System.out.println("Estudiante "+ nombre+" ha terminado con el equipo");
            semaphore.release();
        }
    }
    public static void main(String[] args) {
        Thread estudiante1=new Thread (new Estudiante("Estudiante1"));
        Thread estudiante2=new Thread (new Estudiante("Estudiante2"));
        Thread estudiante3=new Thread (new Estudiante("Estudiante3"));
        Thread estudiante4=new Thread (new Estudiante("Estudiante4"));
        Thread estudiante5=new Thread (new Estudiante("Estudiante5"));
        Thread estudiante6=new Thread (new Estudiante("Estudiante6"));
        estudiante1.start();
        estudiante2.start();
        estudiante3.start();
        estudiante4.start();
        estudiante5.start();
        estudiante6.start();
    }
}
