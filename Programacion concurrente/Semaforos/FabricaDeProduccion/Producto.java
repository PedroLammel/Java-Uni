package Semaforos.FabricaDeProduccion;

public class Producto implements Runnable {
    private String categoria;
    private ControladorProduccion controladorProduccion;

    public Producto(String categoria, ControladorProduccion controladorProduccion) {
        this.categoria = categoria;
        this.controladorProduccion = controladorProduccion;
    }

    public void run() {
        try {
            // Espera un tiempo para simular andar por el bus mecanico
            Thread.sleep(500);
            boolean terminado = false;
            while (!terminado) {
                if (categoria.equals("Electrico")) {
                    terminado = controladorProduccion.llegaElectrico();
                    Thread.sleep(1000);
                } else {
                    terminado = controladorProduccion.llegaMecanico();
                    Thread.sleep(1000);
                }
            }
            controladorProduccion.sale();
        } catch (InterruptedException e) {
            System.out.println("Esperando");
        }
    }
}
