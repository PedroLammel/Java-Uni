package supermercado;

public class Cliente {
    private String nombre;
    private int[] compras;

    public Cliente(String nombre, int[] compras) {
        this.nombre = nombre;
        this.compras = compras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCompras() {
        return compras;
    }

    public void setCompras(int[] compras) {
        this.compras = compras;
    }

}
