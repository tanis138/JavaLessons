package carlib;

import java.util.Objects;

/**
 * Класс "Двигатель"
 * 
 * @author tanis138
 * @version 1.0
 * @see IEngine
 */
public abstract class Engine implements IEngine {
    /** Константа перевода мощности в лошадиные силы */
    public static final double HORSE_POWER_CONSTANT = 1.35962;

    /** Мощность двигателя, кВт */
    protected final int maxPowerKw;

    /** Мощность двигателя, л.с. */
    protected final int maxPowerHP;


    /**
     * Конструктор двигателя
     * 
     * @param maxPowerKw мощность двигателя, кВт
     */
    public Engine(int maxPowerKw) {
        if (maxPowerKw < 0) {
            maxPowerKw = 0;
        }
        maxPowerHP = (int) (maxPowerKw * HORSE_POWER_CONSTANT);

        this.maxPowerKw = maxPowerKw;
    }


    /** Получает максимальную мощность двигателя, кВт */
    public int getMaxPowerKw() {
        return maxPowerKw;
    }

    /** Получает максимальную мощность двигателя, л.с. */
    public int getMaxPowerHP() {
        return maxPowerHP;
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
        Engine other = (Engine) obj;
        return maxPowerKw == other.maxPowerKw;
    }

	@Override
	public String toString() {
		return "Engine [maxPowerHP=" + maxPowerHP + ", maxPowerKw=" + maxPowerKw + "]";
	}
}
