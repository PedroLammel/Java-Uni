package Synchronized.ej3;

public class Main {
    public static void main(String[] args) {
        Jaula casa = new Jaula();
        Hamster h1 = new Hamster(casa, "h1");
        Hamster h2 = new Hamster(casa, "h2");
        Hamster h3 = new Hamster(casa, "h3");
        Hamster h4 = new Hamster(casa, "h4");
        Hamster h5 = new Hamster(casa, "h5");
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread t4 = new Thread(h4);
        Thread t5 = new Thread(h5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
