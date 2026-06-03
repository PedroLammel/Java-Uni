package Synchronized.ej5;

public class Main {
    public static void main(String[] args) {

        Surtidor gas = new Surtidor();

        Auto a1 = new Auto(90, 12, "M02-GS", "A1", "", 20, gas);
        Auto a2 = new Auto(60, 12112001, "CLR-LM", "A2", "", 30, gas);
        Auto a3 = new Auto(120, 14, "MZK-UM", "A3", "", 20, gas);
        Auto a4 = new Auto(60, 12, "M02-GS", "A4", "", 20, gas);
        Auto a5 = new Auto(60, 12, "M02-GS", "A5", "", 20, gas);
        Thread t1 = new Thread(a1, "A1");
        Thread t2 = new Thread(a2, "A2");
        Thread t3 = new Thread(a3, "A3");
        Thread t4 = new Thread(a4, "A4");
        Thread t5 = new Thread(a5, "A5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
