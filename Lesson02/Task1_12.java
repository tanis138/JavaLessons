import java.util.Scanner;

public class Task1_12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("а) Вывод чисел:");
        System.out.printf("%d %d%n%d %s%n", 1, 12, 7, "см");

        System.out.print("\nб) Введите целые числа t и v через пробел: ");
        int t = in.nextInt();
        int v = in.nextInt();
        System.out.printf("%d %d%n%d %d%n", 100, t, 1949, v);

        System.out.print("\nв) Введите целые числа x и y через пробел: ");
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.printf("%d %d%n%d %d%n", x, 25, x, y);

        in.close();
    }
}