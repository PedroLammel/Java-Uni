package Semaforos;

public class GestorImpresoras {
    public static void main(String[] args) {
        Persona[] personas = new Persona[10];
        Thread[] threads = new Thread[10];
        Impresora[] fila = new Impresora[5];

        for (int i = 0; i < 5; i++) {
            fila[i] = new Impresora(Integer.toString(i));
        }
        personas[0] = new Persona("p1", fila);
        personas[1] = new Persona("p2", fila);
        personas[2] = new Persona("p3", fila);
        personas[3] = new Persona("p4", fila);
        personas[4] = new Persona("p5", fila);
        personas[5] = new Persona("p6", fila);
        personas[6] = new Persona("p7", fila);
        personas[7] = new Persona("p8", fila);
        personas[8] = new Persona("p9", fila);
        personas[9] = new Persona("p10", fila);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(personas[i]);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
