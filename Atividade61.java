import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade61 {

    public static void main(String[] args) {
        int linhas = solicitarNumeroDeLinhas();
        desenharPiramide(linhas);
    }

    private static int solicitarNumeroDeLinhas() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número positivo de linhas para a pirâmide: ");

            try {
                int numeroDeLinhas = sc.nextInt();
                if (numeroDeLinhas > 0) {
                    return numeroDeLinhas;
                } else {
                    System.out.println("Por favor, insira um número maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.next();
            }
        }
    }



    private static void desenharPiramide(int linhas) {
        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}