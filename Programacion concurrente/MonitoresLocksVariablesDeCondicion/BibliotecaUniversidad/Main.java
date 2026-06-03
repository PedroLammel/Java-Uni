package MonitoresLocksVariablesDeCondicion.BibliotecaUniversidad;

public class Main {
    public static void main(String[] args) {
        SalaDeEstudio salaDeEstudio = new SalaDeEstudio(3);
        Thread[] threads = new Thread[30];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Estudiante(salaDeEstudio), "Estudiante " + (i + 1));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Fin.");
    }
}
