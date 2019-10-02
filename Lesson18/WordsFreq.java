import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordsFreq {

    public static void main(String[] args) {
        // final String FILE_NAME = "src\\com\\tanis138\\collections\\texts\\text.txt";
        final String TEXT = "One,one, one, little dogs run.\nTwo,two,two, cats see you.\nThree,three,three, birds in a tree.\nFour, four,four, rats on the floor.\nRun! Run! Run!";
        final String OUT_FORMAT = "(%s, %d) ";
        final int maxCount = 20;
        final int lineCount = 5;

        Map<String, Integer> freqMap = new HashMap<>(100);

        long callTime = System.nanoTime();
//        try {
//            Scanner scan = new Scanner(new File(FILE_NAME), StandardCharsets.UTF_8.name())
//                    .useDelimiter("[^\\p{L}]+");
//            while (scan.hasNext()) {
//                String word = scan.next().toLowerCase();
//                freqMap.merge(word, 1, Integer::sum);
//            }
//            scan.close();
//        } catch (FileNotFoundException | IllegalStateException e) {
//            e.printStackTrace();
//        }
        Arrays.stream(TEXT.split("[^\\p{L}]+"))
                .forEach(word -> freqMap.merge(word.toLowerCase(), 1, Integer::sum));
        long totalTime = System.nanoTime() - callTime;

        System.out.printf("Найдено различных слов: %d. Время выполнения: %.3f мс.\n",
                freqMap.size(), totalTime / (1000D * 1000D));

        System.out.println("Массив частот (слово, частота):");
        int sum = 0;
        for (Map.Entry<String, Integer> me : freqMap.entrySet()) {
            System.out.printf(OUT_FORMAT, me.getKey(), me.getValue());
            if (++sum == maxCount) {
                break;
            }
            if (sum % lineCount == 0) {
                System.out.println();
            }
        }
    }
}
