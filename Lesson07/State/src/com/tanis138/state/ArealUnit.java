package com.tanis138.state;

import java.util.Objects;

public abstract class ArealUnit {
    private String name;
    private int population;
    private double areaKm2;

    public ArealUnit(String name) {
        setName(name);
    }

    public ArealUnit(String name, int population) {
        setName(name);
        setPopulation(population);
    }

    public ArealUnit(String name, double areaKm2) {
        setName(name);
        setAreaKm2(areaKm2);
    }

    public ArealUnit(String name, int population, double areaKm2) {
        setName(name);
        setPopulation(population);
        setAreaKm2(areaKm2);
    }


    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = StrUtils.capitalizeFirstLetter(name);
    }

    public int getPopulation() {
        return population;
    }

    public final void setPopulation(int population) {
        if (population < 0) {
            population = 0;
        }
        this.population = population;
    }

    public double getAreaKm2() {
        return areaKm2;
    }

    public final void setAreaKm2(double areaKm2) {
        this.areaKm2 = areaKm2 < 0 ? 0 : areaKm2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArealUnit)) return false;
        ArealUnit arealUnit = (ArealUnit) o;
        return population == arealUnit.population &&
                Double.compare(arealUnit.areaKm2, areaKm2) == 0 &&
                Objects.equals(name, arealUnit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, areaKm2);
    }

    @Override
    public String toString() {
        return "ArealUnit{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", areaKm2=" + areaKm2 +
                '}';
    }
}
