/************* Autores ***********
Roger Felix Weimberger, Legajo FAI-4526
Luna Sanchez Bacci, Legajo FAI-4720
Luciano Nehuen Arnol Acuña, Legajo FAI-4350
Pedro Lammel, Legajo FAI-4253
*/
package lineales.dinamicas;

public class Nodo {
    // Atributos
    private Object elemento;
    private Nodo enlace;

    // Constructor
    public Nodo(Object miElemento, Nodo miEnlace) {
        elemento = miElemento;
        enlace = miEnlace;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object miElemento) {
        elemento = miElemento;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo miEnlace) {
        enlace = miEnlace;
    }
}
