import java.util.Scanner;

public class Task6_71 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите число учеников в классе: ");
            n = in.nextInt();
        } while (n <= 0);

        System.out.printf("Введите через пробел рост каждого ученика (всего %d): ", n);
        double max = in.nextInt();
        boolean isDescend = true;
        for (int i = 0; i < n - 1; i++) {
            int p = in.nextInt();
            if (p > max) {
                isDescend = false;
                break;
            } else {
                max = p;
            }
        }

        if (isDescend) {
            System.out.println("Ученики перечислены в порядке убывания их роста");
        } else {
            System.out.println("Ученики перечислены с произвольным порядком роста");
        }

        in.close();
    }
}