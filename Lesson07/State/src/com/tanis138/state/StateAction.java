package com.tanis138.state;

public class StateAction {
    public static State generateState() {
        Region[] regions = new Region[6];
        District[] districts;
        City[] cities;

        City centerCity, capitalCity;

        // minsk region
        districts = new District[2];
        centerCity = capitalCity = new City("Minsk", 1_982_444);
        cities = new City[]{centerCity, new City("Zaslawye", 15_661)};
        districts[0] = new District("Minsk district", 1_902.66, cities);
        cities = new City[]{new City("Dzyarzhynsk", 67_360), new City("Fanipal", 16_644)};
        districts[1] = new District("Dzyarzhynsk district", 1_189.50, cities);
        regions[0] = new Region("Minsk region", districts, centerCity);

        // Gomel region
        districts = new District[2];
        centerCity = new City("Gomel", 535_693);
        cities = new City[]{centerCity};
        districts[0] = new District("Gomel district", 1_951.4, cities);
        cities = new City[]{new City("Mazyr", 133_437)};
        districts[1] = new District("Mazyr district", 1_189.50, cities);
        regions[1] = new Region("Gomel region", districts, centerCity);

        // Mogilev region
        districts = new District[2];
        centerCity = new City("Mogilev", 383_313);
        cities = new City[]{centerCity};
        districts[0] = new District("Mogilev district", 1_895.40, cities);
        cities = new City[]{new City("Babruysk", 217_546)};
        districts[1] = new District("Babruysk district", 1_599.05, cities);
        regions[2] = new Region("Mogilev region", districts, centerCity);

        // Vitebsk region
        districts = new District[2];
        centerCity = new City("Vitebsk", 378_459);
        cities = new City[]{centerCity};
        districts[0] = new District("Vitebsk district", 2_737.85, cities);
        cities = new City[]{new City("Myory", 7896), new City("Dzisna", 1537)};
        districts[1] = new District("Myory district", 1_786.64, cities);
        regions[3] = new Region("Vitebsk region", districts, centerCity);

        // Grodno region
        districts = new District[2];
        centerCity = new City("Grodno", 373_547);
        cities = new City[]{centerCity, new City("Skidzyel", 10_717)};
        districts[0] = new District("Grodno district", 2_594.05, cities);
        cities = new City[]{new City("Masty", 15_838)};
        districts[1] = new District("Masty district", 1_342.04, cities);
        regions[4] = new Region("Grodno region", districts, centerCity);

        // Brest region
        districts = new District[2];
        centerCity = new City("Brest", 373_547);
        cities = new City[]{centerCity};
        districts[0] = new District("Brest district", 1_544.11, cities);
        cities = new City[]{new City("Pinsk", 137_961)};
        districts[1] = new District("Pinsk district", 3_252.77, cities);
        regions[5] = new Region("Brest region", districts, centerCity);


        // Belarus
        return new State("Belarus", regions, capitalCity);
    }

    public static void printStateInfo(State state) {
        if (state == null) {
            return;
        }

        System.out.printf("%s: area=%.0f km2, regions=%d, capital=%s\n",
                state.getName(), state.getAreaKm2(), state.getRegionsCount(), state.getCapitalCity().getName());

        StringBuilder sb = new StringBuilder(String.format("Regional centres: "));
        for (Region region : state.getRegions()) {
            if (region.getCenterCity() == null) {
                continue;
            }
            sb.append(region.getCenterCity());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }
}
