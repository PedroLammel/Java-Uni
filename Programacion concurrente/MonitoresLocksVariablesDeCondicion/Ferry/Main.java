package MonitoresLocksVariablesDeCondicion.Ferry;

public class Main {
    public static void main(String[] args) {
        int j = 1;
        Puerto puerto = new Puerto(20);
        Thread[] threads = new Thread[60];
        threads[0] = new Thread(new Ferry(puerto));
        for (int i = 1; i < 50; i++) {
            threads[i] = new Thread(new Pasajero(puerto), "Pasajero " + j);
            j++;
        }
        j = 1;
        for (int i = 50; i < threads.length; i++) {
            threads[i] = new Thread(new Automovil(2, puerto), "Automovil " + j);
            j++;
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
