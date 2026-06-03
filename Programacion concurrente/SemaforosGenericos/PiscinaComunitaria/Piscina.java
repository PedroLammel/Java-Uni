package SemaforosGenericos.PiscinaComunitaria;

import java.util.concurrent.Semaphore;

public class Piscina {
    private Semaphore entradaPiscina;

    public Piscina(int capacidad) {
        entradaPiscina = new Semaphore(capacidad);
    }

    public void pedirEntrada() {
        try {
            entradaPiscina.acquire();
        } catch (InterruptedException e) {
            System.out.println("waow");
        }
    }

    public void salir() {
        entradaPiscina.release();
    }
}
