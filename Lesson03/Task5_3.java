import java.util.Scanner;

public class Task5_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        int n;

        do {
            System.out.print("Введите номер варианта (1..4) или 0 для выхода: ");
            n = in.nextInt();

            switch (n) {
            case 0:
                System.out.println("Выход.");
                break;

            case 1:
                for (int i = 20; i <= 35; i++) {
                    System.out.println(i);
                }
                break;

            case 2:
                System.out.print("Введите b >= 10: ");
                b = in.nextInt();
                System.out.println();
                for (int i = 10; i <= b; i++) {
                    System.out.printf("%d\t", i * i);
                    if ((i + 1) % 10 == 0)
                        System.out.println();
                }
                break;

            case 3:
                System.out.print("Введите a <= 50: ");
                a = in.nextInt();
                System.out.println();
                for (int i = a; i <= 50; i++) {
                    System.out.printf("%d\t", i * i * i);
                    if ((i + 1) % 10 == 0)
                        System.out.println();
                }
                break;

            case 4:
                System.out.print("Введите через пробел a и b, a <= b: ");
                a = in.nextInt();
                b = in.nextInt();
                System.out.println();
                for (int i = a; i <= b; i++) {
                    System.out.printf("%d\t", i);
                    if (i != 0 && i % 10 == 0)
                        System.out.println();
                }
                break;

            default:
                System.out.println("Введён неправильный номер формулы!");
                break;
            }
            System.out.println();
        } while (n != 0);

        in.close();
    }
}