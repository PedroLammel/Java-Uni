package supermercado;

public class Cajero {
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A " +
                "PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL " +
                "TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                "seg");
        for (int i = 0; i < cliente.getCompras().length; i++) {
            this.esperarXsegundos(cliente.getCompras()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
                            1000
                    + "seg");
        }
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE " +
                "PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
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
