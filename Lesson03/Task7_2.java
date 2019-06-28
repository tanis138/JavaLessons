import java.util.Scanner;

public class Task7_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b, c;
        do {
            System.out.print("Введите через пробел натуральные числа a, b и с (a <= b): ");
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
        } while (a > b);

        System.out.printf("Все числа из промежутка [%d..%d], кратные %d:%n", a, b, c);
        for (int i = a; i <= b; i++) {
            if (i % c == 0)
                System.out.printf("%d ", i);
        }

        in.close();
    }
}