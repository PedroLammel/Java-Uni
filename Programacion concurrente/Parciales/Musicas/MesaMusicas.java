package Parciales.Musicas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MesaMusicas {
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] condiciones = new Condition[4];
    private int[] musicas = new int[4];

    public MesaMusicas() {
        for (Condition condition : condiciones) {
            condition = lock.newCondition();
        }
    }

    public void ingresarMusica(int musica) {
        lock.lock();
        musicas[musica]++;
        System.out.println("Se ingresó una música de genero " + musica);
        condiciones[musica].signal();
        lock.unlock();
    }

    public void buscarMusica(int musica) {
        lock.lock();
        while (musicas[musica] <= 0) {
            try {
                condiciones[musica].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        musicas[musica]--;
        lock.unlock();
    }

    public void devolver(int genero) {
        lock.lock();
        musicas[genero]++;
        System.out.println("Se devolvió una musica de genero " + genero);
        lock.unlock();
    }
}
