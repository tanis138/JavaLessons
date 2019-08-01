package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.CarModel;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsListModel extends MenuScreenWork {
    private CarType carType;

    public ScrCarsListModel(Scanner scanner, GlobalWarehouse warehouse, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS_LIST_MODEL, scanner, warehouse);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }
        this.carType = carType;

        switch (carType) {
            case NEW:
                id = MenuId.NEW_CARS_LIST_MODEL;
                break;
            case USED:
                id = MenuId.USED_CARS_LIST_MODEL;
                break;
            case ANY:
                break;
        }
    }

    @Override
    public int display() {
        while (true) {
            // skip newline character from previous input
//            if (scanner.hasNextLine()) {
//                scanner.nextLine();
//            }

            System.out.print("Input model name without brand name (or 0 to return): ");
            CarModel model;
            String input = scanner.next().trim();
            if (input.equals("0")) {
                return 0;
            }

            try {
                model = CarModel.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown model!");
                continue;
            }

            ArrayList<Car> cars = CarFilter.filterByModel(warehouse.getCars(carType), model);
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
