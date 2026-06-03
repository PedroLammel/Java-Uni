package SemaforosGenericos.PiscinaComunitaria;

public class Main {
    public static void main(String[] args) {
        Piscina pileta = new Piscina(20);
        Thread[] threads = new Thread[56];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Persona(pileta), "persona " + (i + 1));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
