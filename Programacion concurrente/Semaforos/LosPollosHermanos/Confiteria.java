package Semaforos.LosPollosHermanos;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore puertaConfiteria = new Semaphore(1);
    private Semaphore pedidoHecho = new Semaphore(0);
    private Semaphore pedidoPreparado = new Semaphore(0);

    public void acercarse() throws InterruptedException {
        puertaConfiteria.acquire();
    }

    public void hacerPedido() {
        pedidoHecho.release();
    }

    public void preguntarPedido() throws InterruptedException {
        pedidoHecho.acquire();
    }

    public void entregarPedido() {
        pedidoPreparado.release();
    }

    public void buscarPedido() throws InterruptedException {
        pedidoPreparado.acquire();
    }

    public void salir() {
        puertaConfiteria.release();
    }

}
