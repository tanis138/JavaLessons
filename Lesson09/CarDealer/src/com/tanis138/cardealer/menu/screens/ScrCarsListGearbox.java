package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarGearbox;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListGearbox extends MenuScreenWork {
    private CarType carType;
    private CarGearbox gearbox;

    public ScrCarsListGearbox(Scanner scanner, GlobalWarehouse warehouse, CarType carType, CarGearbox gearbox) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_AT, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("CarType cannot be null!");
        }
        this.carType = carType;

        if (gearbox == null) {
            throw new IllegalArgumentException("CarGearbox cannot be null!");
        }
        this.gearbox = gearbox;
        caption = (gearbox == CarGearbox.AUTOMATIC) ? "AT cars" : "MT cars";

        switch (carType) {
            case NEW:
                id = (gearbox == CarGearbox.AUTOMATIC) ? MenuId.NEW_CARS_LIST_AT : MenuId.NEW_CARS_LIST_MT;
                break;
            case USED:
                id = (gearbox == CarGearbox.AUTOMATIC) ? MenuId.USED_CARS_LIST_AT : MenuId.USED_CARS_LIST_MT;
                break;
            case ANY:
                id = (gearbox == CarGearbox.AUTOMATIC) ? MenuId.ALL_CARS_LIST_AT : MenuId.ALL_CARS_LIST_MT;
                break;
        }
    }

    @Override
    public int display() {
        System.out.println(caption + ":");

        ArrayList<Car> cars = CarFilter.filterByGearbox(warehouse.getCars(carType), gearbox);
        if (cars != null && cars.size() > 0) {
            CarPrinter.printCars(cars, true);
        } else {
            System.out.println("Nothing to list!\n");
            return 0;
        }
        System.out.println();

        displayTypeZeroToReturn();

        return 0;
    }
}
