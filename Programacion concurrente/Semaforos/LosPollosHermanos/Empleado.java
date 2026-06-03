package Semaforos.LosPollosHermanos;

public class Empleado implements Runnable {
    private Confiteria confiteria;

    public Empleado(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            acercarse();
            hacerPedido();
            comer();
            salir();
        } catch (InterruptedException e) {
            System.out.println("Fudeu amigasso");
        }
    }

    public void acercarse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " se está acercando a la confitería");
        confiteria.acercarse();
        System.out.println(Thread.currentThread().getName() + " entró a la confitería");
    }

    public void hacerPedido() {
        System.out.println(Thread.currentThread().getName() + " está haciendo su pedido");
        confiteria.hacerPedido();
    }

    public void comer() throws InterruptedException {
        confiteria.buscarPedido();
        System.out.println(Thread.currentThread().getName() + " está comiendo. . .");
        Thread.sleep(1500);
    }

    public void salir() {
        System.out.println(Thread.currentThread().getName() + " está saliendo de la confitería");
        confiteria.salir();
    }
}
