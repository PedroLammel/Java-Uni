package Synchronized.ej6;

public class Dato {
    private int valor = 0;

    public Dato() {
    }

    public synchronized void sumar(int[] arreglo, int i) {
        System.out.println("Sumando. . .");
        valor += arreglo[i];
        System.out.println("Fin suma");
    }

    public int getValor() {
        return valor;
    }
}
