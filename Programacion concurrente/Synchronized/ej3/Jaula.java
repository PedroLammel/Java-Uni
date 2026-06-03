package Synchronized.ej3;

public class Jaula {
    private Plato plato;
    private Rueda rueda;
    private Hamaca hamaca;

    public Jaula() {
        plato = new Plato();
        rueda = new Rueda();
        hamaca = new Hamaca();
    }

    public void comer(String yipee) {
        plato.comer(yipee);
    }

    public void correr(String yipee) {
        rueda.correr(yipee);
    }

    public void dormir(String yipee) {
        hamaca.dormir(yipee);
    }
}
