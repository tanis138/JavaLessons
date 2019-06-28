import java.util.Scanner;

public class Task5_32 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число n: ");
        double n = in.nextDouble();

        double sum = 0;
        for (int i = 1; i <= n; sum += 1d / i++);

        System.out.printf("1 + 1/2 + ... + 1/n = %.3f%n", sum);

        in.close();
    }
}