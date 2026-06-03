import java.util.Random;

public class Corredor implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private String[] ranking;

    public Corredor(String nombre, String[] ranking) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.ranking = ranking;

    }

    private void avance() {
        Random avance = new Random();
        int nuevaDistancia = avance.nextInt(9) + 1;
        distanciaRecorrida += nuevaDistancia;
        System.out.println(this.nombre + " recorrio " + nuevaDistancia + " pasos");
    }

    public void run() {
        boolean ingresado = false;
        int i = 0;
        while (distanciaRecorrida < 100) {
            System.out.println(this.nombre);
            avance();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        synchronized (ranking) {
            while (!ingresado && i < 3) {
                if (ranking[i] == null) {
                    ranking[i] = this.nombre + ": Posicion " + i;
                    ingresado = true;
                }
                i++;
            }
        }
        System.out.println(this.nombre + " terminó la carrera");
    }

    public String[] getRanking() {
        return ranking;
    }
}
