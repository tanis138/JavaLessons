package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrMain extends MenuScreen {
    public ScrMain(Scanner scanner) throws IllegalArgumentException {
        super(MenuId.MAIN, scanner);

        items = new MenuId[]{
                MenuId.WAREHOUSE,
                MenuId.ALL_CARS,
                MenuId.NEW_CARS,
                MenuId.USED_CARS,
                MenuId.CARS_CUSTOM_FILTER,
        };
    }
}
