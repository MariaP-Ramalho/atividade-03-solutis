import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade61 {

    public static void main(String[] args) {
        int lines = getNumberOfLines();
        printPiramide(lines);
    }

    private static int getNumberOfLines() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número positivo de linhas para a pirâmide: ");

            try {
                int numberOfLines = sc.nextInt();
                if (numberOfLines > 0) {
                    return numberOfLines;
                } else {
                    System.out.println("Por favor, insira um número maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.next();
            }
        }
    }



    private static void printPiramide(int lines) {
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}