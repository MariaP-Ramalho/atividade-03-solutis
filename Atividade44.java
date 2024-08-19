import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade44 {

    private static final String ERROR_MESSAGE = "Entrada inválida! Por favor, insira um número válido.";

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        int valueAmount = getValueAmount();
        double[] values = getValueInput(valueAmount);
        double average = calculateAverage(values);

        System.out.printf("A média aritmética dos %d valores é: %.2f%n", valueAmount, average);

        SC.close();
    }


    private static int getValueAmount() {

        while (true) {
            System.out.print("Por favor, insira a quantidade de valores que deseja adicionar: ");
            try {
                int value = SC.nextInt();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println(ERROR_MESSAGE);
                }
            } catch (InputMismatchException e) {
                System.out.println(ERROR_MESSAGE);
                SC.next();
            }
        }
    }


    private static double[] getValueInput(int valueAmount) {

        double[] values = new double[valueAmount];

        System.out.println("Por favor, insira " + valueAmount + " valores:");
        for (int i = 0; i < valueAmount; i++) {
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
                System.out.println(ERROR_MESSAGE);
                SC.next();
            }
        }
    }

    private static double calculateAverage(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}

