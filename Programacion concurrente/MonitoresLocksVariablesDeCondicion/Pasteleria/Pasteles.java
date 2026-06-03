package MonitoresLocksVariablesDeCondicion.Pasteleria;

public class Pasteles {
    private Pasteleria pasteleria;
    private char tipo;
    private int peso;

    public Pasteles(Pasteleria pasteleria, char tipo) {
        this.pasteleria = pasteleria;
        this.tipo = tipo;
        designarPeso();
    }

    private void designarPeso() {
        switch (this.tipo) {
            case 'A':
                this.peso = 1;
                break;
            case 'B':
                this.peso = 2;
                break;
            case 'C':
                this.peso = 3;
                break;
            default:
                this.peso = 1;

        }
    }

    public Pasteleria getPasteleria() {
        return pasteleria;
    }

    public void setPasteleria(Pasteleria pasteleria) {
        this.pasteleria = pasteleria;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
