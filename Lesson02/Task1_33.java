import java.util.Scanner;

public class Task1_33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество жителей государства: ");
        double n = in.nextDouble();
        System.out.print("Введите площадь территории государства: ");
        double s = in.nextDouble();
        System.out.printf("Плотность населения: %.2f%n", n / s);

        in.close();
    }
}