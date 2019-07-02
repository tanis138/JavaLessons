public class Task11_34 {

    public static void main(String[] args) {
        final int DAYS = 30;
        int[] rainFalls = new int[DAYS];
        int[] sumHalfs = new int[2];
        int[] sumDecades = new int[3];
        for (int i = 0; i < DAYS; i++) {
            rainFalls[i] = (int) (Math.random() * 1000);
            System.out.printf("%d ", rainFalls[i]);
            if (i < DAYS / 2) {
                sumHalfs[0] += rainFalls[i];
            } else {
                sumHalfs[1] += rainFalls[i];
            }
            if (i < 10) {
                sumDecades[0] += rainFalls[i];
            } else if (i < 20) {
                sumDecades[1] += rainFalls[i];
            } else {
                sumDecades[2] += rainFalls[i];
            }
        }

        String str1 = (sumHalfs[0] >= sumHalfs[1]) ? "больше" : "меньше";
        System.out.printf("%nВ первой половине июня (%d) выпало %s осадков, чем во второй (%s)%n", sumHalfs[0], str1,
                sumHalfs[1]);

        int maxInd = 0;
        if (sumDecades[0] >= sumDecades[1]) {
            if (sumDecades[0] < sumDecades[2]) {
                maxInd = 2;
            }
        } else {
            if (sumDecades[1] >= sumDecades[2]) {
                maxInd = 1;
            } else {
                maxInd = 2;
            }
        }
        System.out.printf("Осадки по декадам: 1 - %d, 2 - %d, 3 - %d. Максимум в %d декаде%n", sumDecades[0],
                sumDecades[1], sumDecades[2], maxInd + 1);
    }
}