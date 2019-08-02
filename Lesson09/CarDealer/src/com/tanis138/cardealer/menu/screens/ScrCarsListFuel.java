package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarFuel;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListFuel extends MenuScreenWork {
    private CarType carType;
    private CarFuel fuel;

    public ScrCarsListFuel(Scanner scanner, GlobalWarehouse warehouse, CarType carType, CarFuel fuel) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_PETROL, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("CarType cannot be null!");
        }
        this.carType = carType;

        if (fuel == null) {
            throw new IllegalArgumentException("CarFuel cannot be null!");
        }
        this.fuel = fuel;
        caption = (fuel == CarFuel.PETROL) ? "Petrol cars" : "Diesel cars";

        switch (carType) {
            case NEW:
                id = (fuel == CarFuel.PETROL) ? MenuId.NEW_CARS_LIST_PETROL : MenuId.NEW_CARS_LIST_DIESEL;
                break;
            case USED:
                id = (fuel == CarFuel.PETROL) ? MenuId.USED_CARS_LIST_PETROL : MenuId.USED_CARS_LIST_DIESEL;
                break;
            case ANY:
                id = (fuel == CarFuel.PETROL) ? MenuId.ALL_CARS_LIST_PETROL : MenuId.ALL_CARS_LIST_DIESEL;
                break;
        }
    }

    @Override
    public int display() {
        System.out.println(caption + ":");

        ArrayList<Car> cars = CarFilter.filterByFuel(warehouse.getCars(carType), fuel);
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
