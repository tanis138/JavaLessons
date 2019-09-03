package com.tanis138.carparking;

import com.tanis138.carparking.entity.Car;
import com.tanis138.carparking.entity.Parking;
import com.tanis138.carparking.logic.CarGenerator;

import java.util.Random;

public class CarParkingRunner {
    private static final int PARKING_PLACES = 3;
    private static final int CAR_COUNT = 20;
    private static final int CAR_GENERATOR_BOUND = 4;

    public static void main(String[] args) {
        final Parking parking = new Parking("#1", PARKING_PLACES);
        System.out.println(parking);

        Thread[] threads = new Thread[CAR_COUNT];
        for (int i = 0; i < CAR_COUNT; i++) {
            Car car = CarGenerator.generateCar(parking);
            threads[i] = new Thread(car, "Car " + car.getLicensePlateNumber());
            threads[i].start();

            try {
                Thread.sleep(new Random().nextInt(CAR_GENERATOR_BOUND) * Car.DEFAULT_DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Parking %s is closed.\n", parking.getName());
    }
}
