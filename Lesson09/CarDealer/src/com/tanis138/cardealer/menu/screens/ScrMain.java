package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuItem;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrMain extends MenuScreen {
    public ScrMain(Scanner scanner) throws IllegalArgumentException {
        super(MenuId.MAIN, scanner);

        caption = "Main menu";

        items = new MenuItem[]{
                new MenuItem("Warehouse", MenuId.WAREHOUSE),
                new MenuItem("All cars", MenuId.ALL_CARS),
                new MenuItem("New cars", MenuId.NEW_CARS),
                new MenuItem("Used cars", MenuId.USED_CARS),
        };
    }
}
