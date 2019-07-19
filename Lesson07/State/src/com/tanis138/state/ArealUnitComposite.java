package com.tanis138.state;

public abstract class ArealUnitComposite<T extends ArealUnit> extends ArealUnit {
    private T[] arealUnits;

    public ArealUnitComposite(String name, double areaKm2, T[] arealUnits) {
        super(name, areaKm2);

        this.arealUnits = arealUnits;
    }

    public ArealUnitComposite(String name, T[] arealUnits) {
        super(name);

        this.arealUnits = arealUnits;
        setAreaKm2(calcAreaKm2());
    }

    protected T[] getArealUnits() {
        return arealUnits;
    }

    protected void setArealUnits(T[] arealUnits) {
        this.arealUnits = arealUnits;
    }

    private final double calcAreaKm2() {
        if (arealUnits == null) {
            return 0;
        }

        double areaKm2 = 0;
        for (T arealUnit : arealUnits) {
            areaKm2 += arealUnit.getAreaKm2();
        }

        return areaKm2;
    }

}
