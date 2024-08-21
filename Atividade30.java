import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Atividade30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as coordenadas dos vértices do primeiro retângulo:");
        Point[] rectangle1 = getRectangle(sc);

        System.out.println("Digite as coordenadas dos vértices do segundo retângulo:");
        Point[] rectangle2 = getRectangle(sc);

        if (validateRectangle(rectangle1) && validateRectangle(rectangle2)) {
            if (checkIfOverlaps(rectangle1, rectangle2)) {
                System.out.println("Os retângulos se interceptam.");
            } else {
                System.out.println("Os retângulos não se interceptam.");
            }
        } else {
            System.out.println("Um ou ambos os conjuntos de pontos não formam retângulos válidos.");
        }

        sc.close();
    }

    private static Point[] getRectangle(Scanner sc) {
        Point[] points = new Point[4];
        for (int i = 0; i < 4; i++) {
            while (true) {
                try {
                    System.out.printf("Digite as coordenadas do ponto %d (x) : ", i + 1);
                    int x = sc.nextInt();
                    System.out.printf("Digite as coordenadas do ponto %d (y) : ", i + 1);
                    int y = sc.nextInt();
                    points[i] = new Point(x, y);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    sc.next();
                }
            }
        }
        return points;
    }

    private static boolean validateRectangle(Point[] points) {
        if (points.length != 4) {
            return false;
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return false;
                }
            }
        }

        int dist01 = calculateDistanceBetweenPoints(points[0], points[1]);
        int dist12 = calculateDistanceBetweenPoints(points[1], points[2]);
        int dist23 = calculateDistanceBetweenPoints(points[2], points[3]);
        int dist30 = calculateDistanceBetweenPoints(points[3], points[0]);

        int diag02 = calculateDistanceBetweenPoints(points[0], points[2]);
        int diag13 = calculateDistanceBetweenPoints(points[1], points[3]);

        return (dist01 == dist23 && dist12 == dist30 && diag02 == diag13);
    }

    private static int calculateDistanceBetweenPoints(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static boolean checkIfOverlaps(Point[] rectangle1, Point[] rectangle2) {
        Rectangle r1 = criateRectangle(rectangle1);
        Rectangle r2 = criateRectangle(rectangle2);
        return r1.intersects(r2);
    }

    private static Rectangle criateRectangle(Point[] points) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point p : points) {
            if (p.x < minX) minX = p.x;
            if (p.y < minY) minY = p.y;
            if (p.x > maxX) maxX = p.x;
            if (p.y > maxY) maxY = p.y;
        }

        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
}

