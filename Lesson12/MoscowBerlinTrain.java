import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * MoscowBerlinTrain
 */
public class MoscowBerlinTrain {
    private static final int MIN_IN_HOU = 60;
    private static final int MIN_TO_MSQ = 7 * MIN_IN_HOU + 54;
    private static final int MIN_TO_WAW = 14 * MIN_IN_HOU + 32;
    private static final int MIN_TO_BER = 22 * MIN_IN_HOU;

    private static String getPeriod(int min) {
        final int h = min / MIN_IN_HOU;
        final int m = min % MIN_IN_HOU;
        if (min < 0) {
            return "";
        } else if (min < MIN_IN_HOU) {
            return String.format("%d м", min);
        } else if (min % MIN_IN_HOU == 0) {
            return String.format("%d ч", h);
        } else {
            return String.format("%d ч %d м", h, m);
        }
    }

    public static void main(String[] args) {
        System.out.println("Поезд МОСКВА-БЕРЛИН:");

        ZoneId mowZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime departureMsk = ZonedDateTime.of(2019, 8, 21, 10, 17, 0, 0, mowZone);
        System.out.printf("  Отправление из Москвы %1$td %1$tB %1$tYг в %1$tR\n", departureMsk);

        ZoneId msqZone = ZoneId.of("Europe/Minsk");
        ZonedDateTime arrivalMsq = departureMsk.withZoneSameInstant(msqZone).plusMinutes(MIN_TO_MSQ);
        System.out.printf("    Остановка в Минске %1$td %1$tB %1$tYг в %1$tR (в пути %2$s)\n", arrivalMsq, getPeriod(MIN_TO_MSQ));

        ZoneId wawZone = ZoneId.of("Europe/Warsaw");
        ZonedDateTime arrivalWaw = departureMsk.withZoneSameInstant(wawZone).plusMinutes(MIN_TO_WAW);
        System.out.printf("    Остановка в Варшаве %1$td %1$tB %1$tYг в %1$tR (в пути %2$s)\n", arrivalWaw, getPeriod(MIN_TO_WAW));

        ZoneId berZone = ZoneId.of("Europe/Warsaw");
        ZonedDateTime arrivalBer = departureMsk.withZoneSameInstant(berZone).plusMinutes(MIN_TO_BER);
        System.out.printf("  Прибытие в Берлин %1$td %1$tB %1$tYг в %1$tR (в пути %2$s)\n", arrivalBer, getPeriod(MIN_TO_BER));
    }
}