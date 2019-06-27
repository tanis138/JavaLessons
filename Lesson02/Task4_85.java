import java.util.Scanner;

public class Task4_85 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число x: ");
        double y, x = in.nextDouble();

        if (x < -1) {
            y = -1;
        } else if (x == -1) {
            y = 1;
        } else {
            y = x;
        }
        System.out.printf("y = %.2f%n", y);

        in.close();
    }
}