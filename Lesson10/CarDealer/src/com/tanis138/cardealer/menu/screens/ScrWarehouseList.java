package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseList extends MenuScreenWork {
    public ScrWarehouseList(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_LIST, scanner, warehouse);
    }

    @Override
    public int display() {
        CarPrinter.printGlobalWarehouse(warehouse, true);
        System.out.println();

        displayTypeZeroToReturn();

        return 0;
    }
}
