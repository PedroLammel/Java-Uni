package SemaforosGenericos.PiscinaComunitaria;

public class Persona implements Runnable {

    public Piscina pileta;

    public Persona(Piscina pileta) {
        this.pileta = pileta;
    }

    public void run() {
        try {
            pileta.pedirEntrada();
            System.out.println(Thread.currentThread().getName() + " entró a la piscina.");
            Thread.sleep(2000);
            pileta.salir();
            System.out.println(Thread.currentThread().getName() + " salió de la piscina");
        } catch (InterruptedException e) {
            System.out.println("wawawawawawawawa");
        }
    }
}
