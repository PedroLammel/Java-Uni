package MonitoresLocksVariablesDeCondicion.ObservatorioFalla;

public class Main {
    public static void main(String[] args) {
        Observatorio observatorio = new Observatorio(50);
        int j = 1;
        Thread[] threads = new Thread[120];
        for (int i = 90; i < 95; i++) {
            threads[i] = new Thread(new Visitante(observatorio, true), "Visitante " + j);
            j++;
        }
        for (int i = 0; i < 90; i++) {
            threads[i] = new Thread(new Visitante(observatorio, false), "Visitante " + j);
            j++;
        }
        j = 1;
        for (int i = 95; i < 115; i++) {
            threads[i] = new Thread(new PersonalMantenimiento(observatorio), "Manutención " + j);
            j++;
        }
        j = 1;
        for (int i = 115; i < threads.length; i++) {
            threads[i] = new Thread(new Investigador(observatorio), "Investigador " + j);
            j++;
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
        System.out.println("Fin");
    }
}
