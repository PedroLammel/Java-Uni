package SemaforosGenericos.FormacionDeAgua;

import java.util.concurrent.Semaphore;

public class Atmosfera {
    private Semaphore hidrogenoActivo = new Semaphore(1);
    private Semaphore oxigenoActivo = new Semaphore(2);
    private Semaphore oListo = new Semaphore(0);
    private Semaphore hListo = new Semaphore(0);
    private Semaphore productor = new Semaphore(1);
    private Semaphore salaDeEspera = new Semaphore(0);
    private Semaphore aguaLista = new Semaphore(0);

    public void pedirHidrogenoActivo() {
        try {
            hidrogenoActivo.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void pedirOxigenoActivo() {
        try {
            oxigenoActivo.acquire();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void liberarHidrogenoActivo() {
        hidrogenoActivo.release();
    }

    public void liberarOxigenoActivo() {
        oxigenoActivo.release();
    }

    public boolean pedirOListos() {
        boolean esElProductor;
        try {
            esElProductor = productor.tryAcquire();
            if (esElProductor) {
                System.out.println("Produciendo água. . .");
                oListo.acquire(2);
            }
        }

        catch (InterruptedException e) {
            esElProductor = false;
        }
        return esElProductor;
    }

    public void esperarProductor() {
        try {
            salaDeEspera.acquire();
        } catch (InterruptedException e) {
            System.out.println("awawawa");
        }
    }

    public void pedirHListo() {
        try {
            hListo.acquire();
        }

        catch (InterruptedException e) {
            System.out.println("awawawawawa");
        }
    }

    public void pedirAguaLista(int k) {
        try {
            aguaLista.acquire(k);
        } catch (InterruptedException e) {
            System.out.println("abababababababa");
        }
    }

    public void liberarHListo() {
        hListo.release();
    }

    public void liberarOListo() {
        oListo.release();
    }

    public void liberarAguaLista() {
        aguaLista.release();
    }

    public void hacerAgua() {
        try {
            System.out.println("El água se está formando. . .");
            Thread.sleep(3000);
            aguaLista.release();
        } catch (Exception e) {
            System.out.println("awawwawawawawawa");
        }
    }

    public void liberarProductor() {
        salaDeEspera.release(2);
        productor.release();
    }
}
