package MonitoresLocksVariablesDeCondicion.Ferry;

public class Automovil implements Runnable {
    private int espacio;
    private Puerto puerto;

    public Automovil(int espacio, Puerto puerto) {
        this.espacio = espacio;
        this.puerto = puerto;
    }

    public void run() {
        embarcar();
        desembarcar();
    }

    public void embarcar() {
        puerto.embarcarAutomovil(espacio);
    }

    public void desembarcar() {
        puerto.desembarcarAutomovil(espacio);
    }
}
