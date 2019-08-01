package com.tanis138.cardealer.entity;

public enum CarTransmission {
    MANUAL("MT"), AUTOMATIC("AT");

    private String abbr;

    CarTransmission(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public String toString() {
//        return name().toLowerCase();
        return abbr;
    }
}
