package SemaforosGenericos.LosPollosHermanos;

import java.util.Random;

public class Empleado implements Runnable {
    private Comedor comedor;

    public Empleado(Comedor comedor) {
        this.comedor = comedor;
    }

    public void run() {
        int opcion;
        comedor.pedirEntrada();
        System.out.println(Thread.currentThread().getName() + " entró al comedor.");
        Random random = new Random();
        opcion = random.nextInt(2);
        switch (opcion) {
            case 0:
                pedirBebida();
                break;
            case 1:
                pedirComida();
                break;
            case 2:
                pedirBebida();
                pedirComida();
                break;
            default:
                System.out.println("ERROR");
        }
        System.out.println(Thread.currentThread().getName() + " salió del comedor");
        comedor.liberarEntrada();
    }

    public void pedirBebida() {
        System.out.println(Thread.currentThread().getName() + " está pidiendo una bebida");
        comedor.liberarPedidoBebida();
        comedor.pedirBebidaLista();
        System.out.println(Thread.currentThread().getName() + " está tomando su bebida");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("amsdfnkasndf");
        }
    }

    public void pedirComida() {
        System.out.println(Thread.currentThread().getName() + " está pidiendo su comida");
        comedor.liberarPedidoComida();
        comedor.pedirComidaLista();
        System.out.println(Thread.currentThread().getName() + " está comiendo su comida");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("awawawawawawawawawawawawa");
        }
    }
}
