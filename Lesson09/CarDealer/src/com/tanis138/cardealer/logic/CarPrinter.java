package com.tanis138.cardealer.logic;

import com.tanis138.cardealer.entity.GlobalWarehouse;
import com.tanis138.cardealer.entity.Car;
import com.tanis138.cardealer.entity.Warehouse;

import java.util.List;
import java.util.Map;

public class CarPrinter {
    public static void printCars(List<Car> cars, boolean isPrintLineNumbers) {
        if (cars == null || cars.size() == 0) {
            return;
        }

        if (isPrintLineNumbers) {
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("%3d) %s\n", i + 1, cars.get(i));
            }
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public static void printUniqueCars(Map<Car, Integer> cars, boolean isPrintLineNumbers, boolean isPrintSingle) {
        if (cars == null || cars.size() == 0) {
            return;
        }

        int i = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            // skip single values
            if (!isPrintSingle && entry.getValue() == 1) {
                continue;
            }

            if (isPrintLineNumbers) {
                System.out.printf("%3d) %s - x%d\n", ++i, entry.getKey().toStringUnique(), entry.getValue());
            } else {
                System.out.printf("%s - x%d\n", entry.getKey().toStringUnique(), entry.getValue());
            }
        }
    }

    public static void printWarehouse(Warehouse warehouse, boolean isPrintCars) {
        if (warehouse == null) {
            return;
        }

        String str = warehouse.toString();

        if (isPrintCars) {
            str += ':';
            System.out.println(str);

            for (int i = 0; i < warehouse.size(); i++) {
                System.out.printf("%3d) %s\n", i + 1, warehouse.get(i));
            }
        } else {
            System.out.println(str);
        }

    }

    public static void printGlobalWarehouse(GlobalWarehouse globalWarehouse, boolean isPrintCars) {
        if (globalWarehouse == null) {
            return;
        }

        String str = globalWarehouse.toString();

        int cnt = globalWarehouse.warehouseCount();
        if (cnt > 0) {
            str += ':';
            System.out.println(str);

            for (int i = 0; i < cnt; i++) {
                printWarehouse(globalWarehouse.getWarehouse(i), isPrintCars);
            }
        } else {
            System.out.println(str);
        }

    }
}
