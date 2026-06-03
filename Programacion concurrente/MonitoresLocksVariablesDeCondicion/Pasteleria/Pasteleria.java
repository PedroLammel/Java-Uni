package MonitoresLocksVariablesDeCondicion.Pasteleria;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pasteleria {
    private int espacioActual = 0;
    private int espacioLimite = 20;
    private Caja caja;
    private int cajasActuales = 0;
    private int limiteCajas = 20;

    private LinkedList<Pasteles> mostrador = new LinkedList<Pasteles>();
    private ReentrantLock lock = new ReentrantLock(true);

    private Condition empaquetar = lock.newCondition();
    private Condition entregarCaja = lock.newCondition();
    private Condition producir = lock.newCondition();

    public Pasteleria(Caja caja) {
        this.caja = caja;
    }

    public void producirPastel(char tipo) {
        lock.lock();
        try {
            while (espacioActual >= espacioLimite) {
                producir.await();
            }
            espacioActual++;
            mostrador.add(new Pasteles(this, tipo));
            System.out.println(Thread.currentThread().getName() + " produció un pastel");
        } catch (Exception e) {
            // TODO: handle exception
        }
        empaquetar.signalAll();
        lock.unlock();
    }

    public void empaquetarPastel() {
        lock.lock();
        try {
            while (caja.estaLlena() || espacioActual == 0) {
                empaquetar.await();
            }
            System.out.println(Thread.currentThread().getName() + " está empaquetando un pastel");
            caja.aumentarCapacidad(mostrador.getFirst().getPeso());
            mostrador.removeFirst();
            espacioActual--;

        } catch (Exception e) {
            // TODO: handle exception
        }
        producir.signalAll();
        empaquetar.signal();
        entregarCaja.signal();
        lock.unlock();
    }

    public void entregarCaja() {
        lock.lock();
        try {
            while (!caja.estaLlena()) {
                entregarCaja.await();
            }
            cajasActuales++;
            caja = new Caja();
            System.out.println("La caja fue entregada, llenando nueva caja.");
        } catch (Exception e) {
            // TODO: handle exception
        }
        empaquetar.signalAll();
        lock.unlock();
    }

}
