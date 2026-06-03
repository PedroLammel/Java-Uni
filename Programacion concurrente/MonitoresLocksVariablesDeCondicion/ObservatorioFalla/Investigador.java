package MonitoresLocksVariablesDeCondicion.ObservatorioFalla;

public class Investigador implements Runnable {
    private Observatorio observatorio;

    public Investigador(Observatorio observatorio) {
        this.observatorio = observatorio;
    }

    public void run() {
        ingresarObservatorio();
        investigar();
        salir();
    }

    public void ingresarObservatorio() {
        observatorio.ingresarInvestigador();
    }

    public void investigar() {
        System.out.println(Thread.currentThread().getName() + " está investigando el observatório. . .");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawawawa");
        }
    }

    public void salir() {
        observatorio.salirInvestigador();
    }
}
