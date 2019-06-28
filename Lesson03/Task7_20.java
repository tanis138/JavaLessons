import java.util.Scanner;

public class Task7_20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите целое положительное число n: ");
            n = in.nextInt();
        } while (n <= 0);

        System.out.printf("Введите %d натуральных чисел чисел: ", n);
        int a, a1_2 = 0, a1_n = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            a = in.nextInt();
            sum += (i % 2 == 0) ? -a : a;
            if (i == 1) {
                a1_2 = a1_n = a;
            } else if (i == 2) {
                a1_2 -= a;
            }
            if (i == n)
                a1_n += a;
        }

        System.out.printf("a1 - a2 + a3 - ... = %d%n", sum);
        System.out.printf("a1 - a2 = %d%n", a1_2);
        System.out.printf("a1 + an = %d%n", a1_n);

        in.close();
    }
}