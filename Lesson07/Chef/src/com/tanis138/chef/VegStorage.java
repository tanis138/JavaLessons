package com.tanis138.chef;

import java.util.Arrays;

public class VegStorage {
    private int[] vegWeightsG;

    public VegStorage() {
        vegWeightsG = new int[VegName.values().length];
    }

    public boolean add(Vegetable veg) {
        if (veg == null || veg.getName() == null || veg.getName() == VegName.UNDEFINED) {
            return false;
        }

        vegWeightsG[veg.getName().ordinal()] += veg.getWeightG();
        return true;
    }

    public boolean get(VegName vegName, int weightG) {
        if (vegName == null || vegName == VegName.UNDEFINED) {
            return false;
        }

        if (vegWeightsG[vegName.ordinal()] >= weightG) {
            vegWeightsG[vegName.ordinal()] -= weightG;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAvailable(VegName vegName, int weightG) {
        if (vegName == null || vegName == VegName.UNDEFINED) {
            return false;
        }

        return vegWeightsG[vegName.ordinal()] >= weightG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VegStorage)) return false;
        VegStorage that = (VegStorage) o;
        return Arrays.equals(vegWeightsG, that.vegWeightsG);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vegWeightsG);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VegStorage [");

        for (int i = 0; i < vegWeightsG.length; i++) {
            if (vegWeightsG[i] > 0) {
                sb.append(String.format("%s: %dg, ", VegName.values()[i].toString().toLowerCase(), vegWeightsG[i]));
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') sb.delete(sb.length() - 2, sb.length());
        sb.append(']');

        return sb.toString();
    }
}
