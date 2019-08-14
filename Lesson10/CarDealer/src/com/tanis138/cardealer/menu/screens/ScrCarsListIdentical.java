package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ScrCarsListIdentical extends MenuScreenWork {
    private CarType carType;

    public ScrCarsListIdentical(Scanner scanner, GlobalWarehouse warehouse, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_IDENTICAL, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }
        this.carType = carType;

        switch (carType) {
            case NEW:
                id = MenuId.NEW_CARS_LIST_IDENTICAL;
                break;
            case USED:
                //id = MenuId.USED_CARS_LIST_IDENTICAL;
                break;
            case ANY:
                break;
        }
    }

    @Override
    public int display() {
        System.out.println("List of identical cars");

        ArrayList<Car> cars = warehouse.getCars(carType);
        Map<Car, Integer> uniqueCars = CarFilter.filterUnique(cars);
        if (uniqueCars != null && uniqueCars.size() > 0) {
            CarPrinter.printUniqueCars(uniqueCars, true, false);
        } else {
            System.out.println("Nothing to list!\n");
            return 0;
        }
        System.out.println();

        displayTypeZeroToReturn();

        return 0;
    }
}
