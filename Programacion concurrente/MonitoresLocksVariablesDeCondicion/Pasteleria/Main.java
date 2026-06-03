package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Main {
    public static void main(String[] args) {
        Pasteleria pasteleria = new Pasteleria(new Caja());
        Thread[] threads = new Thread[6];
        threads[0] = new Thread(new Brazo(pasteleria), "Brazo");
        for (int i = 1; i < 3; i++) {
            threads[i] = new Thread(new Empaquetador(pasteleria), "Empaquetador " + i);
        }
        threads[3] = new Thread(new Horno('A', pasteleria), "Horno A");
        threads[4] = new Thread(new Horno('B', pasteleria), "Horno B");
        threads[5] = new Thread(new Horno('C', pasteleria), "Horno C");
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
