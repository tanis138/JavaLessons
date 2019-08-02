package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListAll extends MenuScreenWork {
    private CarType carType;

    public ScrCarsListAll(Scanner scanner, GlobalWarehouse warehouse, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_ALL, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }
        this.carType = carType;

        switch (carType) {
            case NEW:
                caption = "List of new cars";
                id = MenuId.NEW_CARS_LIST_ALL;
                break;
            case USED:
                caption = "List of used cars";
                id = MenuId.USED_CARS_LIST_ALL;
                break;
            case ANY:
                caption = "List of all cars";
                break;
        }
    }

    @Override
    public int display() {
        System.out.println(caption + ":");

        ArrayList<Car> cars = warehouse.getCars(carType);
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
