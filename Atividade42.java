import java.util.Arrays;
import java.util.Random;

public class Atividade42 {
    private static final int MIN = 0;
    private static final int MAX = 59;
    private static final int NUM_GROUPS = 40;
    private static final int SIZE_GROUPS = 3;

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Lista de " + NUM_GROUPS + " grupos de números sorteados de " + MIN + " a " + MAX + ":");

        for (int i = 0; i < NUM_GROUPS; i++) {
            int[] group = new int[SIZE_GROUPS];

            for (int j = 0; j < SIZE_GROUPS; j++) {
                group[j] = random.nextInt(MAX - MIN + 1) + MIN;
            }


            Arrays.sort(group);

            System.out.println("Grupo " + (i + 1) + ": " + Arrays.toString(group));
        }
    }
}
