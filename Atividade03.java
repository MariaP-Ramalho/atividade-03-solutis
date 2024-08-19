
import java.util.Scanner;

public class Atividade03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amountMen = requestAmount(sc, "homens");
        int amountWomen = requestAmount(sc, "mulheres");

        displayPercentage(amountMen, amountWomen);

        sc.close();
    }

    private static int requestAmount(Scanner sc, String group) {
        int amount;
        do {
            System.out.print("Digite a quantidade de " + group + " na turma: ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                sc.next();
            }
            amount = sc.nextInt();
            if (amount < 0) {
                System.out.println("A quantidade não pode ser negativa.");
            }
        } while (amount < 0);
        return amount;
    }

    private static void displayPercentage(int amountMen, int amountWomen) {
        double totalStudants = amountMen + amountWomen;

        if (totalStudants == 0) {
            System.out.println("Não há alunos na turma.");
            return;
        }

        double menPercentage = (amountMen / totalStudants) * 100;
        double womenPercentage = (amountWomen / totalStudants) * 100;

        System.out.printf("Percentual de homens: %.2f%%\n", menPercentage);
        System.out.printf("Percentual de mulheres: %.2f%%\n", womenPercentage);
    }
}