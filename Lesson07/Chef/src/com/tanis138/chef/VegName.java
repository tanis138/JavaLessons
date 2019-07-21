package com.tanis138.chef;

public enum VegName {
    UNDEFINED(0,0,0,0),
    CARROT(37.0,1.3,0.1,7.2),
    ONION(41.0,3.4,0.0,9.1),
    CUCUMBER(14.0,0.8,0.1,2.6),
    RADISH(21.0,3.2,0.1,3.8),
    TOMATO(23.0,1.1,0.2,3.8),
    GARLIC(46.0,6.5,0.0,5.2),
    LETTUCE(17.0,0.5,0.2,2.3);

    private double kcal100G;
    private double proteins100G;
    private double fats100G;
    private double carbs100G;

    VegName(double kcal100G, double proteins100G, double fats100G, double carbs100G) {
        this.kcal100G = (kcal100G >= 0) ? kcal100G : 0;
        this.proteins100G = (proteins100G >= 0) ? proteins100G : 0;
        this.fats100G = (fats100G >= 0) ? fats100G : 0;
        this.carbs100G = (carbs100G >= 0) ? carbs100G : 0;
    }

    public double getKcal100G() {
        return kcal100G;
    }

    public double getProteins100G() {
        return proteins100G;
    }

    public double getFats100G() {
        return fats100G;
    }

    public double getCarbs100G() {
        return carbs100G;
    }
}
