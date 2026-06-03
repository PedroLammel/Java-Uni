package SemaforosGenericos.FormacionDeAgua;

public class Oxigeno implements Runnable {

    private Atmosfera atmosfera;

    public Oxigeno(Atmosfera atmosfera) {
        this.atmosfera = atmosfera;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            oListo();
        } catch (InterruptedException e) {
            System.out.println("awawawawawawa");
        }
    }

    public void oListo() {
        atmosfera.pedirOxigenoActivo();
        System.out.println("Oxigeno está listo");
        atmosfera.liberarOListo();
        if (atmosfera.pedirOListos()) {
            System.out.println("Oxigeno es el productor");
            atmosfera.pedirHListo();
            atmosfera.hacerAgua();
            atmosfera.liberarAguaLista();
            atmosfera.liberarProductor();
            System.out.println("El oxígeno se transformo en água");
        } else {
            atmosfera.esperarProductor();
            System.out.println("El oxígeno se transformo en água");
        }
        atmosfera.liberarOxigenoActivo();
    }
}
