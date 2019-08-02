package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.*;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.Scanner;

public class ScrWarehouseAddCar extends MenuScreenWork {
    public ScrWarehouseAddCar(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE_ADD_CAR, scanner, warehouse);
    }

    @Override
    public int display() {
        int cnt = warehouse.warehouseCount();
        if (cnt == 0) {
            System.out.println("First, add or generate a warehouse!");

            //displayTypeZeroToReturn();

            return 0;
        }

        while (true) {
            CarPrinter.printGlobalWarehouse(warehouse, false);
            System.out.println();

            int i;
            if (cnt > 1) {
                do {
                    System.out.printf("Input warehouse number to add a car (1..%d) or 0 to return: ", cnt);
                    try {
                        i = Integer.parseInt(scanner.next());
                    } catch (NumberFormatException e) {
                        i = -1;
                    }
                } while (i < 0 || i > cnt);

                if (i == 0) {
                    return 0;
                }
            } else {
                i = 1;
            }

            Warehouse wh = warehouse.getWarehouse(i - 1);

            System.out.println("Input car info using template (or 0 to return): ");
            System.out.println("YEAR BRAND MODEL FUEL GEARBOX USED PRICE");
            System.out.print("BRAND = [ ");
            for (CarBrand brand : CarBrand.values()) {
                System.out.print(brand + " ");
            }
            System.out.println("]");
            System.out.println("FUEL = [ p d ], where p = petroleum, d = diesel");
            System.out.println("GEARBOX = [ m a ], where m = manual, a = automatic");
            System.out.println("USED = [ u n ], where u = used, n = new");
            System.out.println("Example: 2015 Audi A3 d a u 20000");

            // skip newline character from previous input
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            String[] params = scanner.nextLine().trim().split("\\s");
            System.out.println();
            //System.out.println(Arrays.toString(params));

            if (params.length >= 7) {
                int year;
                try {
                    year = Integer.parseInt(params[0]);
                } catch (NumberFormatException e) {
                    System.out.println("YEAR must be a number! Try again.");
                    continue;
                }
                if (year <= 0) {
                    System.out.println("YEAR must be positive! Try again.");
                    continue;
                }

                CarBrand brand;
                try {
                    //noinspection UnusedAssignment
                    brand = CarBrand.valueOf(params[1].toUpperCase().trim());
                } catch (IllegalArgumentException e) {
                    System.out.println("Unknown BRAND! Try again.");
                    continue;
                }

                CarModel model;
                try {
                    model = CarModel.valueOf(params[2].toUpperCase().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Unknown MODEL! Try again.");
                    continue;
                }

                char c = params[3].toLowerCase().charAt(0);
                CarFuel fuel = (c == 'd') ? CarFuel.DIESEL : ((c == 'p') ? CarFuel.PETROL : null);
                if (fuel == null) {
                    System.out.println("Unknown FUEL! Try again.");
                    continue;
                }

                c = params[4].toLowerCase().charAt(0);
                CarGearbox gearbox = (c == 'm') ? CarGearbox.MANUAL : ((c == 'a') ? CarGearbox.AUTOMATIC : null);
                if (gearbox == null) {
                    System.out.println("Unknown FUEL! Try again.");
                    continue;
                }

                c = params[5].toLowerCase().charAt(0);
                boolean isUsed;
                if (c == 'u') {
                    isUsed = true;
                } else if (c == 'n') {
                    isUsed = false;
                } else {
                    System.out.println("Unknown USED! Try again.");
                    continue;
                }

                int price;
                try {
                    price = Integer.parseInt(params[6]);
                } catch (NumberFormatException e) {
                    System.out.println("PRICE must be a number! Try again.");
                    continue;
                }
                if (price <= 0) {
                    System.out.println("PRICE must be positive! Try again.");
                    continue;
                }

                Car car = new Car(model, fuel, gearbox, year, isUsed, price);
                wh.add(car);
                System.out.printf("Success! New car added to warehouse #%d:\n", i);
                System.out.println(car);
                System.out.println();
            } else if (params.length == 1 && params[0].equals("0")) {
                return 0;
            } else {
                System.out.println("Wrong input! Try again.");
            }
        }
    }
}
