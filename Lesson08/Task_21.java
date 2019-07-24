public class Task_21 {

    public static void main(String[] args) {
        final String STR = "Hello!";
        final int COUNT = 50_000;
        final double NS_TO_MS_DIV = 1000D * 1000D;

        long startTime, stopTime;
        
        String s = "";
        startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            s += STR;
        }
        stopTime = System.nanoTime();
        double sRes = (stopTime - startTime) / NS_TO_MS_DIV;
        System.out.printf("Конкатенация %d строк через String:        %.0fмс\n", COUNT, sRes);

        StringBuffer sbf = new StringBuffer();
        startTime =System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            sbf.append(STR);
        }
        stopTime = System.nanoTime();
        double sbfRes = (stopTime - startTime) / NS_TO_MS_DIV; 
        System.out.printf("Конкатенация %d строк через StringBuffer:  %.2fмс\n", COUNT, sbfRes);

        StringBuilder sbd = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            sbd.append(STR);
        }
        stopTime = System.nanoTime();
        double sbdRes = (stopTime - startTime) / NS_TO_MS_DIV; 
        System.out.printf("Конкатенация %d строк через StringBuilder: %.2fмс\n", COUNT, sbdRes);

        System.out.printf("StringBuilder быстрее String в %.1f раз", sRes / sbdRes);
    }
}