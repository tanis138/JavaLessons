package com.tanis138.state;

import java.util.Arrays;

public class District extends ArealUnitComposite<City> {
    public District(String name, double areaKm2, City[] cities) {
        super(name, areaKm2, cities);
    }

    public City[] getCities() {
        return getArealUnits();
    }

    public final void setCities(City[] cities) {
        setArealUnits(cities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District)) return false;
        if (!super.equals(o)) return false;
        District district = (District) o;
        return Arrays.equals(getArealUnits(), district.getArealUnits());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getArealUnits());
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f km2): %s", getName(), getAreaKm2(), Arrays.toString(getArealUnits()));
    }
}
