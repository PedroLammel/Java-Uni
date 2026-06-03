package Semaforos;

public class Persona implements Runnable {
    private String nombre;
    boolean imprimido = false;
    private Impresora[] impresoras;

    public Persona(String nombre, Impresora[] impresoras) {
        this.nombre = nombre;
        this.impresoras = impresoras;
    }

    public void run() {
        int i = 0;
        while (!imprimido) {
            imprimido = impresoras[i].imprimir(nombre);
            if (i == impresoras.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
    }
}
