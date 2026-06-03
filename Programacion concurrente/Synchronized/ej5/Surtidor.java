package Synchronized.ej5;

public class Surtidor {
    private int combustible;

    public Surtidor() {
        combustible = 300;
    }

    public synchronized int getCombustible() {
        return combustible;
    }

    public synchronized void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public synchronized void retirarCombustible(int cant) throws InterruptedException {
        combustible -= cant;
    }
}
