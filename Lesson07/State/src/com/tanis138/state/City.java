package com.tanis138.state;

public class City extends ArealUnit {

    public City(String name, int population) {
        super(name, population);
    }

    @Override
    public String toString() {
        return String.format("%s (pop. %d)", getName(), getPopulation());
    }
}
