public class Task11_140 {

    public static void main(String[] args) {
        final int COUNT = 28;
        int[] a = new int[COUNT];

        System.out.println("Среднесуточные температуры за февраль:");
        for (int i = 0; i < COUNT; i++) {
            a[i] = (int) (-Math.random() * 35);
            System.out.printf("%d\t", a[i]);
        }
        System.out.println();

        int ind1 = -1, ind2 = -1;
        int min1 = 100, min2 = 100;
        for (int i = 0; i < COUNT; i++) {
            if (a[i] < min1) {
                min1 = a[i];
                ind1 = i;
            } else if (a[i] == min1) {
                min2 = min1;
                ind2 = i;
            }
            if (a[i] != min1 && a[i] < min2) {
                min2 = a[i];
                ind2 = i;
            }
        }

        System.out.printf("Даты двух самых холодных дней: %d (t = %d°C), %d (t = %d°C)", ind1 + 1, min1, ind2 + 1, min2);
    }
}