public class Task5_71 {

    public static void main(String[] args) {
        final double PCNT = 0.02;
        double sum = 1000, delta = 0;

        System.out.println("Месяц\tCумма\tПрирост");
        for (int i = 0; i <= 12; i++) {
            System.out.printf("%d\t%dр\t%.1fр\n", i, Math.round(sum), delta);
            delta = sum * PCNT;
            sum += delta;
        }
    }
}