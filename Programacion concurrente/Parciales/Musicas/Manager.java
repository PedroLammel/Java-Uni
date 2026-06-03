package Parciales.Musicas;

public class Manager implements Runnable {
    private MesaAlbunes mesaAlbunes;

    public void run() {
        while (true) {
            mesaAlbunes.empezarProduccion("ababa", 9);
            mesaAlbunes.finalizarProduccion();
            producirAlbum();
        }
    }
}
