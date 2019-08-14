package com.tanis138.cardealer.entity;

public enum CarFuel {
    DIESEL, PETROL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
