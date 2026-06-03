public class Carrera {
    public static void main(String[] args) {
        String[] ranking = new String[3];
        Corredor[] corredores = new Corredor[3];
        Thread[] threads = new Thread[3];
        corredores[0] = new Corredor("Martin", ranking);
        corredores[1] = new Corredor("Rocio", ranking);
        corredores[2] = new Corredor("Marcos", ranking);
        for (int i = 0; i < corredores.length; i++) {
            threads[i] = new Thread(corredores[i]);
        }
        for (int i = 0; i < corredores.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 3; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        imprimirRanking(ranking);
    }

    public static void imprimirRanking(String[] ranking) {
        for (int i = 0; i < ranking.length; i++) {
            System.out.println(ranking[i]);
        }
    }
}
