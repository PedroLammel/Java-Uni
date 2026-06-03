/************* Autores ***********
Roger Felix Weimberger, Legajo FAI-4526
Luna Sanchez Bacci, Legajo FAI-4720
Luciano Nehuen Arnol Acuña, Legajo FAI-4350
Pedro Lammel, Legajo FAI-4253
*/
package lineales.estaticas;

public class Cola {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int frente;
    private int fin;

    public Cola() {
        this.arreglo = new Object[Cola.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elemento) {
        boolean colocado = false;
        if ((this.fin + 1) % Cola.TAMANIO != this.frente) {
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % Cola.TAMANIO;
            colocado = true;
        }
        return colocado;
    }

    public boolean sacar() {
        boolean sacado = false;
        if (this.fin != this.frente) {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % Cola.TAMANIO;
            sacado = true;
        }
        return sacado;
    }

    public Object obtenerFrente() {
        Object elemento = null;
        if (this.fin != this.frente) {
            elemento = this.arreglo[this.frente];
        }
        return elemento;
    }

    public boolean esVacia() {
        return this.fin == this.frente;
    }

    public void vaciar() {
        while (!(this.esVacia())) {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % Cola.TAMANIO;
        }
        frente = 0;
        fin = 0;
    }

    public Cola clone() {
        Cola clone = new Cola();
        int i = this.frente;
        clone.frente = this.frente;
        clone.fin = this.fin;
        while (i != fin) {
            clone.arreglo[i] = this.arreglo[i];
            i = (i + 1) % Cola.TAMANIO;
        }
        return clone;
    }

    public String toString() {
        int auxFrente = frente;
        String s = " ";
        if (frente == fin) {
            s = "[]";
        } else {
            s = "[";
            while (auxFrente != fin) {
                s += this.arreglo[auxFrente].toString();
                auxFrente = (auxFrente + 1) % Cola.TAMANIO;
                if (auxFrente != fin) {
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }
}
