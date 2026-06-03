package MonitoresLocksVariablesDeCondicion.Ferry;

public class Ferry implements Runnable {
    private Puerto puerto;

    public Ferry(Puerto puerto) {
        this.puerto = puerto;
    }

    public void run() {
        while (true) {
            embarcarPasajeros();
            System.out.println("Paseando");
            viajar();
            desembarcarPasajeros();
            System.out.println("Volviendo");
            viajar();
        }
    }

    public void embarcarPasajeros() {
        System.out.println("El ferry está listo para recibir pasajeros");
        puerto.habilitarEmbarque();
        puerto.cerrarPuertas();
    }

    public void viajar() {
        try {
            System.out.println("El ferry está viajando");
            Thread.sleep(1500);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void desembarcarPasajeros() {
        System.out.println("El ferry está listo para desembarcar");
        puerto.habilitarDesembarque();
        puerto.terminarDesembarque();
    }

}
