package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarTransmission;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListTransmission extends MenuScreenWork {
    private CarType carType;
    private CarTransmission transmission;

    public ScrCarsListTransmission(Scanner scanner, GlobalWarehouse warehouse, CarType carType, CarTransmission transmission) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_AT, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("CarType cannot be null!");
        }
        this.carType = carType;

        if (transmission == null) {
            throw new IllegalArgumentException("CarTransmission cannot be null!");
        }
        this.transmission = transmission;
        caption = (transmission == CarTransmission.AUTOMATIC) ? "AT cars" : "MT cars";

        switch (carType) {
            case NEW:
                id = (transmission == CarTransmission.AUTOMATIC) ? MenuId.NEW_CARS_LIST_AT : MenuId.NEW_CARS_LIST_MT;
                break;
            case USED:
                id = (transmission == CarTransmission.AUTOMATIC) ? MenuId.USED_CARS_LIST_AT : MenuId.USED_CARS_LIST_MT;
                break;
            case ANY:
                id = (transmission == CarTransmission.AUTOMATIC) ? MenuId.ALL_CARS_LIST_AT : MenuId.ALL_CARS_LIST_MT;
                break;
        }
    }

    @Override
    public int display() {
        System.out.println(caption + ":");

        ArrayList<Car> cars = CarFilter.filterByTransmission(warehouse.getCars(carType), transmission);
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
