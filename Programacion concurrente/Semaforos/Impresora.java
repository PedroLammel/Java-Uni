package Semaforos;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String nombre;
    private Semaphore mutex;

    public Impresora(String nombre) {
        mutex = new Semaphore(1);
        this.nombre = nombre;
    }

    public boolean imprimir(String nombre) {
        boolean impreso = false;
        impreso = mutex.tryAcquire();
        if (impreso) {
            System.out.println(nombre + " va a imprimir");
            System.out.println(nombre + " Imprimiendo en " + this.nombre);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println('k');
            }
            System.out.println(this.nombre + "termino de imprimir");
            mutex.release();
        }
        return impreso;
    }
}
