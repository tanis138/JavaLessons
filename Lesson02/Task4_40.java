import java.util.Scanner;

public class Task4_40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double y, x = in.nextDouble();

        y = (-2.4 <= x && x <= 5.7) ? x * x : 4;
        System.out.printf("y = %.2f%n", y);

        in.close();
    }
}