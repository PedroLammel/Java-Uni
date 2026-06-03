/************* Autores ***********
Roger Felix Weimberger, Legajo FAI-4526
Luna Sanchez Bacci, Legajo FAI-4720
Luciano Nehuen Arnol Acuña, Legajo FAI-4350
Pedro Lammel, Legajo FAI-4253
*/

package lineales.dinamicas;

public class Cola {
    private Nodo frente;

    private Nodo fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean poner(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento, null);
        if (fin == null) {
            fin = nuevoNodo;
            frente = nuevoNodo;
        } else {
            fin.setEnlace(nuevoNodo);
            fin = fin.getEnlace();
        }
        return true;
    }

    public boolean sacar() {
        boolean exito = false;
        if (frente != null) {
            frente = frente.getEnlace();
            exito = true;
            if (frente == null) {
                fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object elemento = null;
        if (frente != null) {
            elemento = frente.getElemento();
        }
        return elemento;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public void vaciar() {
        frente = null;
        fin = null;
    }

    public Cola clone() {
        Cola clone = new Cola();
        if (frente != null) {
            Nodo auxFrente = frente;
            Nodo nuevoNodo = new Nodo(auxFrente.getElemento(), null);
            auxFrente = auxFrente.getEnlace();
            Nodo auxClone = nuevoNodo;
            clone.frente = nuevoNodo;
            clone.fin = nuevoNodo;
            while (auxFrente != null) {
                auxClone.setEnlace(new Nodo(auxFrente.getElemento(), null));
                auxClone = auxClone.getEnlace();
                if (auxFrente.getEnlace() == null)
                    clone.fin = auxFrente;
                auxFrente = auxFrente.getEnlace();
            }
        }
        return clone;
    }

    public String toString() {
        String s = "[";
        if (frente != null) {
            Nodo auxFrente = frente;
            while (auxFrente != null) {
                s += auxFrente.getElemento();
                auxFrente = auxFrente.getEnlace();
                if (auxFrente != null) {
                    s += ",";
                }
            }
        }
        s += "]";
        return s;
    }
}
