package com.tanis138.cardealer.menu;

import java.util.Objects;

public class MenuItem {
    private final String caption;
    private final MenuId link;

    public MenuItem(String caption, MenuId link) {
        this.caption = caption != null ? caption : "";
        this.link = link;
    }

    public String caption() {
        return caption;
    }

    public MenuId link() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return caption.equals(menuItem.caption) &&
                link == menuItem.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, link);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "caption='" + caption + '\'' +
                ", link=" + link +
                '}';
    }
}
