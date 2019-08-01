package com.tanis138.cardealer.logic;

import com.tanis138.cardealer.entity.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class CarGenerator {
    private static final String WAREHOUSE_NAME = "Warehouse ";
    private static final String WAREHOUSE_ADDRESS = "Address";

    private static boolean generateBoolean() {
        return new Random().nextBoolean();
    }

    private static int generateInt(int bound) {
        return new Random().nextInt(bound);
    }

    private static int generateInt(int from, int toInclusive) {
        if (from > toInclusive) {
            from = toInclusive;
        }
        return from + new Random().nextInt(toInclusive - from + 1);
    }


    public static Car generateCar(boolean isUsed) {
        int i;

        i = generateInt(CarModel.values().length);
        CarModel model = CarModel.values()[i];

        i = generateInt(CarFuel.values().length);
        CarFuel fuel = CarFuel.values()[i];

        i = generateInt(CarTransmission.values().length);
        CarTransmission transmission = CarTransmission.values()[i];

        int year, yearFrom, yearTo = Calendar.getInstance().get(Calendar.YEAR);
        if (isUsed) {
            yearFrom = yearTo - 10;
            yearTo -= 3;
        } else {
            yearFrom = yearTo - 1;
        }
        year = generateInt(yearFrom, yearTo);

        int price, priceFrom = 0, priceTo = 0;
        switch (model.getBrand()) {
            case AUDI:
                priceFrom = 200;
                priceTo = 800;
                break;
            case PORSCHE:
                priceFrom = 500;
                priceTo = 1500;
                break;
            case VOLKSWAGEN:
                priceFrom = 80;
                priceTo = 400;
                break;
        }
        if (isUsed) {
            priceFrom /= 2;
            priceTo /= 3;
        }
        price = generateInt(priceFrom, priceTo) * 100;

        return new Car(model, fuel, transmission, year, isUsed, price);
    }

    public static Car generateCar() {
        return generateCar(generateBoolean());
    }

    public static ArrayList<Car> generateCars(int count) {
        if (count <= 0) {
            return null;
        }

        ArrayList<Car> cars = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            cars.add(generateCar());
        }

        return cars;
    }

    public static ArrayList<Car> generateCars(int count, boolean isUsed) {
        if (count <= 0) {
            return null;
        }

        ArrayList<Car> cars = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            cars.add(generateCar(isUsed));
        }

        return cars;
    }


    public static Warehouse generateWarehouse(int warehouseNum, int carCount) {
        Warehouse warehouse = new Warehouse(WAREHOUSE_NAME + warehouseNum,
                WAREHOUSE_ADDRESS + warehouseNum, carCount);

        warehouse.addAll(generateCars(carCount));

        return warehouse;
    }

    public static Warehouse generateWarehouse(int warehouseNum, int carCount, boolean isUsed) {
        Warehouse warehouse = new Warehouse(WAREHOUSE_NAME + warehouseNum,
                WAREHOUSE_ADDRESS + warehouseNum, carCount);

        warehouse.addAll(generateCars(carCount, isUsed));

        return warehouse;
    }

    public static ArrayList<Warehouse> generateWarehouses(int[] carsCount) {
        if (carsCount == null || carsCount.length == 0) {
            return null;
        }

        ArrayList<Warehouse> warehouses = new ArrayList<>(carsCount.length);
        for (int i = 0; i < carsCount.length; i++) {
            warehouses.add(generateWarehouse(i + 1, carsCount[i]));
        }

        return warehouses;
    }
}
