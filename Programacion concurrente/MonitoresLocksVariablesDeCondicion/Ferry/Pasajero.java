package MonitoresLocksVariablesDeCondicion.Ferry;

public class Pasajero implements Runnable {
    private Puerto puerto;

    public Pasajero(Puerto puerto) {
        this.puerto = puerto;
    }

    public void run() {
        embarcar();
        desembarcar();
    }

    public void embarcar() {
        puerto.embarcarPasajero();
    }

    public void desembarcar() {
        puerto.desembarcarPasajero();
    }
}
