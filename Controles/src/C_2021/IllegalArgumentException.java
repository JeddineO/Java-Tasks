package C_2021;

public class IllegalArgumentException extends Exception {

    public IllegalArgumentException(double note) {
        super("La valeur de la note " + note + " doit �tre dans l'intervalle 0-20");
    }

}
