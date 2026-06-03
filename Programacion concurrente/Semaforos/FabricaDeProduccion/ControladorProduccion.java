package Semaforos.FabricaDeProduccion;

import java.util.concurrent.Semaphore;

public class ControladorProduccion {

    // true = linea mecanica, false = linea electrica
    private boolean linea = true;
    private Semaphore entrada = new Semaphore(1);

    public ControladorProduccion() {

    }

    public boolean llegaMecanico() throws InterruptedException {
        boolean terminado = false;
        if (linea) {
            if (entrada.tryAcquire()) {
                System.out.println("Ensamblando un producto mecanico. . .");
                Thread.sleep(1000);
                System.out.println("Producto mecanico ensamblado");
                terminado = true;
            }
        } else {
            Thread.sleep(1000);
        }
        return terminado;
    }

    public boolean llegaElectrico() throws InterruptedException {
        boolean terminado = false;
        if (!linea) {
            if (entrada.tryAcquire()) {
                System.out.println("Ensamblando un producto elétrico. . .");
                Thread.sleep(1000);
                System.out.println("Producto eléctrico ensamblado");
                terminado = true;
            }
        } else {
            Thread.sleep(1000);
        }
        return terminado;
    }

    public void sale() {
        System.out.println("Producto saliendo de la máquina. . .");
        entrada.release();
    }

    public void cambiaLinea() throws InterruptedException {
        if (linea) {
            linea = false;
        } else {
            linea = true;
        }
    }
}
