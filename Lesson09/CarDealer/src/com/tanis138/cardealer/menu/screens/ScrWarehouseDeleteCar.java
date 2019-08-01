package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrWarehouseDeleteCar extends MenuScreenWork {
    public ScrWarehouseDeleteCar(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_DELETE_CAR, scanner, warehouse);
    }

    @Override
    public int display() {
        if (warehouse.carCount() == 0) {
            System.out.println("There are no cars in the warehouse!");

            //displayTypeZeroToReturn();

            return 0;
        }

        while (true) {
            int cnt = warehouse.carCount();
            if (cnt == 0) {
                return 0;
            }

            System.out.println("Available cars:");
            ArrayList<Car> cars = warehouse.getCars();
            CarPrinter.printCars(cars, true);
            System.out.println();

            int i;
            do {
                System.out.printf("Input car number to delete (1..%d) or 0 to return: ", cnt);
                try {
                    i = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    i = -1;
                }
            } while (i < 0 || i > cnt);

            if (i == 0) {
                return 0;
            }

            if (warehouse.removeCar(cars.get(i - 1))) {
                System.out.println("The Car was successfully deleted.");
            } else {
                System.out.println("Failed to delete the car.");
            }
            System.out.println();
        }
    }
}
