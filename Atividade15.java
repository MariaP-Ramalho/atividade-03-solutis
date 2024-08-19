
import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade15 {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int day = getInput("Digite o dia do seu aniversário: ", 1, 31);
        int month = getInput("Digite o mês do seu aniversário: ", 1, 12);

        validateAndPrintDate(day, month);

        SC.close();

    }

    private static int getInput(String prompt, int minValue, int maxValue) {
        int input = -1;
        while (input < minValue || input > maxValue) {
            System.out.print(prompt);
            try {
                input = SC.nextInt();
                if (input < minValue || input > maxValue) {
                    System.out.println("Entrada inválida. Por favor, insira um valor entre " + minValue + " e " + maxValue + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira números inteiros.");
                SC.next();
            }
        }
        return input;
    }

    private static void validateAndPrintDate(int day, int month) {

        String[] monthNames = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        String monthName = monthNames[month - 1];
        int monthDays = getMonthDays(month);

        if (day <= monthDays) {
            System.out.println("Data válida: " + day + " de " + monthName);
        } else {
            System.out.println("Data inválida para o mês de " + monthName + ". O mês " + monthName + " tem " + monthDays + " dias.");
        }
    }

    private static int getMonthDays(int month) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28; // Não considerar anos bissextos pois não pede a data atual
            default -> 31;
        };
    }
}

