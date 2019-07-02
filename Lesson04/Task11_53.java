public class Task11_53 {

    public static void main(String[] args) {
        final int COUNT = 10;
        int[] a = new int[COUNT];
        int[] a1 = new int[COUNT];
        int[] a2 = new int[COUNT];
        int[] a3 = new int[COUNT];
        int n = 3, m = 4;

        System.out.println("Исходный массив:");
        for (int i = 0; i < COUNT; i++) {
            a[i] = (int) (Math.random() * 100);
            a1[i] = (a[i] % 10 == 0) ? 0 : a[i];
            a2[i] = (a[i] % 2 == 0) ? a[i] / 2 : a[i] * 2;
            a3[i] = (a[i] % 2 == 0) ? a[i] : a[i] - m;
            if (i % 2 == 0) {
                a3[i] += n;
            }
            System.out.printf("%d ", a[i]);
        }
        System.out.println();

        System.out.println("Все элементы, кратные числу 10, заменить нулем:");
        for (int i : a1) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        System.out.println("Все нечетные элементы удвоить, а четные уменьшить вдвое:");
        for (int i : a2) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        System.out.printf("Нечетные элементы уменьшить на %d, а элементы с нечетными номерами увеличить на %d:%n", m, n);
        for (int i : a3) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}