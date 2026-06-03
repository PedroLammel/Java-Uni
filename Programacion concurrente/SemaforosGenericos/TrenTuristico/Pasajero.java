package SemaforosGenericos.TrenTuristico;

public class Pasajero implements Runnable {

    private Tren tren;

    public Pasajero(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        entrar();
        salir();
    }

    public void entrar() {
        tren.ingresarTren();
    }

    public void salir() {
        tren.salir();
    }
}
