package SemaforosGenericos.TrenTuristico;

import java.util.concurrent.Semaphore;

public class Tren {
    private int capacidad;
    private int capacidadActual;
    private Semaphore entrada;
    private Semaphore viaje = new Semaphore(0);
    private Semaphore modificarCapacidad = new Semaphore(1);
    private Semaphore salida = new Semaphore(0);

    private Semaphore nuevoViaje = new Semaphore(0);

    public Tren(int capacidad) {
        this.capacidad = capacidad;
        capacidadActual = capacidad;
        entrada = new Semaphore(capacidad);
    }

    public void ingresarTren() {
        try {
            entrada.acquire();
            modificarCapacidad.acquire();
            capacidadActual--;
            System.out.println("Pasajero Ingresó al tren");
            if (capacidadActual == 0) {
                liberarViaje();
            }
            modificarCapacidad.release();
        } catch (InterruptedException e) {
            System.out.println("kbbskjdbfjkasn");
        }
    }

    public void liberarViaje() {
        viaje.release();
        System.out.println("Todos los pasajeros subieron al Tren");
    }

    public void esperarSubida() {
        try {
            viaje.acquire();
            System.out.println("El tren se empezó a mover");
        } catch (InterruptedException e) {
            System.out.println("Eu te odeio");
        }
    }

    public void llegar() {
        System.out.println("El tren llegó a su destino");
        salida.release(capacidad);
    }

    public void volverAlInicio() {
        try {
            nuevoViaje.acquire();
        } catch (InterruptedException e) {
            System.out.println("ndjasdklnasjld");
        }
    }

    public void salir() {
        try {
            salida.acquire();
            System.out.println("Pasajero salió del tren");
            modificarCapacidad.acquire();
            capacidadActual++;
            if (capacidadActual == capacidad) {
                nuevoViaje.release();
                System.out.println("El ultimo pasajero salió del tren");
            }
            modificarCapacidad.release();
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawa");
        }
    }

    public void abrirPuertas() {
        entrada.release(capacidad);
    }
}
