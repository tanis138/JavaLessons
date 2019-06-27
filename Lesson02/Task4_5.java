import java.util.Scanner;

public class Task4_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double y1, y2, x = in.nextDouble();

        if (x < 2) {
            y1 = x;
        } else {
            y1 = 2;
        }
        System.out.printf("y1 = %.2f%n", y1);

        y2 = (x < 3) ? -x : -3;
        System.out.printf("y2 = %.2f%n", y2);

        in.close();
    }
}