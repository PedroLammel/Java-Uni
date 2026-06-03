package Parciales.Editorial;

public class Articulo {
    private String nombre;
    private char idioma;

    public Articulo(String nombre, char idioma) {
        this.nombre = nombre;
        this.idioma = idioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getIdioma() {
        return idioma;
    }

    public void setIdioma(char idioma) {
        this.idioma = idioma;
    }
}
