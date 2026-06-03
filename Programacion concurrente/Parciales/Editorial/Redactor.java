package Parciales.Editorial;

public class Redactor implements Runnable {
    private Editorial editorial;
    private int cantRedactados = 1;

    public Redactor(Editorial editorial) {
        this.editorial = editorial;
    }

    public void run() {
        while (true) {
            editorial.aniadirALista(redactar());
        }
    }

    public Articulo redactar() {
        Articulo articulo = null;
        try {
            Thread.sleep(3000);
            System.out.println("Redactor terminó un articulo");
            articulo = new Articulo("Articulo " + cantRedactados, 'E');
            cantRedactados++;
        } catch (InterruptedException e) {
            System.out.println("bweh...");
        }
        return articulo;
    }
}
