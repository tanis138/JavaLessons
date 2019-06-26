import java.util.Scanner;

public class Task1_22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double x = in.nextDouble();
        double y = 7d * x * x - 3d * x + 6d;
        System.out.printf("a) y = %.2f%n", y);

        System.out.print("Введите число a: ");
        double a = in.nextDouble();
        x = 12d * a * a + 7 * a - 16;
        System.out.printf("б) x = %.2f%n", x);

        in.close();
    }
}