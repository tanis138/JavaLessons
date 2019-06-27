import java.util.Scanner;

public class Task4_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double y, x = in.nextDouble();
        if (x > 0) {
            y = Math.pow(Math.sin(x), 2);
        } else {
            y = 1 - 2 * Math.sin(x * x);
        }
        System.out.printf("y = %.2f%n", y);

        in.close();
    }
}