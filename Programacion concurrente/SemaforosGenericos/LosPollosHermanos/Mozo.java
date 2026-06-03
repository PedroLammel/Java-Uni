package SemaforosGenericos.LosPollosHermanos;

public class Mozo implements Runnable {
    private Comedor comedor;

    public Mozo(Comedor comedor) {
        this.comedor = comedor;
    }

    public void run() {
        while (true) {
            comedor.pedirPedidoBebida();
            System.out.println("Mozo está preparando la bebida. . .");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("awawawawawa");
            }
            comedor.liberarBebidaLista();
        }
    }

}
