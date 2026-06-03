package SemaforosGenericos.LosPollosHermanos;

public class Cocinero implements Runnable {
    private Comedor comedor;

    public Cocinero(Comedor comedor) {
        this.comedor = comedor;
    }

    public void run() {
        while (true) {
            comedor.pedirPedidoComida();
            System.out.println("Cocinero está preparando la comida. . .");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("awawawawawa");
            }
            System.out.println("Cocinero terminó la comida");
            comedor.liberarComidaLista();
        }
    }
}
