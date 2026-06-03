package MonitoresLocksVariablesDeCondicion.Observatorio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition visitantes = lock.newCondition();
    private Condition mantenimiento = lock.newCondition();
    private Condition investigacion = lock.newCondition();
    private int capacidad = 50;
    private int ocupacion = 0;
    private int cantVisitantes = 0;
    private int cantSillaRuedas = 0;
    private int historicoVisitantes = 0;
    private int cantMantenimiento = 0;
    private boolean hayInvestigador = false;

    public void ingresarVisitantes(boolean silla) {
        lock.lock();
        try {
            if (silla) {
                while (historicoVisitantes >= 80 || ocupacion >= 30 || cantMantenimiento > 0 || hayInvestigador) {
                    visitantes.await();
                }
                capacidad = 30;
                historicoVisitantes++;
                cantVisitantes++;
                cantSillaRuedas++;
                System.out.println(Thread.currentThread().getName() + " entró al observatorio (silla de ruedas)");
            } else {
                while (historicoVisitantes >= 80 || ocupacion >= capacidad || cantMantenimiento > 0
                        || hayInvestigador) {
                    visitantes.await();
                }
                historicoVisitantes++;
                cantVisitantes++;
                System.out.println(Thread.currentThread().getName() + " entró al observatorio");
            }
        } catch (Exception e) {
            System.out.println("awawawawawawa");
        }
        lock.unlock();
    }

    public void salirVisitantes(boolean silla) {
        lock.lock();
        ocupacion--;
        cantVisitantes--;
        if (silla) {
            cantSillaRuedas--;
            if (cantSillaRuedas == 0) {
                capacidad = 50;
            }
        }
        System.out.println(Thread.currentThread().getName() + " salió del observatorio");
        if (cantVisitantes == 0) {
            visitantes.signal();
        } else {
            mantenimiento.signalAll();
            investigacion.signalAll();
        }
        lock.unlock();
    }

    public void ingresarMantenimiento() {
        lock.lock();
        try {
            while (cantVisitantes > 0 || hayInvestigador) {
                mantenimiento.await();
            }
            cantMantenimiento++;
            System.out.println(Thread.currentThread().getName() + " entró al observatorio");
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawawa");
        }
        lock.unlock();
    }

    public void salirMantenimiento() {
        lock.lock();
        cantMantenimiento--;
        if (historicoVisitantes > 0) {
            historicoVisitantes = 0;
        }
        System.out.println(Thread.currentThread().getName() + " salió del observatorio");
        mantenimiento.signalAll();
        investigacion.signalAll();
        visitantes.signalAll();
        lock.unlock();
    }

    public void ingresarInvestigador() {
        lock.lock();
        try {
            while (cantMantenimiento > 0 || cantVisitantes > 0 || hayInvestigador) {
                investigacion.await();
            }
            hayInvestigador = true;
            System.out.println(Thread.currentThread().getName() + " entró al observatorio");
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawa");
        }
        lock.unlock();
    }

    public void salirInvestigador() {
        lock.lock();
        hayInvestigador = false;
        if (historicoVisitantes > 0) {
            historicoVisitantes = 0;
        }
        System.out.println(Thread.currentThread().getName() + " salió del observatorio");
        mantenimiento.signalAll();
        investigacion.signalAll();
        visitantes.signalAll();
        lock.unlock();
    }
}
