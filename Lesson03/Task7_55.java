import java.util.Scanner;

public class Task7_55 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, bestResult = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Введите результат лыжника (мин) или 0 для завершения гонки: ");
            n = in.nextInt();

            if (n == 0) {
                System.out.printf("%nГонка завершена. Лучший результат: %d мин.%n", bestResult);
                break;
            }

            if (bestResult > n)
                bestResult = n;

            System.out.printf("Лучший результат гонки: %d мин.%n", bestResult);
        }

        in.close();
    }
}