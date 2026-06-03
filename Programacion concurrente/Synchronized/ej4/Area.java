package Synchronized.ej4;

import java.time.LocalDateTime;

public class Area {
    private String nombre;

    public Area(String nombre) {
        this.nombre = nombre;
    }

    public synchronized String reservar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Woops");
        }
        return "reserva de: " + nombre + ". " + LocalDateTime.now();
    }
}
