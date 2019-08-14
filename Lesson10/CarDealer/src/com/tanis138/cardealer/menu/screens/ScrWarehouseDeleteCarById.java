package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.exceptions.CarIdNotFoundException;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseDeleteCarById extends MenuScreenWork {
    public ScrWarehouseDeleteCarById(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_DELETE_CAR_BY_ID, scanner, warehouse);
    }

    @Override
    public int display() {
        if (warehouse.carCount() == 0) {
            System.out.println("There are no cars in the warehouse!");

            //displayTypeZeroToReturn();

            return 0;
        }

        while (true) {
            int maxId = Car.getMaxId();
            int id;
            do {
                System.out.printf("Input car Id to delete (1..%d) or 0 to return: ", maxId);
                try {
                    id = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    id = -1;
                }
            } while (id < 0 || id > maxId);

            if (id == 0) {
                return 0;
            }

            try {
                Car car = warehouse.removeCar(id);
                System.out.println("The Car was successfully deleted:");
                System.out.println(car);
            } catch (CarIdNotFoundException e) {
                System.out.printf("Failed to delete the car - %s\n", e.getMessage());
            }

            System.out.println();
        }
    }
}
