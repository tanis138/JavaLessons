import java.util.Scanner;

public class Task1_15 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float res;

        System.out.print("Введите число x: ");
        float x = in.nextFloat();
        res = -1f / (x * x);
        System.out.printf("a) %.3f%n", res);

        System.out.print("\nВведите числа a, b и c через пробел: ");
        float a = in.nextFloat();
        float b = in.nextFloat();
        float c = in.nextFloat();

        res = a / (b * c);
        System.out.printf("б) %.3f%n", res);

        res = a / b * c;
        System.out.printf("в) %.3f%n", res);

        res = (a + b) / 2f;
        System.out.printf("г) %.3f%n", res);

        res = 5.45f * ((a + 2f * b) / (2f - a));
        System.out.printf("д) %.3f%n", res);

        res = (-b + (float) Math.sqrt(b * b - 4d * a * c)) / (2f * a);
        System.out.printf("е) %.3f%n", res);

        res = (-b + 1f / a) / (2f / c);
        System.out.printf("ж) %.3f%n", res);

        res = 1f / (1f + (a + b) / 2f);
        System.out.printf("з) %.3f%n", res);

        res = 1f / (1f + 1f / (2f + 1f / (2f + 3f / 5f)));
        System.out.printf("и) %.3f%n", res);

        System.out.print("\nВведите числа m, n через пробел: ");
        float m = in.nextFloat();
        float n = in.nextFloat();
        res = (float) Math.pow(2, Math.pow(m, n));
        System.out.printf("k) %.3f%n", res);

        in.close();
    }
}