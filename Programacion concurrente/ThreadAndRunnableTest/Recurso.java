public class Recurso {
    static void Uso() {
        Thread t = Thread.currentThread();
        System.out.println("en Recurso: Soy " + t.getName());
    }

}
