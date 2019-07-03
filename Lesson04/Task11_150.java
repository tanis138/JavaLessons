import java.util.Scanner;

public class Task11_150 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int COUNT = 20;
        int[] a = new int[COUNT];
        int[] b = new int[COUNT - 1];

        System.out.println("Массив стоимости товаров:");
        for (int i = 0; i < COUNT; i++) {
            a[i] = (int) (1 + Math.random() * 99);
            System.out.printf("%d\t", a[i]);
        }
        System.out.println("\n");

        int n;
        do {
            System.out.printf("Введите индекс товара для удаления (1..%d): ", COUNT);
            n = in.nextInt();
            System.out.println();
        } while (n < 1 || n > COUNT);

        int j = 0;
        for (int i = 0; i < COUNT; i++) {
            if (i == n - 1) {
                continue;
            }
            b[j] = a[i];
            j++;
        }

        System.out.println("Новый массив стоимости товаров:");
        for (int el : b) {
            System.out.printf("%d\t", el);
        }
        System.out.println();

        in.close();
    }
}