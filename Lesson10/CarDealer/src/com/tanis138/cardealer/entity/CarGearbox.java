package com.tanis138.cardealer.entity;

public enum CarGearbox {
    AUTOMATIC("AT"), MANUAL("MT");

    private final String abbr;

    CarGearbox(String abbr) {
        this.abbr = abbr;
    }

    @Override
    public String toString() {
//        return name().toLowerCase();
        return abbr;
    }
}
