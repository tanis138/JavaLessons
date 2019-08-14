package com.tanis138.cardealer.entity;

public enum CarBrand {
    AUDI, PORSCHE, VOLKSWAGEN;

    @Override
    public String toString() {
        return Character.toUpperCase(name().charAt(0)) + name().substring(1).toLowerCase();
    }
}
