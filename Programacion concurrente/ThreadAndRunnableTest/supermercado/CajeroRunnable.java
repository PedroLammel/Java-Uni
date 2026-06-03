package supermercado;

public class CajeroRunnable implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public CajeroRunnable(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public void run() {
        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCompras().length; i++) {
            this.esperarXsegundos(cliente.getCompras()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "del cliente " + this.cliente.getNombre() + "->Tiempo: " +
                    (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");
        }
        System.out.println("El cajero" + this.nombre + "HA TERMINADO DE PROCESAR" +
                this.cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 +
                "seg");
    }

    public void esperarXsegundos(int tiempo) {
        try {
            Thread.sleep(tiempo * 1000);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
        ;
    }

}
