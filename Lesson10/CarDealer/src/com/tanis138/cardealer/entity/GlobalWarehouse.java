package com.tanis138.cardealer.entity;

import com.tanis138.cardealer.exceptions.CarIdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class GlobalWarehouse {
    private static final int DEFAULT_CAPACITY = 5;

    private final ArrayList<Warehouse> warehouses;


    public GlobalWarehouse(int capacity) {
        capacity = (capacity > 0) ? capacity : DEFAULT_CAPACITY;
        warehouses = new ArrayList<>(capacity);
    }

    public GlobalWarehouse() {
        this(DEFAULT_CAPACITY);
    }


    // Warehouse routine
    public boolean addWarehouse(Warehouse warehouse) {
        return warehouse != null && warehouses.add(warehouse);
    }

    public boolean addWarehouses(List<Warehouse> warehouses) {
        return warehouses != null && this.warehouses.addAll(warehouses);
    }

    public boolean removeWarehouse(Warehouse warehouse) {
        return warehouses.remove(warehouse);
    }

    public boolean removeWarehouse(int warehouseInd) {
        try {
            warehouses.remove(warehouseInd);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public Warehouse getWarehouse(int warehouseInd) {
        Warehouse res;

        try {
            res = warehouses.get(warehouseInd);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

        return res;
    }

    public boolean clearWarehouse(int warehouseInd) {
        try {
            warehouses.get(warehouseInd).clear();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public void clearWarehouses() {
        warehouses.clear();
    }

    public int warehouseCount() {
        return warehouses.size();
    }


    // Car routine
    public boolean addCar(Car car, int warehouseInd) {
        if (car == null) {
            return false;
        }

        Warehouse currWarehouse = getWarehouse(warehouseInd);

        if (currWarehouse == null) {
            return false;
        }

        return currWarehouse.add(car);
    }

    public boolean addCar(Car car, Warehouse warehouse) {
        return addCar(car, warehouses.indexOf(warehouse));
    }

    public Car removeCar(int carId) throws CarIdNotFoundException {
        Car car;

        for (Warehouse warehouse : warehouses) {
            try {
                car = warehouse.remove(carId);
            } catch (CarIdNotFoundException e) {
                continue;
            }
            return car;
        }

        throw new CarIdNotFoundException("Invalid car id", carId);
    }

    public boolean removeCar(Car car) throws CarIdNotFoundException {
        return car != null && removeCar(car.getId()) != null;
    }

    public int carCount() {
        int count = 0;

        for (Warehouse warehouse : warehouses) {
            count += warehouse.size();
        }

        return count;
    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> res = new ArrayList<>(carCount());

        for (Warehouse warehouse : warehouses) {
            res.addAll(warehouse.getCars());
        }
        res.trimToSize();

        return res;
    }

    public ArrayList<Car> getCars(boolean fUsed) {
        ArrayList<Car> res = new ArrayList<>(carCount());

        for (Warehouse warehouse : warehouses) {
            res.addAll(warehouse.getCars(fUsed));
        }
        res.trimToSize();

        return res;
    }

    public ArrayList<Car> getCars(CarType carType) {
        ArrayList<Car> res = new ArrayList<>(carCount());

        for (Warehouse warehouse : warehouses) {
            res.addAll(warehouse.getCars(carType));
        }
        res.trimToSize();

        return res;
    }


    @Override
    public String toString() {
        return String.format("Global Warehouse - %d car(s)", carCount());
    }
}
