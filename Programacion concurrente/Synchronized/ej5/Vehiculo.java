package Synchronized.ej5;

public class Vehiculo {
    private int fechaFabricacion;
    protected int combustible;

    public Vehiculo(int fechaFabricacion, int combustible) {
        this.fechaFabricacion = fechaFabricacion;
        this.combustible = combustible;
    }

    public Vehiculo(int fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public int getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(int fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

}
