package Parciales.Musicas;

import java.util.Random;

public class BobDylan implements Runnable {
    private MesaMusicas mesa;

    private Random random = new Random();

    public void run() {
        while (true) {
            mesa.ingresarMusica(componer());
        }
    }

    public int componer() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (random.nextInt(3));
    }
}
