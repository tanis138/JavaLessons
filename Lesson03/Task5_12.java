public class Task5_12 {

    public static void main(String[] args) {
        final double P0 = 1.29;
        final double z = 1.25 / 10000;
        double p;
        
        System.out.println("Таблица зависимости плотности воздуха от высоты (м):");
        for (int h = 0; h <= 1000; h += 100) {
            System.out.printf("%dm\t", h);
        }
        System.out.println();
        for (int h = 0; h <= 1000; h += 100) {
            p = P0 * Math.exp(-h * z);
            System.out.printf("%.3f\t", p);
        }
    }
}