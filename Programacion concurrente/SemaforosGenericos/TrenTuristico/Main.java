package SemaforosGenericos.TrenTuristico;

public class Main {

    public static void main(String[] args) {
        Tren tren = new Tren(10);
        Thread[] threads = new Thread[41];
        threads[0] = new Thread(new Conductor(tren));
        for (int i = 1; i < threads.length; i++) {
            threads[i] = new Thread(new Pasajero(tren));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
