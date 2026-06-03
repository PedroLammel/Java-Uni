package SemaforosGenericos.FormacionDeAgua;

public class Recipiente implements Runnable {
    private Atmosfera atmosfera;
    private int aguaMaxima;

    public Recipiente(Atmosfera atmosfera, int aguaMaxima) {
        this.atmosfera = atmosfera;
        this.aguaMaxima = aguaMaxima;
    }

    public void run() {
        atmosfera.pedirAguaLista(aguaMaxima);
        System.out.println("Recipiente está lleno, vaciando");

        // pregunta aqui
    }
}
