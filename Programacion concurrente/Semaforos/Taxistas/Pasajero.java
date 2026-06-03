package Semaforos.Taxistas;

public class Pasajero implements Runnable {

    private Taxi taxi;

    public Pasajero(Taxi taxi) {
        this.taxi = taxi;
    }

    public void pedirTaxi() {
        System.out.println("Llegó al punto de taxi; llamando uno");
        taxi.pedirTaxi();
    }

    public void caminarHastaPunto() throws InterruptedException {
        System.out.println("Caminando hasta un punto de taxi");
        Thread.sleep(1500);
    }

    public void run() {
        try {
            while (true) {
                caminarHastaPunto();
                pedirTaxi();
                salirDelTaxi();
            }
        } catch (InterruptedException e) {
            System.out.println("kjasndfjknjsdnfjnadf");
        }
    }

    public void salirDelTaxi() throws InterruptedException {
        taxi.salirDelTaxi();
        System.out.println("El pasajero salió del taxi");
    }

}
