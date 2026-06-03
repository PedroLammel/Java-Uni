package Semaforos.LosPollosHermanos;

public class Main {
    public static void main(String[] args) {
        Thread threads[] = new Thread[11];

        Confiteria confiteria = new Confiteria();
        Mozo mozo = new Mozo(confiteria);
        threads[0] = new Thread(mozo, "mozo");
        for (int i = 1; i < 11; i++) {
            threads[i] = new Thread(new Empleado(confiteria), "E" + i);
        }

        for (int i = 0; i < 11; i++) {
            threads[i].start();
        }
    }
}
