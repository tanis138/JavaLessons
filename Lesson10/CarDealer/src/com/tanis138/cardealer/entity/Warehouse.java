package com.tanis138.cardealer.entity;

import com.tanis138.cardealer.exceptions.CarIdNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Warehouse implements Cloneable {
    private static final int DEFAULT_CAPACITY = 20;

    private final String name;
    private final String address;

    private ArrayList<Car> cars;


    public Warehouse(String name, String address, int capacity) {
        this.name = (name != null) ? name : "";
        this.address = (address != null) ? address : "";
        capacity = (capacity > 0) ? capacity : DEFAULT_CAPACITY;
        cars = new ArrayList<>(capacity);
    }

    public Warehouse(String name, String address) {
        this(name, address, DEFAULT_CAPACITY);
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ArrayList<Car> getCars(boolean isUsed) {
        return cars.stream()
                .filter(e -> e.isUsed() == isUsed)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Car> getCars(CarType carType) {
        if (carType == null) {
            return null;
        }

        switch (carType) {
            case NEW:
                return getCars(false);
            case USED:
                return getCars(true);
            case ANY:
                return getCars();
            default:
                return null;
        }
    }


    public boolean add(Car car) {
        return car != null && cars.add(car);
    }

    public boolean addAll(List<Car> cars) {
        return cars != null && this.cars.addAll(cars);
    }

    public Car get(int carId) {
        try {
            return cars.get(carId);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Car remove(int carId) throws CarIdNotFoundException {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == carId) {
                return cars.remove(i);
            }
        }
        throw new CarIdNotFoundException("Invalid car id", carId);
    }

    public boolean remove(Car car) throws CarIdNotFoundException {
        return remove(car.getId()) != null;
    }

    public void clear() {
        cars.clear();
    }

    public int size() {
        return cars.size();
    }


    @Override
    public Warehouse clone() throws CloneNotSupportedException {
        Warehouse copy = (Warehouse) super.clone();

        copy.cars = new ArrayList<>(cars.size());
        for (Car car : cars) {
            copy.cars.add(car.clone());
        }

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse that = (Warehouse) o;
        return name.equals(that.name) &&
                address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d car(s)", name, address, cars.size());
    }
}
