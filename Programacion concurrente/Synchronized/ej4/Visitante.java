package Synchronized.ej4;

import java.util.Random;

public class Visitante implements Runnable {
    private ParqueTematico parque;
    private String nombre;

    public Visitante(ParqueTematico parque, String nombre) {
        this.parque = parque;
        this.nombre = nombre;
    }

    public void run() {
        Area[] nuevo = clonarArray(parque.getAtracciones());
        shuffleArray(nuevo);
        for (int i = 0; i < nuevo.length; i++) {
            try {
                System.out.println(nombre + " realizó una " + nuevo[i].reservar());
                System.out.println(nombre + " terminó la reserva");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Bleh");
            }
        }
    }

    private void shuffleArray(Area[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(9 + 1);
            Area a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private Area[] clonarArray(Area[] arr) {
        Area[] nuevo = new Area[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }
}
