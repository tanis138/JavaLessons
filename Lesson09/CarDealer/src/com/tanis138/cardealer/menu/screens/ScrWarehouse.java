package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuItem;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrWarehouse extends MenuScreen {
    public ScrWarehouse(Scanner scanner) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE, scanner);

        caption = "Warehouse";

        items = new MenuItem[]{
                new MenuItem("List", MenuId.WAREHOUSE_LIST),
                new MenuItem("Generate", MenuId.WAREHOUSE_GENERATE),
                new MenuItem("Add", MenuId.WAREHOUSE_ADD),
                new MenuItem("Delete", MenuId.WAREHOUSE_DELETE),
                new MenuItem("Add car", MenuId.WAREHOUSE_ADD_CAR),
                new MenuItem("Delete car", MenuId.WAREHOUSE_DELETE_CAR),
        };
    }
}
