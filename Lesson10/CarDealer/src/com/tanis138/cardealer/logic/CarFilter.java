package com.tanis138.cardealer.logic;

import com.tanis138.cardealer.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
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
        return brand != null ? filter(cars, e -> e.getModel().getBrand() == brand) : cars;
    }

    public static ArrayList<Car> filterByModel(ArrayList<Car> cars, final CarModel model) {
        return model != null ? filter(cars, e -> e.getModel() == model) : cars;
    }

    public static ArrayList<Car> filterByFuel(ArrayList<Car> cars, final CarFuel fuel) {
        return fuel != null ? filter(cars, e -> e.getFuel() == fuel) : cars;
    }

    public static ArrayList<Car> filterByGearbox(ArrayList<Car> cars, final CarGearbox gearbox) {
        return gearbox != null ? filter(cars, e -> e.getGearbox() == gearbox) : cars;
    }

    public static ArrayList<Car> filterByUsed(ArrayList<Car> cars, final boolean isUsed) {
        return filter(cars, e -> e.isUsed() == isUsed);
    }

    public static ArrayList<Car> filterByYear(ArrayList<Car> cars, final int yearFrom, final int yearTo) {
        final int min = Math.min(yearFrom, yearTo);
        final int max = Math.max(yearFrom, yearTo);

        return filter(cars, e -> (min <= e.getYear() && e.getYear() <= max));
    }

    public static ArrayList<Car> filterByPrice(ArrayList<Car> cars, final int minPrice, final int maxPrice) {
        final int min = Math.min(minPrice, maxPrice);
        final int max = Math.max(minPrice, maxPrice);

        return filter(cars, e -> (min <= e.getPrice() && e.getPrice() <= max));
    }

    public static void sort(ArrayList<Car> cars, CarSort sort, boolean isReversed) {
        if (cars == null || sort == null) {
            return;
        }

        Comparator<Car> comparator;
        switch (sort) {
            case BRAND:
                comparator = Car.brandComparator;
                break;
            case MODEL:
                comparator = Car.brandAndModelComparator;
                break;
            case PRICE:
                comparator = Comparator.comparing(Car::getPrice);
                break;
            case YEAR:
                comparator = Comparator.comparing(Car::getYear);
                break;
            default:
                return;
        }

        cars.sort(isReversed ? comparator.reversed() : comparator);
    }
}
