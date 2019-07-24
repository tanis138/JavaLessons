import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_18_19_20 {
    public static int getPunctCount(String text) {
        int res = 0;

        String regex = "\\p{Punct}";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            res++;
        }

        return res;
    }

    public static int getWordCount(String text) {
        int res = 0;

        String regex = "([A-Za-zА-Яа-я]+)(\\p{Punct}|\\p{Blank})";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            res++;
        }

        return res;
    }

    public static String getLastLetters(String text) {
        StringBuilder sb = new StringBuilder();

        String regex = "([A-Za-zА-Яа-я]+)(?=\\p{Punct}|\\p{Blank})";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String s = m.group();
            //System.out.printf("\"%s\" ", s);
            sb.append(s.charAt(s.length() - 1));
            sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "  :Hello,world! Как\tдела? \"Здесь\" - работа с: строками; угу.  ";
        System.out.printf("Исходная строка: [%s]\n", str);
        System.out.println();

        str = str.trim();

        int wordCount = 0;
        int punctCount = 0;
        boolean isNewWordFound = false;
        StringBuilder sbLastLetters = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
            case '.':
            case ',':
            case '?':
            case '!':
            case ':':
            case ';':
            case '-':
            case '\"':
                punctCount++;
            case ' ':
            case '\t':
                if (isNewWordFound == true) {
                    isNewWordFound = false;
                    sbLastLetters.append(str.charAt(i - 1));
                    sbLastLetters.append(' ');
                }
                break;

            default:
                if (isNewWordFound == false) {
                    isNewWordFound = true;
                    wordCount++;
                }
                break;
            }
        }

        System.out.println("Решение через перебор символов:");
        System.out.printf("\tКоличество знаков препинания: %d\n", punctCount);
        System.out.printf("\tКоличество слов: %d\n", wordCount);
        System.out.printf("\tСтрока из последних букв слов: %s\n", sbLastLetters.toString());
        System.out.println();

        System.out.println("Решение через регулярное выражение:");
        System.out.printf("\tКоличество знаков препинания: %d\n", getPunctCount(str));
        System.out.printf("\tКоличество слов: %d\n", getWordCount(str));
        System.out.printf("\tСтрока из последних букв слов: %s\n", getLastLetters(str));

    }
}