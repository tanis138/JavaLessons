package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseDelete extends MenuScreenWork {
    public ScrWarehouseDelete(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_DELETE, scanner, warehouse);
    }

    @Override
    public int display() {
        int cnt = warehouse.warehouseCount();
        if (cnt == 0) {
            System.out.println("There are no warehouses to delete!");

            //displayTypeZeroToReturn();

            return 0;
        }

        while (true) {
            cnt = warehouse.warehouseCount();
            if (cnt == 0) {
                return 0;
            }

            CarPrinter.printGlobalWarehouse(warehouse, false);
            System.out.println();

            int i;
            do {
                System.out.printf("Input warehouse number to delete (1..%d) or 0 to return: ", cnt);
                try {
                    i = Integer.parseInt(scanner.next());
                } catch (NumberFormatException e) {
                    i = -1;
                }
            } while (i < 0 || i > cnt);

            if (i == 0) {
                return 0;
            }

            if (warehouse.removeWarehouse(i - 1)) {
                System.out.println("The warehouse was successfully deleted.");
            } else {
                System.out.println("Failed to delete the warehouse!");
            }
        }
    }
}
