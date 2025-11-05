package com.docencia.hilos;

public class Main {
    public static void main(String[] args) {
        MiRunnable miRunnable = new MiRunnable();
        Thread thread = new Thread(miRunnable);
        System.out.println("Arrancamos");
        thread.start();
        try {
            System.out.println("A mimir ");
            thread.sleep(5000);
            System.out.println("Hilo reanudado");
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");

        }
    }

}
