package SemaforosGenericos.LosPollosHermanos;

public class Main {
    public static void main(String[] args) {
        Comedor comedor = new Comedor();
        Thread[] threads = new Thread[20];
        threads[0] = new Thread(new Cocinero(comedor));
        threads[1] = new Thread(new Mozo(comedor));
        for (int i = 2; i < threads.length; i++) {
            threads[i] = new Thread(new Empleado(comedor), "Empleado nº " + (i - 1));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
