import java.util.Scanner;

public class Task4_21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите числа a и b через пробел: ");
        double a = in.nextDouble();
        double b = in.nextDouble();

        String res = (b % a == 0) ? "а является делителем b" : "а НЕ является делителем b";
        System.out.println(res);

        in.close();
    }
}