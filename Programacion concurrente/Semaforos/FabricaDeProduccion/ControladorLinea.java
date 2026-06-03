package Semaforos.FabricaDeProduccion;

public class ControladorLinea implements Runnable {
    private ControladorProduccion controladorProduccion;

    public ControladorLinea(ControladorProduccion controladorProduccion) {
        this.controladorProduccion = controladorProduccion;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(4000);
                System.out.println("Cambiando de linea. . .");
                controladorProduccion.cambiaLinea();
            }
        } catch (InterruptedException e) {
            System.out.println("Cacete");
        }
    }
}
