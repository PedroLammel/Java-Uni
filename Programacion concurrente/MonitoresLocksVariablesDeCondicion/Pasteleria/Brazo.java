package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Brazo implements Runnable {
    private Pasteleria pasteleria;

    public Brazo(Pasteleria pasteleria) {
        this.pasteleria = pasteleria;
    }

    public void run() {
        while (true) {
            entregarCaja();
        }
    }

    public void entregarCaja() {
        pasteleria.entregarCaja();
    }
}
