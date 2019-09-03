package com.tanis138.carparking.entity;

import com.tanis138.carparking.logic.CarLogger;

import java.util.Objects;

public class Parking {
    private final String name;
    private final int totalPlaces;

    private int usedPlaces;


    public Parking(String name, int totalPlaces) throws IllegalArgumentException{
        if (name == null) {
            throw new IllegalArgumentException("Parking: name cannot be null!");
        }
        this.name = name;

        if (totalPlaces <= 0) {
            throw new IllegalArgumentException("Parking: waitCount must be a positive number!");
        }
        this.totalPlaces = totalPlaces;

        usedPlaces = 0;
    }


    public String getName() {
        return name;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public int getUsedPlaces() {
        return usedPlaces;
    }

    public int getFreePlaces() {
        return totalPlaces - usedPlaces;
    }


    synchronized public boolean parkCar(Car car) {
        if (usedPlaces == totalPlaces || car == null) {
            return false;
        }

        usedPlaces++;

        CarLogger.log(String.format("Car [%s] parked. Free places: %d", car.getLicensePlateNumber(), getFreePlaces()));

        return true;
    }

    synchronized public void removeCar(Car car) {
        if (usedPlaces == 0 || car == null) {
            return;
        }

        usedPlaces--;

        CarLogger.log(String.format("Car [%s] left.   Free places: %d", car.getLicensePlateNumber(), getFreePlaces()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return totalPlaces == parking.totalPlaces &&
                usedPlaces == parking.usedPlaces &&
                name.equals(parking.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPlaces, usedPlaces);
    }

    @Override
    public String toString() {
        return String.format("Parking %s (total places: %d, used places: %d)", name, totalPlaces, usedPlaces);
    }
}
