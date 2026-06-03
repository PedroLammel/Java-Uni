package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Caja {
    private int pesoActual = 0;
    private int pesoMaximo = 20;

    public Caja() {
    }

    public int getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(int pesoActual) {
        this.pesoActual = pesoActual;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public boolean estaLlena() {
        return pesoActual >= 18;
    }

    public void aumentarCapacidad(int peso) {
        pesoActual += peso;
    }
}
