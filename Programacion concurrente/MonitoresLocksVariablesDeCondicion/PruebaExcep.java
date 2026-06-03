import MenorDeEdadException;
import NumeroEquivocadoException;

package MonitoresLocksVariablesDeCondicion;

public class PruebaExcep {

    public static void main(String[] args) {
        try {
            verificarMenorDeEdad(2);
        } catch (MenorDeEdadException e) {
            System.out.println("Usuário menor de edad");
        }
    }

    public static void verificarMenorDeEdad(int edad) throws MenorDeEdadException {
        if (edad < 18) {
            throw new MenorDeEdadException("Usuário menor de edad");
        }

    }

    public static void numeroRuleta(int numeroAdivinado) throws NumeroEquivocadoException {
        double resultado = Math.random();
    }
}
