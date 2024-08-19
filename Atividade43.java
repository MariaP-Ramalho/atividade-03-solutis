import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade43 {
    private static final int TOTAL_VALUES = 500;

    public static void main(String[] args) {
        double[] values = getUserInput();
        double avarege = calculateAvarege(values);

        System.out.printf("A média aritmética dos %d valores é: %.2f%n", TOTAL_VALUES, avarege);
    }

    private static double[] getUserInput() {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[TOTAL_VALUES];

        System.out.println("Por favor, insira " + TOTAL_VALUES + " valores:");
        for (int i = 0; i < TOTAL_VALUES; i++) {
            values[i] = getValue(sc, i + 1);
        }

        sc.close();
        return values;
    }

    private static double getValue(Scanner sc, int indice) {
        double value = 0.0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Valor " + indice + ": ");
            try {
                value = sc.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
                sc.next();
            }
        }

        return value;
    }

    private static double calculateAvarege(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / TOTAL_VALUES;
    }
}

