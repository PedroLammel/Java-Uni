package MonitoresLocksVariablesDeCondicion.BibliotecaUniversidad;

public class Estudiante implements Runnable {
    private SalaDeEstudio salaDeEstudio;

    public Estudiante(SalaDeEstudio salaDeEstudio) {
        this.salaDeEstudio = salaDeEstudio;
    }

    public void run() {
        ingresarASala();
        estudiar();
        salirDeSala();
    }

    public void ingresarASala() {
        salaDeEstudio.ingresarASala();
    }

    public void estudiar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("aadaknajog hjq");
        }
    }

    public void salirDeSala() {
        salaDeEstudio.salir();
    }
}
