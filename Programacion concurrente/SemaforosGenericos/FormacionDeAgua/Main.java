package SemaforosGenericos.FormacionDeAgua;

public class Main {

    public static void main(String[] args) {
        Atmosfera atmosfera = new Atmosfera();
        Thread[] threads = new Thread[31];
        for (int i = 0; i < threads.length; i++) {
            if (i < 20) {
                threads[i] = new Thread(new Oxigeno(atmosfera));
            } else if (i >= 20 && i < 30) {
                threads[i] = new Thread(new Hidrogeno(atmosfera));
            } else {
                threads[i] = new Thread(new Recipiente(atmosfera, 10));
            }
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Fin!");
    }

}
