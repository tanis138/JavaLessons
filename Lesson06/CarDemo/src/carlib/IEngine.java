package carlib;

/**
 * Интерфейс для работы с двигателем
 * 
 * @author tanis138
 * @version 1.0
 */
public interface IEngine {
    /** Минимальная мощность двигателя, % */
    int PCNT_MIN = 0;

    /** Максимальная мощность двигателя, % */
    int PCNT_MAX = 100;

    /**
     * Запускает двигатель
     *
     * @return true в случае успеха
     */
    boolean start();

    /**
     * Останавливает двигатель
     *
     * @return true в случае успеха
     */
    boolean stop();

    /**
     * Устанавливает мощность двигателя
     *
     * @param pcnt желаемая мощность двигателя, %
     * @return true в случае успеха
     */
    boolean setPower(int pcnt);

    /**
     * Получает текущую мощность двигателя
     *
     * @return текущая мощность двигателя, %
     */
    int getPower();
}