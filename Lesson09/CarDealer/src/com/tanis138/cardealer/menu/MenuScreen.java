package com.tanis138.cardealer.menu;

import java.util.Objects;
import java.util.Scanner;

public abstract class MenuScreen {
    protected final Scanner scanner;

    protected MenuId id;
    protected MenuItem[] items = null;
    protected String caption = null;

    public MenuScreen(MenuId id, Scanner scanner) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Menu id cannot be null!");
        }
        this.id = id;

        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null!");
        }
        this.scanner = scanner;

        //this.warehouse = warehouse;
    }

    public MenuId id() {
        return id;
    }

    public MenuItem[] items() {
        return items;
    }

    public int getMaxChoice() {
        return items != null ? items.length : 0;
    }

    public MenuId getNextId(int choice) {
        if (items == null || choice < 1 || choice > items.length) {
            return null;
        }

        return items[choice - 1].link();
    }

    public int display() {
        if (caption != null) {
            System.out.println(caption + ":");
        }

        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%2d. %s\n", i + 1, items[i].caption());
            }
            System.out.println();

            return items.length;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuScreen that = (MenuScreen) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
