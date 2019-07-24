public class Task_21 {

    public static void main(String[] args) {
        final String STR = "Hello, world!";
        final int COUNT = 50_000;

        long startTime, stopTime;
        
        String s = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            s += STR;
        }
        stopTime = System.currentTimeMillis();
        long sRes = stopTime - startTime; 
        System.out.printf("Конкатенация %d строк через String:        %dms\n", COUNT, sRes);

        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            sbf.append(STR);
        }
        stopTime = System.currentTimeMillis();
        long sbfRes = stopTime - startTime; 
        System.out.printf("Конкатенация %d строк через StringBuffer:  %dms\n", COUNT, sbfRes);

        StringBuilder sbd = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            sbd.append(STR);
        }
        stopTime = System.currentTimeMillis();
        long sbdRes = stopTime - startTime; 
        System.out.printf("Конкатенация %d строк через StringBuilder: %dms\n", COUNT, sbdRes);

        System.out.printf("StringBuilder быстрее String в %d раз", sRes / sbdRes);
    }
}