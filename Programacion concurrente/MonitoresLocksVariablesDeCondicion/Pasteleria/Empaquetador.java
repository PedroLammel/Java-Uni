package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Empaquetador implements Runnable {
    private Pasteleria pasteleria;

    public Empaquetador(Pasteleria pasteleria) {
        this.pasteleria = pasteleria;
    }

    public void run() {
        while (true) {
            empaquetar();
        }
    }

    public void empaquetar() {
        try {
            pasteleria.empaquetarPastel();
            Thread.sleep(1000);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
