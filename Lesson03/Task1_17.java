import java.util.Scanner;

public class Task1_17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1, x2, x3, x4;
        int n;

        do {
            System.out.print("Введите номер математической формулы (1..18) или 0 для выхода: ");
            n = in.nextInt();

            switch (n) {
            case 0:
                System.out.println("Выход.");
                break;

            case 1:
                System.out.print("Введите через пробел x1 и x2: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                System.out.printf("sqrt(x1^2 + x2^2) = %.2f%n", Math.hypot(x1, x2));
                break;

            case 2:
                System.out.print("Введите через пробел x1, x2 и x3: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("x1x2 + x1x3 + x2x3 = %.2f%n", x1 * x2 + x1 * x3 + x2 * x3);
                break;

            case 3:
                System.out.print("Введите через пробел v0, a и t: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("v0t + at^2/2 = %.2f%n", x1 * x3 + x2 * x3 * x3 / 2d);
                break;

            case 4:
                System.out.print("Введите через пробел m, v, g, h: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                x4 = in.nextDouble();
                System.out.printf("mv^2/2 + mgh = %.2f%n", x1 * x2 * x2 / 2d + x1 * x3 * x4);
                break;

            case 5:
                System.out.print("Введите через пробел x1 и x2: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                System.out.printf("1/R1 + 1/R2 = %.2f%n", (x1 != 0 && x2 != 0) ? 1 / x1 + 1 / x2 : 0);
                break;

            case 6:
                System.out.print("Введите через пробел m, g и a: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("mgcos(a) = %.2f%n", x1 * x2 * Math.cos(x3));
                break;

            case 7:
                System.out.print("Введите R: ");
                x1 = in.nextDouble();
                System.out.printf("2piR = %.2f%n", 2 * Math.PI * x1);
                break;

            case 8:
                System.out.print("Введите через пробел b, a и c: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("b^2 - 4ac = %.2f%n", x2 * x2 - 4 * x1 * x3);
                break;

            case 9:
                System.out.print("Введите через пробел y, m1, m2, r: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                x4 = in.nextDouble();
                System.out.printf("y * (m1m2 / r^2) = %.2f%n", x1 * (x2 * x3) / (x4 * x4));
                break;

            case 10:
                System.out.print("Введите через пробел I и R: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                System.out.printf("I^2R = %.2f%n", x1 * x1 * x2);
                break;

            case 11:
                System.out.print("Введите через пробел a, b и c: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("absin(c) = %.2f%n", x1 * x2 * Math.sin(x3));
                break;

            case 12:
                System.out.print("Введите через пробел a, b и c: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                System.out.printf("sqrt(a^2 + b^2 -2abcos(c)) = %.2f%n",
                        Math.sqrt(x1 * x1 + x2 * x2 - 2 * x1 * x2 * Math.cos(x3)));
                break;

            case 13:
                System.out.print("Введите через пробел a, b, c, d: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                x4 = in.nextDouble();
                System.out.printf("(ad + bc) / ad = %.2f%n", 1 + (x2 * x3) / (x1 * x4));
                break;

            case 14:
                System.out.print("Введите x: ");
                x1 = in.nextDouble();
                System.out.printf("1 - sin(x)^2 = %.2f%n", 1 - Math.pow(Math.sin(x1), 2));
                break;

            case 15:
                System.out.print("Введите через пробел a, b, c, x: ");
                x1 = in.nextDouble();
                x2 = in.nextDouble();
                x3 = in.nextDouble();
                x4 = in.nextDouble();
                System.out.printf("1 / sqrt(ax^2 + bx + c) = %.2f%n", 1 / Math.sqrt(x1 * x4 * x4 + x2 * x4 + x3));
                break;

            case 16:
                System.out.print("Введите x: ");
                x1 = in.nextDouble();
                System.out.printf("(sqrt(x+1)-sqrt(x-1)) / 2sqrt(x) = %.2f%n",
                        (Math.sqrt(x1 + 1) - Math.sqrt(x1 - 1)) / (2 * Math.sqrt(x1)));
                break;

            case 17:
                System.out.print("Введите x: ");
                x1 = in.nextDouble();
                System.out.printf("|x| + |x + 1| = %.2f%n", Math.abs(x1) + Math.abs(x1 + 1));
                break;

            case 18:
                System.out.print("Введите x: ");
                x1 = in.nextDouble();
                System.out.printf("|1 - |x|| = %.2f%n", Math.abs(1 - Math.abs(x1)));
                break;

            default:
                System.out.println("Введён неправильный номер формулы!\n");
                break;
            }
        } while (n != 0);

        in.close();
    }
}