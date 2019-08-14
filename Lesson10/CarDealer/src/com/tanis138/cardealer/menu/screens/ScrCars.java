package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrCars extends MenuScreen {
    public ScrCars(Scanner scanner, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS, scanner);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }

        switch (carType) {
            case NEW:
                id = MenuId.NEW_CARS;
                items = new MenuId[]{
                        MenuId.NEW_CARS_LIST_ALL,
                        MenuId.NEW_CARS_LIST_BRAND,
                        MenuId.NEW_CARS_LIST_MODEL,
                        MenuId.NEW_CARS_LIST_PETROL,
                        MenuId.NEW_CARS_LIST_DIESEL,
                        MenuId.NEW_CARS_LIST_AT,
                        MenuId.NEW_CARS_LIST_MT,
                        MenuId.NEW_CARS_LIST_IDENTICAL,
                };
                break;
            case USED:
                id = MenuId.USED_CARS;
                items = new MenuId[]{
                        MenuId.USED_CARS_LIST_ALL,
                        MenuId.USED_CARS_LIST_BRAND,
                        MenuId.USED_CARS_LIST_MODEL,
                        MenuId.USED_CARS_LIST_PETROL,
                        MenuId.USED_CARS_LIST_DIESEL,
                        MenuId.USED_CARS_LIST_AT,
                        MenuId.USED_CARS_LIST_MT,
                };
                break;
            case ANY:
                items = new MenuId[]{
                        MenuId.ALL_CARS_LIST_ALL,
                        MenuId.ALL_CARS_LIST_BRAND,
                        MenuId.ALL_CARS_LIST_MODEL,
                        MenuId.ALL_CARS_LIST_PETROL,
                        MenuId.ALL_CARS_LIST_DIESEL,
                        MenuId.ALL_CARS_LIST_AT,
                        MenuId.ALL_CARS_LIST_MT,
                        MenuId.ALL_CARS_LIST_IDENTICAL,
                };
                break;
        }
    }
}
