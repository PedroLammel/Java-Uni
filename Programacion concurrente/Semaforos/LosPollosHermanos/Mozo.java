package Semaforos.LosPollosHermanos;

public class Mozo implements Runnable {
    private Confiteria confiteria;

    public Mozo(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void run() {
        try {
            while (true) {
                preguntarPedido();
                prepararPedido();
                entregarPedido();
                crearRecetas();
            }
        } catch (InterruptedException e) {
            System.out.println("puts amiguinho");
        }
    }

    public void preguntarPedido() throws InterruptedException {
        confiteria.preguntarPedido();
        System.out.println("Mozo tomó el pedido");
    }

    public void prepararPedido() throws InterruptedException {
        System.out.println("Mozo está preparando el pedido. . .");
        Thread.sleep(1000);
    }

    public void entregarPedido() {
        confiteria.entregarPedido();
    }

    public void crearRecetas() throws InterruptedException {
        System.out.println("Mozo está creando recetas nuevas. . .");
        Thread.sleep(1000);
    }

}
