package Semaforos.Taxistas;

public class Main {
    public static void main(String[] args) {

        Taxi taxi = new Taxi();
        Pasajero pasajero = new Pasajero(taxi);
        Taxista taxista = new Taxista(taxi);
        Thread t1 = new Thread(pasajero);
        Thread t2 = new Thread(taxista);
        t1.start();
        t2.start();
    }
}
