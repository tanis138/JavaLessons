package com.tanis138.cardealer.entity;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Cloneable {
    public static Comparator<Car> brandComparator = Comparator.comparing(a -> a.model.getBrand().name());
    public static Comparator<Car> modelComparator = Comparator.comparing(a -> a.model.name());
    public static Comparator<Car> brandAndModelComparator = brandComparator.thenComparing(modelComparator);

    private static int cnt = 0;

    private final CarModel model;
    private final CarFuel fuel;
    private final CarGearbox gearbox;
    private final int year;
    private final boolean isUsed;
    private final int id;

    private int price = 0;


    public Car(CarModel model, CarFuel fuel, CarGearbox gearbox, int year, boolean isUsed) {
        if (model == null) {
            throw new IllegalArgumentException("Car model cannot be null");
        }
        this.model = model;

        if (fuel == null) {
            throw new IllegalArgumentException("Car fuel type cannot be null");
        }
        this.fuel = fuel;

        if (gearbox == null) {
            throw new IllegalArgumentException("Car gearbox type cannot be null");
        }
        this.gearbox = gearbox;

        if (year == 0) {
            throw new IllegalArgumentException("Car year cannot be negative");
        }
        this.year = year;

        this.isUsed = isUsed;

        id = ++cnt;
    }

    public Car(CarModel model, CarFuel fuel, CarGearbox gearbox, int year, boolean isUsed, int price) {
        this(model, fuel, gearbox, year, isUsed);
        setPrice(price);
    }


    public static int getMaxId() {
        return cnt;
    }

    public CarModel getModel() {
        return model;
    }

    public CarFuel getFuel() {
        return fuel;
    }

    public CarGearbox getGearbox() {
        return gearbox;
    }

    public int getYear() {
        return year;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String isUsedStr() {
        return isUsed ? "used" : "new";
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public final void setPrice(int price) {
//        if (price < 0) {
//            throw new IllegalArgumentException("Car price cannot be negative");
//        }
        this.price = Math.max(price, 0);
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                isUsed == car.isUsed &&
                model == car.model &&
                fuel == car.fuel &&
                gearbox == car.gearbox;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, fuel, gearbox, year, isUsed);
    }

    @Override
    public String toString() {
        return String.format("%d %s (%s, %s) [%s] - $%d",
                year, model, fuel, gearbox, isUsedStr(), price);
    }

    public String toStringUnique() {
        return String.format("%d %s (%s, %s)",
                year, model, fuel, gearbox);
    }
}
