package Parciales.Musicas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MesaAlbunes {
    private String nombre;
    private int duracionMaxima;
    private boolean enProduccion = false;
    private boolean concluido = false;
    private ReentrantLock lock = new ReentrantLock();
    private Condition productor = lock.newCondition();
    private Condition manager = lock.newCondition();

    private int duracionActual;

    public boolean ingresarMusica(int duracion) {
        lock.lock();
        boolean pudoIngresar = false;
        while (enProduccion = false) {
            try {
                productor.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (duracionActual + duracion < duracionMaxima) {
            duracionActual += duracion;
        } else {
            enProduccion = false;
            concluido = true;
        }

        lock.unlock();
        return pudoIngresar;
    }

    public void empezarProduccion(String nombre, int duracion) {
        lock.lock();
        if (!enProduccion) {
            concluido = false;
            enProduccion = true;
            this.nombre = nombre;
            this.duracionMaxima = duracion;
            duracionActual = 0;
        }
        lock.unlock();
    }

    public void finalizarProduccion() {
        lock.lock();
        while (!concluido) {
            try {
                manager.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

}
