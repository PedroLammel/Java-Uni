package MonitoresLocksVariablesDeCondicion.Ferry;

public class Puerto {
    private int capacidad;
    private int ocupacion = 0;
    private boolean embarcando = false;
    private boolean desembarcando = false;

    public Puerto(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void embarcarPasajero() {
        try {
            while (ocupacion >= capacidad || !embarcando) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + " embarcó");
            ocupacion++;
        } catch (InterruptedException e) {
            System.out.println("bweh");
        }
        this.notifyAll();
    }

    public synchronized void habilitarEmbarque() {
        embarcando = true;
        this.notifyAll();
    }

    public synchronized void cerrarPuertas() {
        try {
            while (ocupacion <= capacidad - 5) {
                this.wait();
            }
            embarcando = false;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void habilitarDesembarque() {
        try {
            desembarcando = true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        this.notifyAll();
    }

    public synchronized void terminarDesembarque() {
        try {
            while (ocupacion != 0) {
                this.wait();
            }
            desembarcando = false;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized void desembarcarPasajero() {
        try {
            while (!desembarcando) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + " desembarcó");
            ocupacion--;
        } catch (InterruptedException e) {
            System.out.println("bweh");
        }
        this.notifyAll();
    }

    public synchronized void embarcarAutomovil(int espacio) {
        try {
            while (ocupacion + espacio > capacidad || !embarcando) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + " embarcó");
            ocupacion += espacio;
        } catch (Exception e) {
            System.out.println("bweh");
        }
        this.notifyAll();
    }

    public synchronized void desembarcarAutomovil(int espacio) {
        try {
            while (!desembarcando) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + " desembarcó");
            ocupacion -= espacio;
        } catch (Exception e) {
            System.out.println("bweh");
        }
        this.notifyAll();
    }
}
