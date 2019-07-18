package com.tanis138.interval;

import java.util.Objects;

public class IntervalPoint implements Cloneable {
    protected final double value;
    protected boolean isIncluded;

    public IntervalPoint(double value, boolean isIncluded) {
        this.value = value;
        if (value == Double.POSITIVE_INFINITY || value == Double.NEGATIVE_INFINITY) {
            isIncluded = false;
        }
        this.isIncluded = isIncluded;
    }

    public double getValue() {
        return value;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "IntervalPoint{" +
                "value=" + value +
                ", isIncluded=" + isIncluded +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalPoint that = (IntervalPoint) o;
        return Double.compare(that.value, value) == 0 &&
                isIncluded == that.isIncluded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isIncluded);
    }
}
