package com.tanis138.carparking.entity;

import com.tanis138.carparking.logic.CarLogger;

import java.util.Objects;

public class Car implements Runnable {
    public static final int DEFAULT_DELAY_MS = 100;

    private final String licensePlateNumber;
    private int waitCount;
    private int stayCount;

    private Parking parking;

    public Car(String licensePlateNumber, int waitCount, int stayCount, Parking parking) throws IllegalArgumentException {
        if (licensePlateNumber == null) {
            throw new IllegalArgumentException("Car: licensePlateNumber cannot be null!");
        }
        this.licensePlateNumber = licensePlateNumber;

        if (waitCount <= 0) {
            throw new IllegalArgumentException("Car: waitCount must be a positive number!");
        }
        this.waitCount = waitCount;

        if (stayCount <= 0) {
            throw new IllegalArgumentException("Car: stayCount must be a positive number!");
        }
        this.stayCount = stayCount;

        this.parking = parking;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public int getWaitCount() {
        return waitCount;
    }

    public int getStayCount() {
        return stayCount;
    }

    public Parking getParking() {
        return parking;
    }

    @Override
    public void run() {
        if (parking == null) {
            return;
        }

        Thread t = Thread.currentThread();

        // trying to park the car
        while (waitCount > 0 && !t.isInterrupted()) {
            if (parking.parkCar(this)) {
                break;
            }

            waitCount--;

            try {
                Thread.sleep(DEFAULT_DELAY_MS);
            } catch (InterruptedException e) {
                CarLogger.log(String.format("Thread \"%s\" has been interrupted.", t.getName()));
                return;
            }
        }

        // if parking failed
        if (waitCount == 0) {
            CarLogger.log(String.format("Car [%s] LEFT WITHOUT PARKING!", getLicensePlateNumber()));
            return;
        }

        // staying on the parking
        while (stayCount > 0 && !t.isInterrupted()) {
            stayCount--;

            try {
                Thread.sleep(DEFAULT_DELAY_MS);
            } catch (InterruptedException e) {
                CarLogger.log(String.format("Thread \"%s\" has been interrupted.", t.getName()));
                return;
            }
        }

        // leaving the parking
        parking.removeCar(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return waitCount == car.waitCount &&
                stayCount == car.stayCount &&
                licensePlateNumber.equals(car.licensePlateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlateNumber, waitCount, stayCount);
    }

    @Override
    public String toString() {
        return String.format("Car %s (waitCount: %d, stayCount: %d)", licensePlateNumber, waitCount, stayCount);
    }
}
