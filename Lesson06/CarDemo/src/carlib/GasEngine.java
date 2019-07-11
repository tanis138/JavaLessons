package carlib;

import java.util.Objects;

/**
 * Класс "Двигатель внутреннего сгорания"
 * 
 * @author tanis138
 * @version 1.0
 * @see Engine
 * @see IEngine
 */
public class GasEngine extends Engine {
    /** Обороты холостого хода по умолчанию как % от мощности */
    private static final int DEF_IDLE_RPM_PCNT = 10;

    /** Объём двигателя, cм3 */
    private final int capacity;

    /** Максимальные обороты двигателя, об/мин */
    private final int maxRPM;

    /** Холостые обороты двигателя, об/мин */
    private int idleRPM;

    /** Текущие обороты двигателя, об/мин */
    private int currRPM;

    /**
     * Конструктор ДВС
     * 
     * @param capacity   объём двигателя, см3
     * @param maxPowerKw мощность двигателя, кВт
     * @param maxRPM     макс. обороты двигателя, об/мин
     */
    public GasEngine(int capacity, int maxPowerKw, int maxRPM) {
        super(maxPowerKw);

        if (capacity < 0) {
            capacity = 0;
        }
        if (maxRPM < 0) {
            maxRPM = 0;
        }

        idleRPM = (maxRPM * DEF_IDLE_RPM_PCNT) / 100;

        this.capacity = capacity;
        this.maxRPM = maxRPM;
    }

    // Реализация интерфейса IEngine =========
    @Override
    public int getPower() {
        return (currRPM * IEngine.PCNT_MAX) / maxRPM;
    }

    @Override
    public boolean setPower(int pcnt) {
        if (pcnt < PCNT_MIN || pcnt > PCNT_MAX) {
            System.out.println("\tДВС: Ошибка! желаемая мощность вне диапазона.");
            return false;
        }

        String str = (pcnt == 0) ? "холостые " : "";
        currRPM = idleRPM + ((maxRPM - idleRPM) * pcnt) / PCNT_MAX;
        System.out.printf("\tДВС: Выставлены %sобороты %d об/мин.%n", str, currRPM);
        return true;
    }

    @Override
    public boolean start() {
        currRPM = idleRPM;
        System.out.printf("\tДВС: Запущен. Выставлены холостые обороты %d об/мин.%n", idleRPM);
        return true;
    }

    @Override
    public boolean stop() {
        currRPM = 0;
        System.out.println("\tДВС: Остановлен.");
        return true;
    }
    // =======================================

    /** Получает объём двигателя, см3 */
    public int getCapacity() {
        return capacity;
    }

    /** Получает максимальные обороты двигателя */
    public int getMaxRPM() {
        return maxRPM;
    }

    /** Получает текущие обороты двигателя */
    public int getCurrRPM() {
        return currRPM;
    }

    /**
     * Устанавливает текущие обороты двигателя в пределах от {@code 0} до
     * {@link GasEngine#maxRPM maxRPM}
     *
     * @param currRPM текущие обороты
     */
    public void setCurrRPM(int currRPM) {
        if (currRPM > maxRPM) {
            currRPM = maxRPM;
        }
        this.currRPM = currRPM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, maxRPM, maxPowerKw);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GasEngine other = (GasEngine) obj;
        return capacity == other.capacity && maxRPM == other.maxRPM && maxPowerKw == other.maxPowerKw;
    }

    @Override
    public String toString() {
        return String.format("Двигатель: бензиновый, объём %d см3, мощность %d кВт (%d л.с.), макс. обороты %d об/мин",
                capacity, maxPowerKw, maxPowerHP, maxRPM);
        // return "GasEngine [capacity=" + capacity + ", maxRPM=" + maxRPM + ",
        // maxPowerHP=" + maxPowerHP + ", maxPowerKw="
        // + maxPowerKw + "]";
    }
}
