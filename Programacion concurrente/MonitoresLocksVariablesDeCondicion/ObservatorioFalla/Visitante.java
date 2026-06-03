package MonitoresLocksVariablesDeCondicion.ObservatorioFalla;

public class Visitante implements Runnable {
    private Observatorio observatorio;
    private boolean sillaDeRuedas;

    public Visitante(Observatorio observatorio, boolean sillaDeRuedas) {
        this.observatorio = observatorio;
        this.sillaDeRuedas = sillaDeRuedas;
    }

    public void run() {
        ingresarObservatorio();
        visitar();
        salir();
    }

    public void ingresarObservatorio() {
        observatorio.ingresarVisitantes(sillaDeRuedas);
    }

    public void visitar() {
        try {
            System.out.println(Thread.currentThread().getName() + " está mirando las estrellas. . .");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawawawawawa");
        }
    }

    public void salir() {
        observatorio.salirVisitante(sillaDeRuedas);
    }
}
