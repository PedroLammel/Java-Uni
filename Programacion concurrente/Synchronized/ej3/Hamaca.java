package Synchronized.ej3;

public class Hamaca {
    public synchronized void dormir(String nombre) {
        try {
            System.out.println(nombre + " está durmiendo. . .");
            Thread.sleep(1000);
            System.out.println(nombre + " terminó de dormir");
        } catch (InterruptedException e) {
            System.out.println("bleh");
        }
    }
}
