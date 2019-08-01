package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarGenerator;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseGenerate extends MenuScreenWork {
    public ScrWarehouseGenerate(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_GENERATE, scanner, warehouse);
    }

    @Override
    public int display() {
        int n;
        do {
            System.out.print("Input warehouse count (1..10) or 0 to return: ");
            try {
                n = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                n = -1;
            }
        } while (n < 0 || n > 10);

        if (n == 0) {
            return 0;
        }

        System.out.print("Input cars count for each warehouse using space as separator: ");
        int[] carsCount = new int[n];
        int i = 0;
        while (i < n) {
            try {
                carsCount[i] = Integer.parseInt(scanner.next());
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Cars count must be a number! Try again.");
                return 0;
            }
        }

        System.out.println();
        warehouse.addWarehouses(CarGenerator.generateWarehouses(carsCount));
        CarPrinter.printGlobalWarehouse(warehouse, true);
        System.out.println();

        //displayTypeZeroToReturn();

        return 0;
    }
}
