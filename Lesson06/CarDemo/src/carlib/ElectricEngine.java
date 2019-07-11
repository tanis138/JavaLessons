package carlib;

import java.util.Objects;

/**
 * Класс "Электродвигатель"
 * 
 * @author tanis138
 * @version 1.0
 * @see Engine
 * @see IEngine
 */
public class ElectricEngine extends Engine {
    /** Константа перевода киловатт в ватты */
    private static final int KW_TO_W = 1000;

    /** Константа перевода ватт в киловатты */
    private static final double W_TO_КW = 0.001;

    /** Текущая можность двигателя, Вт */
    private int currPowerW;


    /**
     * Конструктор ДВС
     * 
     * @param maxPowerKw мощность двигателя, кВт
     */
    public ElectricEngine(int maxPowerKw) {
        super(maxPowerKw);
    }


    // Реализация интерфейса IEngine =========
    @Override
    public int getPower() {
        return (currPowerW * IEngine.PCNT_MAX) / (maxPowerKw * KW_TO_W);
    }

    @Override
    public boolean setPower(int pcnt) {
        if (pcnt < PCNT_MIN || pcnt > PCNT_MAX) {
            System.out.println("\tЭДВ: Ошибка! желаемая мощность вне диапазона.");
            return false;
        }

        currPowerW = (maxPowerKw * KW_TO_W * pcnt) / PCNT_MAX;
        System.out.printf("\tЭДВ: Выставлена мощность %.2f кВт (%d%%).%n", currPowerW * W_TO_КW, pcnt);
        return true;
    }

    @Override
    public boolean start() {
        System.out.println("\tЭДВ: Запущен.");
        return true;
    }

    @Override
    public boolean stop() {
        currPowerW = 0;
        System.out.println("\tЭДВ: Остановлен.");
        return true;
    }
    // =======================================


    /** Получает текущую можность двигателя, Вт */
    public int getCurrPowerW() {
        return currPowerW;
    }


    @Override
    public int hashCode() {
        return Objects.hash(maxPowerKw);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ElectricEngine other = (ElectricEngine) obj;
        return maxPowerKw == other.maxPowerKw;
    }

	@Override
	public String toString() {
        return String.format("Двигатель: электрический, мощность %d кВт (%d л.с.)", maxPowerKw, maxPowerHP);
		// return "ElectricEngine [maxPowerHP=" + maxPowerHP + ", maxPowerKw=" + maxPowerKw + "]";
	}
}
