public class Task12_192 {

    public static void main(String[] args) {
        final int M = 5;
        final int N = 4;
        int[][] a = new int[M][N];

        System.out.println("Исходный массив:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = (int) (Math.random() * 100);
                System.out.printf("%d\t", a[i][j]);
            }
            System.out.println();
        }

        int tmp = a[0][0];
        a[0][0] = a[M-1][0];
        a[M-1][0] = tmp;
        tmp = a[0][N-1];
        a[0][N-1] = a[M-1][N-1];
        a[M-1][N-1] = tmp;

        System.out.println("\nНовый массив:");
        for (int[] ai : a) {
            for (int el : ai) {
                System.out.printf("%d\t", el);
            }
            System.out.println();
        }

    }
}