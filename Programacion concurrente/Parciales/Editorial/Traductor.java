package Parciales.Editorial;

public class Traductor implements Runnable {
    private Editorial editorial;

    public Traductor(Editorial editorial) {
        this.editorial = editorial;
    }

    public void run() {
        while (true) {
            editorial.aniadirTraduccion(traducir(editorial.elegirParaTraduccion()));
        }
    }

    public Articulo traducir(Articulo articulo) {
        Articulo articuloIngles = null;
        try {
            Thread.sleep(6500);
            System.out.println(Thread.currentThread().getName() + " terminó de traduzir un artículo");
            articuloIngles = new Articulo(articulo.getNombre(), 'I');
        } catch (InterruptedException e) {
            System.out.println("Bweh. . .");
        }
        return articuloIngles;
    }
}
