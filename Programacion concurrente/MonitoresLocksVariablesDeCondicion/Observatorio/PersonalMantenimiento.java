package MonitoresLocksVariablesDeCondicion.Observatorio;

public class PersonalMantenimiento implements Runnable {
    private Observatorio observatorio;

    public PersonalMantenimiento(Observatorio observatorio) {
        this.observatorio = observatorio;
    }

    public void run() {
        ingresarObservatorio();
        manutencion();
        salir();
    }

    public void ingresarObservatorio() {
        observatorio.ingresarMantenimiento();
    }

    public void manutencion() {
        System.out.println(Thread.currentThread().getName() + " está haciendo manutención en el observatório. . .");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawa");
        }
    }

    public void salir() {
        observatorio.salirMantenimiento();
    }
}
