import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Atividade41 {
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {
        int generatedNumber = generateRandomNumber();
        int atempts = 0;
        boolean win = false;


        System.out.println("Tente adivinhar o número entre " + MIN + " e " + MAX + ".");

        while (!win) {
            int guess = getUsersGuess();
            atempts++;
            win = checkGuess(guess, generatedNumber);
        }

        System.out.println("Parabéns! Você acertou o número " + generatedNumber + " em " + atempts + " tentativas.");
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    private static int getUsersGuess() {
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Digite o seu palpite: ");
            try {
                guess = sc.nextInt();

                if (guess < MIN || guess > MAX) {
                    System.out.println("Entrada inválida! Por favor, insira um número entre " + MIN + " e " + MAX + ".");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                sc.next();
            }
        }
        return guess;
    }

    private static boolean checkGuess(int guess, int generatedNumber) {
        if (guess < generatedNumber) {
            System.out.println("O número é maior. Tente novamente!");
            return false;
        } else if (guess > generatedNumber) {
            System.out.println("O número é menor. Tente novamente!");
            return false;
        } else {
            return true;
        }
    }
}
