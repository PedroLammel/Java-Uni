package Synchronized.ej4;

public class ParqueTematico {
    private Area[] atracciones;

    public ParqueTematico() {
        atracciones = new Area[5];
        rellenarAtracciones();
    }

    private void rellenarAtracciones() {
        atracciones[0] = new Area("Rueda Gigante");
        atracciones[1] = new Area("Montaña Rusa");
        atracciones[2] = new Area("Tazas");
        atracciones[3] = new Area("Heladeria");
        atracciones[4] = new Area("Casa Embrujada");
    }

    public Area[] getAtracciones() {
        return atracciones;
    }
}
