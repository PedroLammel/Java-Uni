package Parciales.Musicas;

public class Productor implements Runnable {
    public Productor(MesaMusicas mesaM, MesaAlbunes mesaA, int genero) {
        this.mesaM = mesaM;
        this.mesaA = mesaA;
        this.genero = genero;
    }

    private MesaMusicas mesaM;
    private MesaAlbunes mesaA;
    private int genero;

    public void run() {
        while (true) {
            mesaM.buscarMusica(genero);
            if (!mesaA.ingresarMusica(genero + 1)) {
                mesaM.devolver(genero);
            }
        }
    }
}
