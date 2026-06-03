package Synchronized.ej3;

public class Plato {
    public synchronized void comer(String nombre) {
        try {
            System.out.println(nombre + " está comiendo. . .");
            Thread.sleep(1500);
            System.out.println(nombre + " termino de comer");
        } catch (InterruptedException e) {
            System.out.println("Fodase porra");
        }
    }
}
