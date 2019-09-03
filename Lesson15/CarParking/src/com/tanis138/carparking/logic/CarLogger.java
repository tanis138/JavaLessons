package com.tanis138.carparking.logic;

import java.time.LocalTime;

public class CarLogger {
    synchronized public static void log(String line) {
        System.out.printf("%s: ", LocalTime.now());
        System.out.println(line);
    }
}
