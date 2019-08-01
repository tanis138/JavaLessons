package com.tanis138.cardealer.entity;

public enum CarFuel {
    PETROL, DIESEL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
