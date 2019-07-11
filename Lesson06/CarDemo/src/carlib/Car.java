package carlib;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Класс "Автомобиль"
 * 
 * @author tanis138
 * @version 1.0
 */
public class Car extends Vehicle {
    /** Комплектация автомобиля */
    private final String trimLevel;

    /**
     * Конструктор Автомобиля
     * 
     * @param brand     Марка ТС
     * @param model     Модель ТС
     * @param trimLevel Комплектация
     * @param mfd       Дата производства ТС
     * @param iEngine   Интерфейс двигателя
     */
    public Car(String brand, String model, String trimLevel, GregorianCalendar mfd, IEngine iEngine) {
        super(brand, model, mfd, iEngine);
        this.trimLevel = Objects.requireNonNull(trimLevel, "brand must not be null");
    }

    /** Получает комплектацию автомобиля */
    public String getTrimLevel() {
        return trimLevel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(trimLevel);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        return Objects.equals(trimLevel, other.trimLevel);
    }

    @Override
    public String toString() {
        String strMfd = String.format("%02d.%02d.%d", mfd.get(Calendar.DATE), mfd.get(Calendar.MONTH) + 1,
                mfd.get(Calendar.YEAR));
        return String.format("Автомобиль: %s %s (комплектация %s)%nДата выпуска: %s%n%s", brand, model,
                trimLevel, strMfd, iEngine.toString());

        // return "Car [brand=" + brand + ", model=" + model + ", trimLevel=" +
        // trimLevel + ", mfd=" + strMfd + "]\n"
        // + iEngine;
    }
}