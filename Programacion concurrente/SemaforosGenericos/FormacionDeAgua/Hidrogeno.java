package SemaforosGenericos.FormacionDeAgua;

public class Hidrogeno implements Runnable {

    private Atmosfera atmosfera;

    public Hidrogeno(Atmosfera atmosfera) {
        this.atmosfera = atmosfera;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            hListo();
        } catch (InterruptedException e) {
            System.out.println("awawawawawawa");
        }
    }

    public void hListo() {
        atmosfera.pedirHidrogenoActivo();
        System.out.println("Hidrogeno está listo");
        atmosfera.liberarHListo();
        if (atmosfera.pedirOListos()) {
            System.out.println("Hidrógeno es el productor");
            atmosfera.pedirHListo();
            atmosfera.hacerAgua();
            atmosfera.liberarAguaLista();
            atmosfera.liberarProductor();
            System.out.println("Hidrogeno se transformó en agua");
        } else {
            atmosfera.esperarProductor();
            System.out.println("El hidrogeno se transformó en água");
        }
        atmosfera.liberarHidrogenoActivo();

    }
}
