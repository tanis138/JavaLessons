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

        int minInd1, minInd2;
        if (a[0] < a[1]) {
            minInd1 = 0;
            minInd2 = 1;    
        } else {
            minInd1 = 1;
            minInd2 = 0;    
        }
        for (int i = 2; i < COUNT; i++) {
            if (a[i] <= a[minInd1]) {
                minInd2 = minInd1;
                minInd1 = i;
            } else if (a[i] < a[minInd2]) {
                minInd2 = i;
            }
        }

        System.out.printf("Даты двух самых холодных дней: %d (t = %d°C), %d (t = %d°C)", minInd1 + 1, a[minInd1], minInd2 + 1, a[minInd2]);
    }
}