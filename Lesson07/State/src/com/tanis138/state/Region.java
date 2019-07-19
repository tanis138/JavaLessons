package com.tanis138.state;

import java.util.Objects;

public class Region extends ArealUnitComposite<District> {
    private City centerCity;

    public Region(String name, District[] districts, City centerCity) {
        super(name, districts);

        setCenterCity(centerCity);
    }

    public District[] getDistricts() {
        return getArealUnits();
    }

    public final void setDistricts(District[] districts) {
        setArealUnits(districts);

        // try to re-assign centerCity after change of districts
        if (centerCity != null) {
            if (!setCenterCity(centerCity)) {
                centerCity = null;
            }
        }
    }

    public City getCenterCity() {
        return centerCity;
    }

    public final boolean setCenterCity(City centerCity) {
        District[] districts = getArealUnits();

        if (districts == null || centerCity == null) {
            return false;
        }

        if (Objects.equals(this.centerCity, centerCity)) {
            return true;
        }

        for (District district : districts) {
            City[] cities = district.getCities();
            if (cities == null) {
                continue;
            }
            for (City city : cities) {
                if (city.equals(centerCity)) {
                    this.centerCity = centerCity;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        if (!super.equals(o)) return false;
        Region region = (Region) o;
        return Objects.equals(centerCity, region.centerCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerCity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("  %s (%.1f km2): [\n", getName(), getAreaKm2()));

        sb.append(String.format("    Center city - %s", centerCity));
        for (District district : getArealUnits()) {
            sb.append(String.format("\n    %s", district));
        }
        sb.append(" ]\n");

        return sb.toString();
    }
}
