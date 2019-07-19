package com.tanis138.state;

import java.util.Objects;

public class State extends ArealUnitComposite<Region> {
    private City capitalCity;

    public State(String name, Region[] regions, City capitalCity) {
        super(name, regions);

        setCapitalCity(capitalCity);
    }

    public int getRegionsCount() {
        Region[] regions = getArealUnits();
        return (regions == null) ? 0 : regions.length;
    }

    public Region[] getRegions() {
        return getArealUnits();
    }

    public final void setRegions(Region[] regions) {
        setArealUnits(regions);

        // try to re-assign centerCity after change of districts
        if (capitalCity != null) {
            if (!setCapitalCity(capitalCity)) {
                capitalCity = null;
            }
        }
    }

    public City getCapitalCity() {
        return capitalCity;
    }

    public final boolean setCapitalCity(City capitalCity) {
        Region[] regions = getArealUnits();
        if (regions == null || capitalCity == null) {
            return false;
        }

        if (Objects.equals(this.capitalCity, capitalCity)) {
            return true;
        }

        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                City[] cities = district.getCities();
                if (cities == null) {
                    continue;
                }
                for (City city : cities) {
                    if (city.equals(capitalCity)) {
                        this.capitalCity = capitalCity;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        if (!super.equals(o)) return false;
        State state = (State) o;
        return Objects.equals(capitalCity, state.capitalCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capitalCity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s (%.1f km2): [\n", getName(), getAreaKm2()));

        sb.append(String.format("  Capital city - %s", capitalCity));
        for (Region region : getArealUnits()) {
            sb.append(String.format("\n%s", region));
        }
        sb.append("]\n");

        return sb.toString();
    }
}
