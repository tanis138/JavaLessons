package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.Warehouse;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseAdd extends MenuScreenWork {
    public ScrWarehouseAdd(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_ADD, scanner, warehouse);
    }

    @Override
    public int display() {
        // skip newline character from previous input
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        System.out.print("Input warehouse name: ");
        String name = scanner.nextLine();

        System.out.print("Input warehouse address: ");
        String address = scanner.nextLine();
        System.out.println();

        warehouse.addWarehouse(new Warehouse(name, address));
        System.out.println("New warehouse successfully added.");

        //displayTypeZeroToReturn();

        return 0;
    }
}
