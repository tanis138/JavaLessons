package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.entity.CarType;
import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuItem;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrCars extends MenuScreen {
    private static final String LIST_ALL = "List all";
    private static final String LIST_BY_BRAND = "List by brand";
    private static final String LIST_BY_MODEL = "List by model";
    private static final String LIST_PETROL = "List petrol";
    private static final String LIST_DIESEL = "List diesel";
    private static final String LIST_AT = "List AT";
    private static final String LIST_MT = "List MT";
    private static final String LIST_IDENTICAL = "List identical";

    public ScrCars(Scanner scanner, CarType carType) throws IllegalArgumentException {
        super(MenuId.ALL_CARS, scanner);

        if (carType == null) {
            throw new IllegalArgumentException("carType cannot be null!");
        }

        switch (carType) {
            case NEW:
                caption = "New cars";
                id = MenuId.NEW_CARS;
                items = new MenuItem[]{
                        new MenuItem(LIST_ALL, MenuId.NEW_CARS_LIST_ALL),
                        new MenuItem(LIST_BY_BRAND, MenuId.NEW_CARS_LIST_BRAND),
                        new MenuItem(LIST_BY_MODEL, MenuId.NEW_CARS_LIST_MODEL),
                        new MenuItem(LIST_PETROL, MenuId.NEW_CARS_LIST_PETROL),
                        new MenuItem(LIST_DIESEL, MenuId.NEW_CARS_LIST_DIESEL),
                        new MenuItem(LIST_AT, MenuId.NEW_CARS_LIST_AT),
                        new MenuItem(LIST_MT, MenuId.NEW_CARS_LIST_MT),
                        new MenuItem(LIST_IDENTICAL, MenuId.NEW_CARS_LIST_IDENTICAL),
                };
                break;
            case USED:
                caption = "Used cars";
                id = MenuId.USED_CARS;
                items = new MenuItem[]{
                        new MenuItem(LIST_ALL, MenuId.USED_CARS_LIST_ALL),
                        new MenuItem(LIST_BY_BRAND, MenuId.USED_CARS_LIST_BRAND),
                        new MenuItem(LIST_BY_MODEL, MenuId.USED_CARS_LIST_MODEL),
                        new MenuItem(LIST_PETROL, MenuId.USED_CARS_LIST_PETROL),
                        new MenuItem(LIST_DIESEL, MenuId.USED_CARS_LIST_DIESEL),
                        new MenuItem(LIST_AT, MenuId.USED_CARS_LIST_AT),
                        new MenuItem(LIST_MT, MenuId.USED_CARS_LIST_MT),
                };
                break;
            case ANY:
                caption = "All cars";
                items = new MenuItem[]{
                        new MenuItem(LIST_ALL, MenuId.ALL_CARS_LIST_ALL),
                        new MenuItem(LIST_BY_BRAND, MenuId.ALL_CARS_LIST_BRAND),
                        new MenuItem(LIST_BY_MODEL, MenuId.ALL_CARS_LIST_MODEL),
                        new MenuItem(LIST_PETROL, MenuId.ALL_CARS_LIST_PETROL),
                        new MenuItem(LIST_DIESEL, MenuId.ALL_CARS_LIST_DIESEL),
                        new MenuItem(LIST_AT, MenuId.ALL_CARS_LIST_AT),
                        new MenuItem(LIST_MT, MenuId.ALL_CARS_LIST_MT),
                        new MenuItem(LIST_IDENTICAL, MenuId.ALL_CARS_LIST_IDENTICAL),
                };
                break;
        }
    }
}
