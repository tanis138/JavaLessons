public class Task11_101 {

    public static void main(String[] args) {
        final int COUNT = 10;
        int[] a = new int[COUNT];
        int[] cnt = new int[COUNT];

        System.out.println("Исходный массив:");
        for (int i = 0; i < COUNT; i++) {
            a[i] = (int) (Math.random() * 50);
            System.out.printf("%d\t", a[i]);
        }
        System.out.println("\n");

        // считаем все повторения элементов в массиве
        // все повторяющиееся индексы кроме первого делаем -1
        for (int i = 0; i < COUNT; i++) {
            for (int j = i; j < COUNT; j++) {
                if (cnt[j] < 0) {
                    continue;
                }
                if (a[i] == a[j]) {
                    cnt[i]++;
                    if (i != j) {
                        cnt[j] = -1;
                    }
                }
            }
        }

        System.out.println("Массив повторений элементов:");
        for (int i : cnt) {
            System.out.printf("%d\t", i);
        }
        System.out.println("\n");

        // ищем пару одинаковых элементов
        // если их > 3 присваеваем количеству -1
        int pairCount = 0;
        String strPairs = "";
        for (int i = 0; i < COUNT; i++) {
            if (cnt[i] > 2) {
                pairCount = -1;
                break;
            } else if (cnt[i] == 2) {
                pairCount++;
                strPairs += a[i] + " ";
            }
        }

        if (pairCount < 0) {
            System.out.println("В массиве имеется больше двух одинаковых элементов.");
        } else if (pairCount == 0) {
            System.out.printf("В массиве нет ни одной пары одинаковых элементов.%n");
        } else if (pairCount == 1) {
            System.out.printf("В массиве только одна пара одинаковых элементов: %s%n", strPairs);
        } else {
            System.out.printf("В массиве несколько пар из двух одинаковых элементов: %s", strPairs);
        }
    }
}