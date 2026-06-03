package Synchronized.ej5;

public class Auto extends Vehiculo implements Runnable {
    private String patente;
    private String modelo;
    private String marca;
    private int km;
    private Surtidor surtidor;

    public Auto(int combustible, int fechaFabricacion, String patente, String modelo, String marca, int km,
            Surtidor surtidor) {
        super(fechaFabricacion, combustible);
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.km = km;
        this.surtidor = surtidor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void agregarCombustible(int cant) {
        combustible += cant;
    }

    public void run() {
        try {
            boolean continua = true;
            while (continua) {
                System.out.println(modelo + " andando " + km + "km");
                Thread.sleep(km * 10);
                this.combustible -= 10;
                if (combustible <= 0) {
                    continua = cargarCombustible(30);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("blebleblebleble");
        }
    }

    public boolean cargarCombustible(int cantidad) throws InterruptedException {
        boolean pudoCargar = false;
        if (surtidor.getCombustible() > 0) {
            System.out.println(
                    Thread.currentThread().getName() + " está cargando " + cantidad + " litros de combustible");
            Thread.sleep(1000);
            surtidor.retirarCombustible(cantidad);
            agregarCombustible(cantidad);
            System.out.println("Retiro realizado");
            System.out.println("Combustible restante en el surtidor: " + surtidor.getCombustible());
            System.out.println("Combustible en el auto: " + this.getCombustible());
            pudoCargar = true;
        } else {
            System.out.println("No hay más combustible en el surtidor");
        }
        return pudoCargar;
    }
}
