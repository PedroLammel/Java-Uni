package Parciales.Editorial;

public class Lector implements Runnable {
    private Editorial editorial;
    private int libroALeer = 1;
    private char idioma;

    public Lector(Editorial editorial, char idioma) {
        this.editorial = editorial;
        this.idioma = idioma;
    }

    public void run() {
        while (true) {
            editorial.elegirArticulo(idioma, libroALeer);
            libroALeer++;
            leer();
        }
    }

    public void leer() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " terminó de leer");
        } catch (Exception e) {
            System.out.println("bljnjknqwejkrnoqwnejqqwerjkjqwnerer");
        }
    }
}
