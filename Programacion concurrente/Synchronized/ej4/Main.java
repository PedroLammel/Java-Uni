package Synchronized.ej4;

public class Main {
    public static void main(String[] args) {
        ParqueTematico p = new ParqueTematico();
        Visitante v1 = new Visitante(p, "v1");
        Visitante v2 = new Visitante(p, "v2");
        Visitante v3 = new Visitante(p, "v3");
        Visitante v4 = new Visitante(p, "v4");
        Visitante v5 = new Visitante(p, "v5");
        Thread t1 = new Thread(v1);
        Thread t2 = new Thread(v2);
        Thread t3 = new Thread(v3);
        Thread t4 = new Thread(v4);
        Thread t5 = new Thread(v5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
