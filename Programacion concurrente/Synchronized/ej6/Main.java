package Synchronized.ej6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] varios = new int[50000];
        int numeros = 0;
        Thread[] threads = new Thread[5];
        cargarArreglo(varios);
        Dato suma = new Dato();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Sumador(suma, varios, numeros, numeros + 10000), "Sumador" + 1);
            numeros += 10000;
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }

        System.out.println("La suma final es " + suma.getValor());

    }

    public static void cargarArreglo(int[] arr) {
        int nuevoNum;
        Random n = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n.nextInt(9) + 1;
        }
    }
}
