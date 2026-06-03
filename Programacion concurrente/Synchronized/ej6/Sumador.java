package Synchronized.ej6;

public class Sumador implements Runnable {
    public Sumador(Dato suma, int[] arr, int min, int max) {
        this.suma = suma;
        this.arr = arr;
        this.min = min;
        this.max = max;
    }

    private Dato suma;
    private int[] arr;
    private int min;
    private int max;

    public Sumador(Dato suma) {
        this.suma = suma;
    }

    public void run() {
        try {
            for (int i = min; i < max; i++) {
                suma.sumar(arr, i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("ansjnjd");
        }
    }
}
