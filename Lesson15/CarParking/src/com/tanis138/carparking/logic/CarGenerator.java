package com.tanis138.carparking.logic;

import com.tanis138.carparking.entity.Car;
import com.tanis138.carparking.entity.Parking;

import java.util.Random;

public class CarGenerator {
    private static final int MAX_NUM = 10_000;
    private static final int MIN_REGION = 1;
    private static final int MAX_REGION = 7;
    private static final char[] NUM_LETTERS = {'А', 'В', 'Е', 'І', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'Х'};
//    private static final int LETTER_A_CODE = 0x41;
//    private static final int LETTER_Z_CODE = 0x5A;

    private static final int MAX_WAIT_COUNT = 15;
    private static final int MAX_STAY_COUNT = 10;

    private static int generateInt(int bound) {
        return new Random().nextInt(bound);
    }

    private static int generateInt(int from, int toInclusive) {
        if (from > toInclusive) {
            from = toInclusive;
        }
        return from + new Random().nextInt(toInclusive - from + 1);
    }

    private static char generateChar() {
        return NUM_LETTERS[generateInt(NUM_LETTERS.length)];
    }

    private static String generateLicensePlateNumber() {
        return String.format("%04d %c%c-%d", generateInt(MAX_NUM), generateChar(), generateChar(),
                generateInt(MIN_REGION, MAX_REGION));
    }

    public static Car generateCar(Parking parking) {
        return new Car(generateLicensePlateNumber(),
                generateInt(1, MAX_WAIT_COUNT), generateInt(1, MAX_STAY_COUNT), parking);
    }
}
