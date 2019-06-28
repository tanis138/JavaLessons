import java.util.Scanner;

public class Task5_64 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 0;
        double s = 0;
        for (int i = 1; i <= 12; i++) {
            System.out.printf("Введите через пробел кол-во жителей (тыс. чел.) и площадь (км2) %d района: ", i);
            n += in.nextInt();
            s += in.nextDouble();
        }

        System.out.printf("Средняя плотность населения всей области = %d чел/км2", Math.round(n * 1000l / s));

        in.close();
    }
}