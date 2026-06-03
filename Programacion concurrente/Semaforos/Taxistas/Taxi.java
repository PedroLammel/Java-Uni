package Semaforos.Taxistas;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore pasajeroEsperando = new Semaphore(0);
    private Semaphore enViaje = new Semaphore(0);

    public void pedirTaxi() {
        pasajeroEsperando.release();
    }

    public void esperarPasajero() throws InterruptedException {
        pasajeroEsperando.acquire();
    }

    public void salirDelTaxi() throws InterruptedException {
        enViaje.acquire();
    }

    public void terminarViaje() {
        enViaje.release();
    }

}
