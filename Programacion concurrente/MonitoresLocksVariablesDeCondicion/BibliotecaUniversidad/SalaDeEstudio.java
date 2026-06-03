package MonitoresLocksVariablesDeCondicion.BibliotecaUniversidad;

public class SalaDeEstudio {
    private int capacidad;
    private int ocupacion = 0;

    public SalaDeEstudio(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void ingresarASala() {
        try {
            while (ocupacion >= capacidad) {
                System.out.println(Thread.currentThread().getName() + " tiene que esperar para poder entrar a la sala");
                this.wait();
            }
            ocupacion++;
        } catch (InterruptedException e) {
            System.out.println("awawawawawa");
        }
        System.out.println(Thread.currentThread().getName() + " empieza a estudiar");

    }

    public synchronized void salir() {

        System.out.println(Thread.currentThread().getName() + " terminó de estudiar");
        ocupacion--;
        this.notify();

    }

}
