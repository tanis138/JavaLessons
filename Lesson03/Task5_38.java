import java.util.Scanner;

public class Task5_38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = in.nextInt();

        double sum = 0, dist = 0;
        for (int i = 1; i <= n; sum += 1d / i++) {
            dist += (i % 2 == 0) ? -1d / i : 1d / i;
        }

        System.out.printf("После %d-го этапа \"странный муж\" будет находится на расстоянии %.2fкм от дома и пройдёт %.2fкм", n, dist, sum);

        in.close();
    }
}