package carlib;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarDemo {
    public static void main(String[] args) throws Exception {
        GasEngine bmwEngine1600 = new GasEngine(1600, 100, 6000);
        ElectricEngine teslaEngine300 = new ElectricEngine(300);

        Car bmw316 = new Car("BMW", "316i", "Base", new GregorianCalendar(1998, Calendar.DECEMBER, 07), bmwEngine1600);
        Car teslaX = new Car("Tesla", "Model X", "Luxe", new GregorianCalendar(), teslaEngine300);

        Vehicle vh = bmw316;
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                vh = teslaX;
            }
            System.out.println(vh);
            vh.turnOn();
            vh.start(20);
            vh.changeAcceleration(80);
            vh.stop();
            vh.turnOff();
            System.out.println();
        }
    }
}