package Parciales.Editorial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Editorial {
    private ReentrantLock lock = new ReentrantLock();
    private Condition traductor = lock.newCondition();
    private Condition lector = lock.newCondition();
    private Lista articulosEsp = new Lista();
    private Lista articulosIng = new Lista();
    private int articulosTraducidos = 0;

    public void aniadirALista(Articulo articulo) {
        lock.lock();
        articulosEsp.insertar(articulo, articulosEsp.longitud() + 1);
        System.out.println("Se agregó un archivo en Español a la lista");
        lector.signalAll();
        traductor.signalAll();
        lock.unlock();
    }

    public void elegirArticulo(char idioma, int i) {
        lock.lock();
        try {
            if (idioma == 'E') {
                while (articulosEsp.recuperar(i) == null) {
                    lector.await();
                }
            } else {
                while (articulosIng.recuperar(i) == null) {
                    lector.await();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("bweh");
        } finally {
            lock.unlock();
        }
    }

    public Articulo elegirParaTraduccion() {
        Articulo articulo = null;
        try {
            lock.lock();
            while (articulosTraducidos >= articulosEsp.longitud()) {
                traductor.await();
            }
            articulosTraducidos++;
            articulo = (Articulo) articulosEsp.recuperar(articulosTraducidos);
        } catch (InterruptedException e) {
            System.out.println("asodjfashdf");
        } finally {
            lock.unlock();
        }
        return articulo;
    }

    public void aniadirTraduccion(Articulo articulo) {
        lock.lock();
        articulosIng.insertar(articulo, articulosIng.longitud() + 1);
        System.out.println("Se agregó un archivo en Inglés a la lista");
        lector.signalAll();
        lock.unlock();
    }
}
