import java.util.Scanner;

public class Task12_29 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите размер массива для построения спирали (нечётное число < 100): ");
            n = in.nextInt();
        } while (n < 0 || n > 99 || n % 2 == 0);
        System.out.println();

        int[][] a = new int[n][n];

        final byte DIR_RIGHT = 0;
        final byte DIR_DOWN = 1;
        final byte DIR_LEFT = 2;
        final byte DIR_UP = 3;
        int dir = DIR_RIGHT;
        int i = 0, j = 0;
        int changeDirInd = n, delta_prev = n, delta = n;
        for (int k = 1; k <= n * n; k++) {
            a[i][j] = k;

            // если пора менять направление движения
            if (k == changeDirInd) {
                // вычисляем новое направление движения
                dir = (dir != DIR_UP) ? dir + 1 : DIR_RIGHT;

                // вычисляем новый индекс смены направления движения
                if (delta == delta_prev) {
                    delta--;
                } else {
                    delta_prev = delta;
                }
                changeDirInd += delta;
            }

            // меняем нарпавление движения
            switch (dir) {
                case DIR_RIGHT:
                    j++;
                    break;
                case DIR_DOWN:
                    i++;
                    break;
                case DIR_LEFT:
                    j--;
                    break;
                case DIR_UP:
                    i--;
                    break;
            }
        }

        for (int[] ai : a) {
            for (int el : ai) {
                System.out.printf("%3d ", el);
            }
            System.out.println();
        }

        in.close();
    }
}