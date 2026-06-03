package Semaforos.Taxistas;

public class Taxista implements Runnable {

    private Taxi taxi;

    public Taxista(Taxi taxi) {
        this.taxi = taxi;
    }

    public void run() {
        try {
            while (true) {
                esperarPasajero();
                this.viajar();
                terminarViaje();
            }
        } catch (InterruptedException e) {
            System.out.println("sknfjk");
        }
    }

    public void esperarPasajero() throws InterruptedException {
        System.out.println("Taxista está durmiendo");
        taxi.esperarPasajero();
    }

    public void viajar() throws InterruptedException {
        System.out.println("Taxi está viajando. . .");
        Thread.sleep(1500);

    }

    public void terminarViaje() {
        taxi.terminarViaje();
    }
}
