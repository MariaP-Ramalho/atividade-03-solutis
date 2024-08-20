import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade43 {
    private static final int TOTAL_VALUES = 10;
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        double[] values = getUserInput();
        double average = calculateAverage(values);

        System.out.printf("A média aritmética dos %d valores é: %.2f%n", TOTAL_VALUES, average);
        SC.close();
    }

    private static double[] getUserInput() {
        double[] values = new double[TOTAL_VALUES];

        System.out.println("Por favor, insira " + TOTAL_VALUES + " valores:");
        for (int i = 0; i < TOTAL_VALUES; i++) {
            values[i] = getValue( i + 1);
        }

        return values;
    }

    private static double getValue(int index) {

        while (true) {
            System.out.print("Valor " + index + ": ");
            try {
                return SC.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
                SC.next();
            }
        }
    }

    private static double calculateAverage(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / TOTAL_VALUES;
    }
}

