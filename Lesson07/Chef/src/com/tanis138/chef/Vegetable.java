package com.tanis138.chef;

import java.util.Objects;

public class Vegetable {

    public static final int GRAM_100 = 100;
    private final VegName name;

    private int weightG;

    public Vegetable(VegName name, int weightG) {
        this.name = (name != null) ? name : VegName.UNDEFINED;
        this.weightG = (weightG >= 0) ? weightG : 0;
    }

    public VegName getName() {
        return name;
    }

    public double getKcal100G() {
        return name.getKcal100G();
    }

    public double getProteins100G() {
        return name.getProteins100G();
    }

    public double getFats100G() {
        return name.getFats100G();
    }

    public double getCarbs100G() {
        return name.getCarbs100G();
    }

    public int getWeightG() {
        return weightG;
    }

    public void setWeightG(int weightG) {
        this.weightG = (weightG >= 0) ? weightG : 0;
    }

    public double getKcal() {
        return weightG * getKcal100G() / GRAM_100;
    }

    public double getProteins() {
        return weightG * getProteins100G() / GRAM_100;
    }

    public double getFats() {
        return weightG * getFats100G() / GRAM_100;
    }

    public double getCarbs() {
        return weightG * getCarbs100G() / GRAM_100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable vegetable = (Vegetable) o;
        return weightG == vegetable.weightG &&
                name == vegetable.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weightG);
    }

    @Override
    public String toString() {
        return String.format("%s: %dg", name.toString().toLowerCase(), weightG);
        //return String.format("%s (%sg)\tnutrition [energy: %.1fkcal\tproteins: %.1fg\tfats: %.1fg\tcarbs: %.1fg]",
        //        name.toString().toLowerCase(), weightG, getKcal(), getProteins(), getFats(), getCarbs());
    }
}
