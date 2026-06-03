/************* Autores ***********
Roger Felix Weimberger, Legajo FAI-4526
Luna Sanchez Bacci, Legajo FAI-4720
Luciano Nehuen Arnol Acuña, Legajo FAI-4350
Pedro Lammel, Legajo FAI-4253
*/
package lineales.dinamicas;

public class Pila {
    // Atributo

    private Nodo tope;

    // Constructor

    public Pila() {
        tope = null;
    }

    public boolean apilar(Object elemento) {
        Nodo nodoNuevo = new Nodo(elemento, this.tope);
        this.tope = nodoNuevo;
        return true;
    }

    public boolean desapilar() {
        boolean desapilado = false;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
            desapilado = true;
        }
        return desapilado;
    }

    public Object obtenerTope() {
        Object elemento = null;
        if (this.tope != null) {
            elemento = this.tope.getElemento();
        }
        return elemento;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila clone = new Pila();
        if (!this.esVacia()) {
            Nodo aux = tope;
            clone.tope = new Nodo(aux.getElemento(), null);
            Nodo auxCopia = clone.tope;
            aux = aux.getEnlace();
            while (aux != null) {
                auxCopia.setEnlace(new Nodo(aux.getElemento(), null));
                auxCopia = auxCopia.getEnlace();
                aux = aux.getEnlace();

            }
        }
        return clone;
    }

    public String toString() {
        String s = "[";
        Nodo aux = this.tope;
        while (aux != null) {
            s += aux.getElemento().toString();
            aux = aux.getEnlace();
            if (aux != null)
                s += ",";
        }
        s += "]";
        return s;
    }
}
