package MonitoresLocksVariablesDeCondicion.ObservatorioFalla;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private ReentrantLock puerta = new ReentrantLock(true);
    Condition visitantes = puerta.newCondition();
    Condition mantenimiento = puerta.newCondition();
    Condition investigador = puerta.newCondition();

    private int capacidad;
    private int ocupacion = 0;
    private int cantVisitantes = 0;
    private int cantMantenimiento = 0;
    private boolean hayInvestigador;

    public Observatorio(int capacidad) {
        this.capacidad = capacidad;
    }

    public void ingresarVisitantes(boolean sillaRuedas) {
        puerta.lock();
        try {
            if (sillaRuedas) {
                while (ocupacion >= 30 || hayInvestigador || cantMantenimiento != 0) {
                    visitantes.await();
                    capacidad = 30;
                    System.out.println(Thread.currentThread().getName() + " entró a visitar (silla de ruedas)");
                }
            } else {
                while (ocupacion >= capacidad || hayInvestigador || cantMantenimiento != 0) {
                    visitantes.await();
                    System.out.println(Thread.currentThread().getName() + " entró a visitar");
                }
                ocupacion++;
            }
        } catch (InterruptedException e) {
            System.out.println("awawa");
        }
        puerta.unlock();
    }

    public void ingresarMantenimiento() {
        puerta.lock();
        try {
            while (ocupacion >= capacidad || hayInvestigador || cantVisitantes != 0) {
                mantenimiento.await();
            }
            ocupacion++;
            System.out.println(Thread.currentThread().getName() + " entró a hacer reparos");
        } catch (InterruptedException e) {
            System.out.println("awawa");
        }
        puerta.unlock();
    }

    public void ingresarInvestigador() {
        puerta.lock();
        try {
            while (ocupacion != 0) {
                mantenimiento.await();
            }
            ocupacion++;
            hayInvestigador = true;
            System.out.println(Thread.currentThread().getName() + " entró a investigar");
        }

        catch (InterruptedException e) {
            System.out.println("awawawawawawawawaw");
        }
        puerta.unlock();
    }

    public void salirVisitante(boolean sillaRuedas) {
        puerta.lock();
        ocupacion--;
        cantVisitantes--;
        if (sillaRuedas) {
            capacidad = 50;
        }
        investigador.signalAll();
        mantenimiento.signalAll();
        visitantes.signal();
        System.out.println(Thread.currentThread().getName() + " salió del observatório");
        puerta.unlock();
    }

    public void salirMantenimiento() {
        puerta.lock();
        ocupacion--;
        cantMantenimiento--;
        visitantes.signal();
        investigador.signalAll();
        mantenimiento.signalAll();
        System.out.println(Thread.currentThread().getName() + " salió del observatório");
        puerta.unlock();
    }

    public void salirInvestigador() {
        puerta.lock();
        hayInvestigador = false;
        System.out.println(Thread.currentThread().getName() + " salió del observatório");
        visitantes.signal();
        investigador.signalAll();
        mantenimiento.signalAll();
        puerta.unlock();
    }
}
