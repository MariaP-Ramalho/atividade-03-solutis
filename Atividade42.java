import java.util.Arrays;
import java.util.Random;

public class Atividade42 {
    private static final int MIN = 0;
    private static final int MAX = 59;
    private static final int NUM_GRUPOS = 40;
    private static final int TAMANHO_GRUPO = 3;

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Lista de " + NUM_GRUPOS + " grupos de números sorteados de " + MIN + " a " + MAX + ":");

        for (int i = 0; i < NUM_GRUPOS; i++) {
            int[] grupo = new int[TAMANHO_GRUPO];

            for (int j = 0; j < TAMANHO_GRUPO; j++) {
                grupo[j] = random.nextInt(MAX - MIN + 1) + MIN;
            }


            Arrays.sort(grupo);

            System.out.println("Grupo " + (i + 1) + ": " + Arrays.toString(grupo));
        }
    }
}
