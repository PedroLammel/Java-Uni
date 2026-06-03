package Synchronized.ej3;

public class Rueda {
    public synchronized void correr(String nombre) {
        try {
            System.out.println(nombre + " está corriendo. . .");
            Thread.sleep(1500);
            System.out.println(nombre + " terminó de correr");
        } catch (InterruptedException e) {
            System.out.println("ajsndijansjdinasod");
        }
    }
}
