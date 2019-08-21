import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Birthday
 */
public class Birthday {
    private static final MonthDay BIRTHDAY = MonthDay.of(Month.JULY, 13);
    private static final int YEARS_COUNT = 80;

    public static void main(String[] args) {
        final int year = Year.now().getValue();
       
        System.out.printf("Дни недели моего ДР (%1$td %1$tB):\n", BIRTHDAY);
        for (int y = year; y < year + YEARS_COUNT; y++) {
            System.out.printf("%d: %tA\n", y, BIRTHDAY.atYear(y).getDayOfWeek());
            //System.out.printf("%d: %s\n", y, BIRTHDAY.atYear(y).getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()));
        }

    }
}