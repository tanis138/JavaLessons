import java.util.Scanner;

public class Task1_25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите сторону квадрата: ");
        double x = in.nextDouble();
        System.out.printf("Периметр квадрата равен %.2f%n", 4d * x);

        in.close();
    }
}