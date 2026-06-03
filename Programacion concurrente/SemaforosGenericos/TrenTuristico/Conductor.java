package SemaforosGenericos.TrenTuristico;

public class Conductor implements Runnable {
    private Tren tren;

    public Conductor(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        try {
            while (true) {
                esperarTodos();
                viajar();
                avisarLlegada();
                volverAlInicio();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void esperarTodos() {
        tren.esperarSubida();
        System.out.println("Conductor termino de esperar");
    }

    public void viajar() {
        System.out.println("Conductor está viajando");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("awawawa");
        }
    }

    public void avisarLlegada() {
        tren.llegar();
    }

    public void volverAlInicio() {
        tren.volverAlInicio();
        System.out.println("El conductor está manejando de vuelta al início");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("asdnfjasnd");
        }
        liberarEntrada();
    }

    public void liberarEntrada() {

        System.out.println("Viaje terminado! Abriendo las puertas. . .");
        tren.abrirPuertas();
    }
}
