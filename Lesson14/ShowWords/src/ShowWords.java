import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowWords {
    private static final String FILE_NAME = "./data/input.txt";
    private static final double NS_TO_MS_DIV = 1000D * 1000D;
    private static final String REGEX = "(\\p{L}*(\\p{L}))(?=[^\\p{L}]+\\2\\p{L}*)";

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) {
        long startTime, totalTime;
        long count;

        System.out.println("List of words which last letter equals to the first letter of next word.\n");

        System.out.println("Using pattern regex on the whole file:");
        count = 0;
        startTime = System.nanoTime();
        try {
            Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = p.matcher(readFile(FILE_NAME, StandardCharsets.UTF_8));
            while (m.find()) {
                System.out.println(m.group(1));
                count++;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        totalTime = System.nanoTime() - startTime;
        System.out.printf("Total count: %d. Execution time: %.3f ms.\n", count, totalTime / NS_TO_MS_DIV);


        System.out.println();


        System.out.println("Using scanner with delimiter and compare:");
        count = 0;
        startTime = System.nanoTime();
        try (Scanner scan = new Scanner(new File(FILE_NAME), StandardCharsets.UTF_8.name())
                .useDelimiter("[^\\p{L}]+")) {
            String prev = "!";
            while (scan.hasNext()) {
                char c1 = Character.toLowerCase(prev.charAt(prev.length() - 1));
                String curr = scan.next();
                char c2 = Character.toLowerCase(curr.charAt(0));

                if (c1 == c2) {
                    System.out.printf("%s (%s)\n", prev, curr);
                    count++;
                }
                prev = curr;
            }
        } catch (FileNotFoundException | IllegalStateException e) {
            System.out.println("I/O Error: " + e);
        }
        totalTime = System.nanoTime() - startTime;
        System.out.printf("Total count: %d. Execution time: %.3f ms.\n", count, totalTime / NS_TO_MS_DIV);
    }
}
