import java.util.Scanner;

public class Task6_34 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите целое число n >= 100: ");
            n = in.nextInt();
        } while (n < 100);

        System.out.printf("15 первых натуральных чисел из интервала [100..%d], делящихся нацело на 19:\n", n);
        /*
        // 1 вариант  
        int cnt = 0;
        for (int i = 100; i <= n; i++) {
            if (i % 19 == 0) {
                cnt++;
                System.out.printf("%d\t", i);
            }
            if (cnt == 15)
                break;
        }
        */  
        // 2 вариант
        int num = 114, cnt = 0;
        while (num <= n && cnt < 15) {
            System.out.printf("%d\t", num);
            num += 19;
            cnt++;
        }

        in.close();
    }
}