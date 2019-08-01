package com.tanis138.cardealer.logic;

import com.tanis138.cardealer.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarFilter {
    private static ArrayList<Car> filter(ArrayList<Car> cars, Predicate<? super Car> predicate) {
        if (cars == null) {
            return null;
        }

        return cars.stream()
                .filter(predicate)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Map<Car, Integer> filterUnique(ArrayList<Car> cars) {
        if (cars == null) {
            return null;
        }

        Map<Car, Integer> freqMap = new HashMap<>(cars.size());
        for (Car car : cars) {
            freqMap.merge(car, 1, Integer::sum);
        }

        return freqMap;
    }

    public static ArrayList<Car> filterByBrand(ArrayList<Car> cars, final CarBrand brand) {
        return filter(cars, e -> e.getModel().getBrand() == brand);
    }

    public static ArrayList<Car> filterByModel(ArrayList<Car> cars, final CarModel model) {
        return filter(cars, e -> e.getModel() == model);
    }

    public static ArrayList<Car> filterByFuel(ArrayList<Car> cars, final CarFuel fuel) {
        return filter(cars, e -> e.getFuel() == fuel);
    }

    public static ArrayList<Car> filterByTransmission(ArrayList<Car> cars, final CarTransmission transmission) {
        return filter(cars, e -> e.getTransmission() == transmission);
    }

    public static ArrayList<Car> filterByYear(ArrayList<Car> cars, final int yearFrom, final int yearTo) {
        final int min = Math.min(yearFrom, yearTo);
        final int max = Math.max(yearFrom, yearTo);

        return filter(cars, e -> min <= e.getYear() && e.getYear() <= max);
    }

    public static ArrayList<Car> filterByUsed(ArrayList<Car> cars, final boolean isUsed) {
        return filter(cars, e -> e.isUsed() == isUsed);
    }

    public static ArrayList<Car> filterByPrice(ArrayList<Car> cars, final int minPrice, final int maxPrice) {
        final int min = Math.min(minPrice, maxPrice);
        final int max = Math.max(minPrice, maxPrice);

        return filter(cars, e -> min <= e.getPrice() && e.getPrice() <= max);
    }

}
