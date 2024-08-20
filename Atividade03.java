
import java.util.Scanner;

public class Atividade03 {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        int amountMen = requestAmount( "homens");
        int amountWomen = requestAmount( "mulheres");

        displayPercentage(amountMen, amountWomen);

        SC.close();
    }

    private static int requestAmount(String group) {
        int amount;
        do {
            System.out.print("Digite a quantidade de " + group + " na turma: ");
            while (!SC.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro válido.");
                SC.next();
            }
            amount = SC.nextInt();
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