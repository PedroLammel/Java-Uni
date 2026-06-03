public class MiHilo implements Runnable {
    String nombreHilo;

    public MiHilo(String nombre) {
        nombreHilo = nombre;
    }

    public void run() {
        System.out.println("Yipee yahoo");
    }

}
