/************* Autores ***********
Roger Felix Weimberger, Legajo FAI-4526
Luna Sanchez Bacci, Legajo FAI-4720
Luciano Nehuen Arnol Acuña, Legajo FAI-4350
Pedro Lammel, Legajo FAI-4253
*/
package lineales.estaticas;

public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 20;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElemento) {
        boolean apilado = false;
        if (tope < TAMANIO - 1) {
            this.tope++;
            arreglo[tope] = nuevoElemento;
            apilado = true;
        }
        return apilado;
    }

    public boolean desapilar() {
        boolean desapilado = false;
        if (tope > -1) {
            arreglo[tope] = null;
            tope--;
            desapilado = true;
        }
        return desapilado;
    }

    public Object obtenerTope() {
        Object elemento = null;
        if (tope > -1) {
            elemento = arreglo[tope];
        }
        return elemento;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public void vaciar() {
        while (tope > -1) {
            this.arreglo[tope] = null;
            tope--;
        }
    }

    public Pila clone() {
        Pila pilaCopia = new Pila();
        int i = 0;
        while (i <= tope) {
            pilaCopia.arreglo[i] = this.arreglo[i];
            i++;
        }
        pilaCopia.tope = this.tope;
        return pilaCopia;
    }

    public String toString() {
        String pilaString = "[";
        int i = this.tope;
        while (i >= 0) {
            pilaString += arreglo[i].toString();
            if (i != 0) {
                pilaString += ",";
            }
            i--;
        }
        pilaString += "]";
        return pilaString;

    }
}