package carlib;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Класс "Транспортное средство"
 * 
 * @author tanis138
 * @version 1.0
 */
public abstract class Vehicle {
    /** Минимальное значение в % */
    public static final int PCNT_MIN = 0;

    /** Максимальное значение в % */
    public static final int PCNT_MAX = 100;

    /** Марка ТС */
    protected final String brand;

    /** Модель ТС */
    protected final String model;

    /** Дата производства ТС */
    protected final GregorianCalendar mfd;

    /** Интерфейс двигателя */
    protected final IEngine iEngine;

    /** Положение педали газа */
    protected int gasPedal;

    /** Положение педали тормоза */
    protected int brakePedal;

    /**
     * Конструктор ТС
     * 
     * @param brand     Марка ТС
     * @param model     Модель ТС
     * @param mfd       Дата производства ТС
     * @param iEngine   Интерфейс двигателя
     */
    public Vehicle(String brand, String model, GregorianCalendar mfd, IEngine iEngine) {
        brakePedal = gasPedal = PCNT_MIN;
        this.brand = Objects.requireNonNull(brand, "brand must not be null");
        this.model = Objects.requireNonNull(model, "model must not be null");
        this.mfd = Objects.requireNonNull(mfd, "mfd must not be null");
        this.iEngine = Objects.requireNonNull(iEngine, "iEngine must not be null");
    }


    protected void setGasPedal(int pcnt) {
        if (pcnt < PCNT_MIN) {
            pcnt = PCNT_MIN;
        }
        if (pcnt > PCNT_MAX) {
            pcnt = PCNT_MAX;
        }
        gasPedal = pcnt;
        System.out.printf("\tПедаль газа: выжата на %d%%\n", gasPedal);
    }

    protected void setBrakePedal(int pcnt) {
        if (pcnt < PCNT_MIN) {
            pcnt = PCNT_MIN;
        }
        if (pcnt > PCNT_MAX) {
            pcnt = PCNT_MAX;
        }
        brakePedal = pcnt;
        System.out.printf("\tПедаль тормоза: выжата на %d%%\n", brakePedal);
    }


    /**
     * Заводит ТС
     *
     * @return true в случае успеха
     */
    public boolean turnOn() {
        System.out.println("Команда: \"завести\":");
        setGasPedal(PCNT_MIN);
        setBrakePedal(PCNT_MAX);
        return iEngine.start();
    }

    /**
     * Глушит ТС
     *
     * @return true в случае успеха
     */
    public boolean turnOff() {
        System.out.println("Команда \"заглушить\":");
        setGasPedal(PCNT_MIN);
        setBrakePedal(PCNT_MIN);
        return iEngine.stop();
    }

    /**
     * Приводит ТС в движение
     *
     * @param throttlePedalPosPcnt положение педали/рычага газа, %
     * @return true в случае успеха
     */
    public boolean start(int throttlePedalPosPcnt) {
        System.out.println("Команда \"начать движение\":");
        setGasPedal(throttlePedalPosPcnt);
        setBrakePedal(PCNT_MIN);
        return iEngine.setPower(throttlePedalPosPcnt);
    }

    /**
     * Изменяет ускорение ТС
     *
     * @param throttlePedalPosPcnt положение педали/рычага газа, %
     * @return true в случае успеха
     */
    public boolean changeAcceleration(int throttlePedalPosPcnt) {
        System.out.println("Команда \"изменить ускорение\":");
        setGasPedal(throttlePedalPosPcnt);
        return iEngine.setPower(throttlePedalPosPcnt);
    }

    /**
     * Останавливает ТС
     *
     * @return true в случае успеха
     */
    public boolean stop() {
        System.out.println("Команда \"остановиться\":");
        setGasPedal(PCNT_MIN);
        setBrakePedal(PCNT_MAX);
        return iEngine.setPower(0);
    }

    /** Получает марку ТС */
    public String getBrand() {
        return brand;
    }

    /** Получает модель ТС */
    public String getModel() {
        return model;
    }

    /** Получает дату производства ТС */
    public GregorianCalendar getMfd() {
        return mfd;
    }

    // /** Получает интерфейс работы с двигателем */
    // public IEngine getiEngine() {
    //     return iEngine;
    // }


    @Override
    public int hashCode() {
        return Objects.hash(brand, iEngine, mfd, model);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        return Objects.equals(brand, other.brand) && Objects.equals(iEngine, other.iEngine)
                && Objects.equals(mfd, other.mfd) && Objects.equals(model, other.model);
    }

    @Override
    public String toString() {
        String strMfd = String.format("%02d.%02d.%d", mfd.get(Calendar.DATE), mfd.get(Calendar.MONTH),
                mfd.get(Calendar.YEAR));
        return "Vehicle [brand=" + brand + ", iEngine=" + iEngine + ", mfd=" + strMfd + ", model=" + model + "]";
    }

}