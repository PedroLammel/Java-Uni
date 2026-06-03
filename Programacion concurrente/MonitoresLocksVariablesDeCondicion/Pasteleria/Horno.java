package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Horno implements Runnable {
    private char tipo;
    private Pasteleria pasteleria;

    public Horno(char tipo, Pasteleria pasteleria) {
        this.tipo = tipo;
        this.pasteleria = pasteleria;
    }

    public void run() {
        while (true) {
            producirPastel();
        }
    }

    public void producirPastel() {
        try {
            pasteleria.producirPastel(tipo);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("bweh");
        }
    }
}
