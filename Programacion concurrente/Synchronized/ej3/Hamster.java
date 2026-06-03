package Synchronized.ej3;

public class Hamster implements Runnable {
    private Jaula casa;
    private String nombre;

    public Hamster(Jaula casa, String nombre) {
        this.casa = casa;
        this.nombre = nombre;
    }

    public void run() {
        this.casa.comer(nombre);
        this.casa.correr(nombre);
        this.casa.dormir(nombre);
    }
}
