import java.util.Scanner;

public class Task5_51 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите целое положительное число n: ");
            n = in.nextInt();
        } while (n <= 0);

        System.out.printf("Введите %d вещественных чисел: ", n);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.nextDouble();
        }

        System.out.printf("Среднее арифметическое введённой последовательности = %.2f", sum / n);

        in.close();
    }
}