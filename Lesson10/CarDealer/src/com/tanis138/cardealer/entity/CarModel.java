package com.tanis138.cardealer.entity;

public enum CarModel {
    A3(CarBrand.AUDI), A4(CarBrand.AUDI), A6(CarBrand.AUDI), Q3(CarBrand.AUDI), Q5(CarBrand.AUDI), Q7(CarBrand.AUDI),

    PANAMERA(CarBrand.PORSCHE), MACAN(CarBrand.PORSCHE), CAYENNE(CarBrand.PORSCHE),

    POLO(CarBrand.VOLKSWAGEN), JETTA(CarBrand.VOLKSWAGEN), PASSAT(CarBrand.VOLKSWAGEN), TIGUAN(CarBrand.VOLKSWAGEN),
    TUAREG(CarBrand.VOLKSWAGEN);

    private final CarBrand brand;

    CarModel(CarBrand brand) {
        this.brand = brand;
    }

    public CarBrand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("%s %c%s",
                brand, Character.toUpperCase(name().charAt(0)), name().substring(1).toLowerCase());
    }
}
