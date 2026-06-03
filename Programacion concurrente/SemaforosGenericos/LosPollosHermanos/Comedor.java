package SemaforosGenericos.LosPollosHermanos;

import java.util.concurrent.Semaphore;

public class Comedor {
    private Semaphore entrada = new Semaphore(2);
    private Semaphore pedidoBebida = new Semaphore(0);
    private Semaphore bebidaLista = new Semaphore(0);
    private Semaphore pedidoComida = new Semaphore(0);
    private Semaphore comidaLista = new Semaphore(0);

    public void pedirEntrada() {
        try {
            entrada.acquire();
        } catch (InterruptedException e) {
            System.out.println("alsjdjnasd");
        }
    }

    public void liberarEntrada() {
        entrada.release();
    }

    public void pedirPedidoBebida() {
        try {
            pedidoBebida.acquire();
        } catch (InterruptedException e) {
            System.out.println("wawawawawa");
        }
    }

    public void liberarPedidoBebida() {
        pedidoBebida.release();
    }

    public void pedirBebidaLista() {
        try {
            bebidaLista.acquire();
        } catch (InterruptedException e) {
            System.out.println("awawawawawa");
        }
    }

    public void liberarBebidaLista() {
        bebidaLista.release();
    }

    public void pedirPedidoComida() {
        try {
            pedidoComida.acquire();
        } catch (InterruptedException e) {
            System.out.println("wawawawawawawawa");
        }
    }

    public void liberarPedidoComida() {
        pedidoComida.release();
    }

    public void pedirComidaLista() {
        try {
            comidaLista.acquire();
        } catch (InterruptedException e) {
            System.out.println("aosndjoansjodi");
        }
    }

    public void liberarComidaLista() {
        comidaLista.release();
    }
}
