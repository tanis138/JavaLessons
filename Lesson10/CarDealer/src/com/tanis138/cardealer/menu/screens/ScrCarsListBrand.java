package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarBrand;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListBrand extends MenuScreenWork {
    private CarType carType;

    public ScrCarsListBrand(Scanner scanner, GlobalWarehouse warehouse, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_BRAND, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }
        this.carType = carType;

        switch (carType) {
            case NEW:
                id = MenuId.NEW_CARS_LIST_BRAND;
                break;
            case USED:
                id = MenuId.USED_CARS_LIST_BRAND;
                break;
            case ANY:
                break;
        }
    }

    @Override
    public int display() {
        while (true) {
            int i = 0;
            System.out.println("List of brands: ");
            for (CarBrand brand : CarBrand.values()) {
                System.out.printf("%2d. %s\n", ++i, brand);
            }
            System.out.println();

            int cnt = CarBrand.values().length;
            do {
                System.out.printf("Input brand number (1..%d) or 0 to return: ", cnt);
                try {
                    i = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    i = -1;
                }
            } while (i < 0 || i > cnt);

            if (i == 0) {
                return 0;
            }

            ArrayList<Car> cars = CarFilter.filterByBrand(warehouse.getCars(carType), CarBrand.values()[i - 1]);
            if (cars != null && cars.size() > 0) {
                CarPrinter.printCars(cars, true);
            } else {
                System.out.println("Nothing to list!\n");
                continue;
            }
            System.out.println();
        }
    }
}
