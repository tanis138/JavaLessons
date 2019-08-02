package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.*;
import com.tanis138.cardealer.logic.CarFilter;
import com.tanis138.cardealer.logic.CarPrinter;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreenWork;

import java.util.ArrayList;
import java.util.Scanner;

public class ScrCarsCustomFilter extends MenuScreenWork {
    public ScrCarsCustomFilter(Scanner scanner, GlobalWarehouse warehouse) throws IllegalArgumentException {
        super(MenuId.CARS_CUSTOM_FILTER, scanner, warehouse);
    }

    @Override
    public int display() {
        if (warehouse.carCount() == 0) {
            System.out.println("Nothing to filter! First, add cars/warehouses.");
            return 0;
        }

        System.out.println("Input car filter using the following mask:");
        System.out.println("param1=value1; param2=value2; ... paramN=valueN");
        System.out.println();
        System.out.println("Params:  y- year, y1 - yearFom, y2 - yearTo, p - price, p1 - priceFom, p2 - priceTo,");
        System.out.println("         b - brand, m - model, t - type (u-used|n-new|a-all),");
        System.out.println("         g - gearbox (a-auto|m-manual), f - fuel (p-petrol|d-diesel)");
        System.out.println("Example: y1=2015;p2=20000;g=a;f=p;t=n;m=A3");
        System.out.println("Result:  New Audi A3 (AT, petrol) with price <= $20000 and year >= 2015");
        System.out.println();

        // skip newline character from previous input
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (true) {
            System.out.print("Input filter (or 0 to return): ");
            String[] input = scanner.nextLine().toLowerCase().trim().split("[\\s]*[;][\\s]*");
//            System.out.println(Arrays.toString(input));

            if (input.length == 0) {
                continue;
            }

            if (input[0].trim().charAt(0) == '0') {
                return 0;
            }

            int yearFrom = -1, yearTo = -1, priceFrom = -1, priceTo = -1;
            CarType type = null;
            CarBrand brand = null;
            CarModel model = null;
            CarFuel fuel = null;
            CarGearbox gearbox = null;
            boolean isValid = false;

            for (String token : input) {
                String[] par = token.split("[\\s]*[=][\\s]*");
                //System.out.println(Arrays.toString(par));
                if (par.length < 2) {
                    continue;
                }

                String key = par[0].trim();
                String sVal = par[1].trim();
                if (key.length() == 0 || sVal.length() == 0) {
                    continue;
                }

                // parse year|price value
                int iVal = -1;
                if (key.charAt(0) == 'y' || key.charAt(0) == 'p') {
                    try {
                        iVal = Integer.parseInt(par[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Fail to convert y|p param!");
                        continue;
                    }
                    if (iVal < 0) {
                        System.out.println("y|p value cannot be negative!");
                        continue;
                    }
                }

                // parse param
                switch (key) {
                    case "y":
                        yearFrom = yearTo = iVal;
                        isValid = true;
                        break;
                    case "y1":
                        yearFrom = iVal;
                        if (yearTo < 0) {
                            yearTo = Integer.MAX_VALUE;
                        }
                        isValid = true;
                        break;
                    case "y2":
                        yearTo = iVal;
                        if (yearFrom < 0) {
                            yearFrom = 1;
                        }
                        isValid = true;
                        break;
                    case "p":
                        priceFrom = priceTo = iVal;
                        isValid = true;
                        break;
                    case "p1":
                        priceFrom = iVal;
                        if (priceTo < 0) {
                            priceTo = Integer.MAX_VALUE;
                        }
                        isValid = true;
                        break;
                    case "p2":
                        priceTo = iVal;
                        if (priceFrom < 0) {
                            priceFrom = 1;
                        }
                        isValid = true;
                        break;
                    case "t":
                        switch (sVal) {
                            case "u":
                                type = CarType.USED;
                                isValid = true;
                                break;
                            case "n":
                                type = CarType.NEW;
                                isValid = true;
                                break;
                            case "a":
                                type = CarType.ANY;
                                isValid = true;
                                break;
                        }
                        break;
                    case "g":
                        switch (sVal) {
                            case "a":
                                gearbox = CarGearbox.AUTOMATIC;
                                isValid = true;
                                break;
                            case "m":
                                gearbox = CarGearbox.MANUAL;
                                isValid = true;
                                break;
                        }
                        break;
                    case "f":
                        switch (sVal) {
                            case "p":
                                fuel = CarFuel.PETROL;
                                isValid = true;
                                break;
                            case "d":
                                fuel = CarFuel.DIESEL;
                                isValid = true;
                                break;
                        }
                        break;
                    case "b":
                        try {
                            brand = CarBrand.valueOf(sVal.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Unknown brand!");
                            continue;
                        }
                        isValid = true;
                        break;
                    case "m":
                        try {
                            model = CarModel.valueOf(sVal.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Unknown model!");
                            continue;
                        }
                        isValid = true;
                        break;
                }
            }

            //no valid params found
            if (!isValid) {
                System.out.println("Invalid input! Try again.");
                continue;
            }

            // filter cars
            ArrayList<Car> cars = warehouse.getCars();
            cars = CarFilter.filterByModel(cars, model);
            if (model == null) {
                // sort by brand only if not already sorted by model
                cars = CarFilter.filterByBrand(cars, brand);
            }
            if (priceFrom > 0 && priceTo > 0) {
                cars = CarFilter.filterByPrice(cars, priceFrom, priceTo);
            }
            if (yearFrom > 0 && yearTo > 0) {
                cars = CarFilter.filterByYear(cars, yearFrom, yearTo);
            }
            if (type == CarType.NEW) {
                cars = CarFilter.filterByUsed(cars, false);
            } else if (type == CarType.USED) {
                cars = CarFilter.filterByUsed(cars, true);
            }
            cars = CarFilter.filterByGearbox(cars, gearbox);
            cars = CarFilter.filterByFuel(cars, fuel);

            if (cars == null || cars.size() == 0) {
                System.out.println("Nothing found. Try again.");
            } else {
                System.out.println("Filtered cars:");
                CarPrinter.printCars(cars, true);
            }
            System.out.println();
        }
    }
}
