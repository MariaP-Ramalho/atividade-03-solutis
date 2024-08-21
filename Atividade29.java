import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] point1 = getPoint(sc, "superior esquerdo");
        int[] point2 = getPoint(sc, "inferior direito");

        if (point1 != null && point2 != null) {
            determineShape(point1, point2);
        } else {
            System.out.println("Erro: Não foi possível determinar a forma devido a entradas inválidas.");
        }

        sc.close();
    }

    private static int[] getPoint(Scanner sc, String pointDescription) {
        int[] point = new int[2];
        try {
            System.out.println("Informe as coordenadas do ponto " + pointDescription + " (x, y):");
            System.out.print("x: ");
            point[0] = sc.nextInt();
            System.out.print("y: ");
            point[1] = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira números inteiros.");
            sc.nextLine();
            return null;
        }
        return point;
    }

    private static void determineShape(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];

        if (x1 == x2 && y1 == y2) {
            System.out.println("Os pontos representam um único ponto.");
        } else if (x1 == x2) {
            System.out.println("Os pontos representam uma reta vertical.");
        } else if (y1 == y2) {
            System.out.println("Os pontos representam uma reta horizontal.");
        } else if (x1 < x2 && y1 > y2) {
            System.out.println("Os pontos representam um retângulo.");
        } else {
            System.out.println("Os pontos não podem constituir um retângulo válido.");
        }
    }
}

