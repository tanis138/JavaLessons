import java.util.Scanner;

public class Task1_60 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, c, a1, b1, c1;
        int tmp;

        System.out.print("\nВведите целые числа a, b и c через пробел: ");
        a1 = a = in.nextInt();
        b1 = b = in.nextInt();
        c1 = c = in.nextInt();

        tmp = b;
        b = c;
        c = a;
        a = tmp;
        System.out.printf("a) a=%d b=%d c=%d%n", a, b, c);

        tmp = b1;
        b1 = a1;
        a1 = c1;
        c1 = tmp;
        System.out.printf("б) a=%d b=%d c=%d%n", a1, b1, c1);

        in.close();
    }
}