package com.tanis138.cardealer.menu;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.CarFuel;
import com.tanis138.cardealer.entity.CarTransmission;
import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.menu.screens.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    //private GlobalWarehouse warehouse;
    private Deque<MenuId> cmdStack;
    private EnumMap<MenuId, MenuScreen> screens;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        GlobalWarehouse warehouse = new GlobalWarehouse();

        MenuScreen scr = new ScrMain(scanner);
        cmdStack = new ArrayDeque<>();
        cmdStack.push(scr.id());

        screens = new EnumMap<>(MenuId.class);

        // MAIN_MENU
        screens.put(scr.id(), scr);
        scr = new ScrWarehouse(scanner);
        screens.put(scr.id(), scr);
        scr = new ScrCars(scanner, CarType.ANY);
        screens.put(scr.id(), scr);
        scr = new ScrCars(scanner, CarType.NEW);
        screens.put(scr.id(), scr);
        scr = new ScrCars(scanner, CarType.USED);
        screens.put(scr.id(), scr);

        // WAREHOUSE
        scr = new ScrWarehouseList(scanner, warehouse);
        screens.put(scr.id(), scr);
        scr = new ScrWarehouseGenerate(scanner, warehouse);
        screens.put(scr.id(), scr);
        scr = new ScrWarehouseAdd(scanner, warehouse);
        screens.put(scr.id(), scr);
        scr = new ScrWarehouseDelete(scanner, warehouse);
        screens.put(scr.id(), scr);
        scr = new ScrWarehouseAddCar(scanner, warehouse);
        screens.put(scr.id(), scr);
        scr = new ScrWarehouseDeleteCar(scanner, warehouse);
        screens.put(scr.id(), scr);

        // ALL_CARS
        scr = new ScrCarsListAll(scanner, warehouse, CarType.ANY);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListBrand(scanner, warehouse, CarType.ANY);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListModel(scanner, warehouse, CarType.ANY);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.ANY, CarFuel.PETROL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.ANY, CarFuel.DIESEL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.ANY, CarTransmission.AUTOMATIC);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.ANY, CarTransmission.MANUAL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListIdentical(scanner, warehouse, CarType.ANY);
        screens.put(scr.id(), scr);

        // NEW_CARS
        scr = new ScrCarsListAll(scanner, warehouse, CarType.NEW);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListBrand(scanner, warehouse, CarType.NEW);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListModel(scanner, warehouse, CarType.NEW);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.NEW, CarFuel.PETROL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.NEW, CarFuel.DIESEL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.NEW, CarTransmission.AUTOMATIC);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.NEW, CarTransmission.MANUAL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListIdentical(scanner, warehouse, CarType.NEW);
        screens.put(scr.id(), scr);

        // USED_CARS
        scr = new ScrCarsListAll(scanner, warehouse, CarType.USED);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListBrand(scanner, warehouse, CarType.USED);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListModel(scanner, warehouse, CarType.USED);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.USED, CarFuel.PETROL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListFuel(scanner, warehouse, CarType.USED, CarFuel.DIESEL);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.USED, CarTransmission.AUTOMATIC);
        screens.put(scr.id(), scr);
        scr = new ScrCarsListTransmission(scanner, warehouse, CarType.USED, CarTransmission.MANUAL);
        screens.put(scr.id(), scr);
    }

    public void run() {
        MenuId mnuId, nextId;
        MenuScreen scr;
        int choice, maxChoice;

        while (true) {
            mnuId = cmdStack.peek() != null ? cmdStack.peek() : MenuId.MAIN;
            scr = screens.get(mnuId);
            if (scr == null) {
                System.out.println("Sorry, but this menu is not implemented...");
                cmdStack.pop();
                continue;
            }
            maxChoice = scr.display();
            if (maxChoice != 0) {
                do {
                    System.out.print("Type menu number (or 0 to return): ");
                    try {
                        choice = Integer.parseInt(scanner.next().trim());
                    } catch (NumberFormatException e) {
                        choice = -1;
                    }
                } while (choice > maxChoice || choice < 0);
            } else {
                choice = 0;
            }
            System.out.println();

            // go back
            if (choice == 0) {
                cmdStack.pop();

                // exit from main menu
                if (mnuId == MenuId.MAIN) {
                    return;
                }

                continue;
            }

            // push chosen id into stack
            nextId = scr.getNextId(choice);
            if (nextId != null) {
                cmdStack.push(nextId);
            }
        }
    }
}
