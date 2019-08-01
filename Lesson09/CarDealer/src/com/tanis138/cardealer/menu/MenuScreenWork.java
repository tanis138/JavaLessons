package com.tanis138.cardealer.menu;

import com.tanis138.cardealer.entity.GlobalWarehouse;

import java.util.Scanner;

public abstract class MenuScreenWork extends MenuScreen {
    protected final GlobalWarehouse warehouse;

    public MenuScreenWork(MenuId id, Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(id, scanner);
        this.warehouse = warehouse;
    }

    protected void displayTypeZeroToReturn() {
        int n;
        do {
            System.out.print("Type 0 to return: ");
            try {
                n = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                n = -1;
            }
        } while (n != 0);
    }
}
