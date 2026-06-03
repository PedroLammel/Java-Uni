public class Cliente extends Thread {
    public void run() {
        System.out.println("soy " + Thread.currentThread().getName());
        Recurso.Uso();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        ;
    };
}
