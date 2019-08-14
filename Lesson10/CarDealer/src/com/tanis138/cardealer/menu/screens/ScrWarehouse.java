package com.tanis138.cardealer.menu.screens;

import com.tanis138.cardealer.menu.MenuId;
import com.tanis138.cardealer.menu.MenuScreen;

import java.util.Scanner;

public class ScrWarehouse extends MenuScreen {
    public ScrWarehouse(Scanner scanner) throws IllegalArgumentException {
        super(MenuId.WAREHOUSE, scanner);
        items = new MenuId[]{
                MenuId.WAREHOUSE_LIST,
                MenuId.WAREHOUSE_GENERATE,
                MenuId.WAREHOUSE_ADD,
                MenuId.WAREHOUSE_DELETE,
                MenuId.WAREHOUSE_ADD_CAR,
                MenuId.WAREHOUSE_DELETE_CAR,
                MenuId.WAREHOUSE_DELETE_CAR_BY_ID,
        };
    }
}
