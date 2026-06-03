package Parciales.Editorial;

public class Main {
    public static void main(String[] args) {
        int j = 1;
        Editorial editorial = new Editorial();
        Thread[] threads = new Thread[21];
        threads[0] = new Thread(new Redactor(editorial));
        threads[1] = new Thread(new Traductor(editorial), "Traductor 1");
        threads[2] = new Thread(new Traductor(editorial), "Traductor 2");
        for (int i = 3; i < threads.length; i++) {
            if (i < 10) {
                threads[i] = new Thread(new Lector(editorial, 'E'), "Lector " + j);
            } else {
                threads[i] = new Thread(new Lector(editorial, 'I'), "Lector " + j);
            }
            j++;
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
