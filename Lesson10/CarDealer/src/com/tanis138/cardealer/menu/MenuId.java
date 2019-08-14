package com.tanis138.cardealer.menu;

public enum MenuId {
    MAIN("Main menu"),
    WAREHOUSE("Warehouse"), WAREHOUSE_LIST("List"), WAREHOUSE_GENERATE("Generate"),
    WAREHOUSE_ADD("Add"), WAREHOUSE_DELETE("Delete"), WAREHOUSE_ADD_CAR("Add car"),
    WAREHOUSE_DELETE_CAR("Delete car"), WAREHOUSE_DELETE_CAR_BY_ID("Delete car by id"),

    ALL_CARS("All cars"), ALL_CARS_LIST_ALL("List all"), ALL_CARS_LIST_BRAND("List by brand"),
    ALL_CARS_LIST_MODEL("List by model"), ALL_CARS_LIST_PETROL("List petrol"), ALL_CARS_LIST_DIESEL("List diesel"),
    ALL_CARS_LIST_AT("List AT"), ALL_CARS_LIST_MT("List MT"), ALL_CARS_LIST_IDENTICAL("List identical"),

    NEW_CARS("New cars"), NEW_CARS_LIST_ALL("List all"), NEW_CARS_LIST_BRAND("List by brand"),
    NEW_CARS_LIST_MODEL("List by model"), NEW_CARS_LIST_PETROL("List petrol"), NEW_CARS_LIST_DIESEL("List diesel"),
    NEW_CARS_LIST_AT("List AT"), NEW_CARS_LIST_MT("List MT"), NEW_CARS_LIST_IDENTICAL("List identical"),

    USED_CARS("Used cars"), USED_CARS_LIST_ALL("List all"), USED_CARS_LIST_BRAND("List by brand"),
    USED_CARS_LIST_MODEL("List by model"), USED_CARS_LIST_PETROL("List petrol"), USED_CARS_LIST_DIESEL("List diesel"),
    USED_CARS_LIST_AT("List AT"), USED_CARS_LIST_MT("List MT"),

    CARS_CUSTOM_FILTER("Custom filter");

    private final String caption;

    MenuId(String caption) {
        this.caption = caption;
    }

    public String caption() {
        return caption;
    }
}
