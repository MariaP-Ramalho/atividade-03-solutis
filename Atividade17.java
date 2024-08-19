import java.util.InputMismatchException;
import java.util.Scanner;


public class Atividade17 {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int day = getInput("Digite o dia do seu aniversário: ", 1, 31);
        int month = getInput("Digite o mês do seu aniversário: ", 1, 12);

        validateDate(day, month);

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
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                SC.next();
            }
        }
        return input;
    }

    private static void validateDate(int day, int month) {

        String[] monthNames = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        String monthName = monthNames[month - 1];
        int monthDays = getMonthDays(month);

        if (day > 0 && day <= monthDays) {
            String quarter = getQuarter(month);
            String zodiacSign = getZodiacSign(day, month);
            System.out.println("Data válida: " + day + " de " + monthName + ". Você nasceu no " + quarter + " trimestre e seu signo é " + zodiacSign + ".");
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

    private static String getQuarter(int month) {
        return switch (month) {
            case 1, 2, 3 -> "1º";
            case 4, 5, 6 -> "2º";
            case 7, 8, 9 -> "3º";
            case 10, 11, 12 -> "4º";
            default -> "Desconhecido";
        };
    }

    private static String getZodiacSign(int day, int month) {
        return switch (month) {
            case 1 -> (day <= 19) ? "Capricórnio" : "Aquário";
            case 2 -> (day <= 18) ? "Aquário" : "Peixes";
            case 3 -> (day <= 20) ? "Peixes" : "Áries";
            case 4 -> (day <= 19) ? "Áries" : "Touro";
            case 5 -> (day <= 20) ? "Touro" : "Gêmeos";
            case 6 -> (day <= 20) ? "Gêmeos" : "Câncer";
            case 7 -> (day <= 22) ? "Câncer" : "Leão";
            case 8 -> (day <= 22) ? "Leão" : "Virgem";
            case 9 -> (day <= 22) ? "Virgem" : "Libra";
            case 10 -> (day <= 22) ? "Libra" : "Escorpião";
            case 11 -> (day <= 21) ? "Escorpião" : "Sagitário";
            case 12 -> (day <= 21) ? "Sagitário" : "Capricórnio";
            default -> "Desconhecido";
        };
    }
}