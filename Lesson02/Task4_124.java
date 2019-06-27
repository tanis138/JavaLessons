import java.util.Scanner;

public class Task4_124 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите стороны треугольника a, b и c через пробел: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        boolean isTriangle = (a + b <= c || a + c <= b || b + c <= a) ? false : true;

        String res;
        if (isTriangle) {
            res = "Треугольник c такими сторонами является ";

            if (a == b && b == c) {
                res += "равносторонним и ";
            } else if (a == b || a == c || b == c) {
                res += "равнобедренным и ";
            } else {
                res += "разносторонним и ";
            }

            // гипотенуза и катеты
            double h, k1, k2;
            if (a >= b) {
                if (a >= c) {
                    h = a;
                    k1 = b;
                    k2 = c;
                } else {
                    h = c;
                    k1 = a;
                    k2 = b;
                }
            } else if (b >= c) {
                h = b;
                k1 = a;
                k2 = c;
            } else {
                h = c;
                k1 = a;
                k2 = b;
            }
            h *= h;
            k1 *= k1;
            k2 *= k2;
            if (h < k1 + k2) {
                res += "остроугольным.";
            } else if (h == k1 + k2) {
                res += "прямоугольным.";
            } else {
                res += "тупоугольным.";
            }
        } else {
            res = "Треугольника c такими сторонами не существует!";
        }

        System.out.println(res);

        in.close();
    }
}