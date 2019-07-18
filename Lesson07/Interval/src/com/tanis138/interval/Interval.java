package com.tanis138.interval;

import java.util.Objects;

public class Interval implements Cloneable {
    private IntervalPoint a;
    private IntervalPoint b;
    private IntervalType type;

    public Interval(IntervalPoint a, IntervalPoint b) {
        if (a == null) {
            a = new IntervalPoint(0, true);
        }
        if (b == null) {
            b = new IntervalPoint(0, true);
        }

        if (a.value > b.value) {
            IntervalPoint tmp = a;
            a = b;
            b = tmp;
        } else if (a.value == b.value) {
            a.isIncluded = true;
            b.isIncluded = true;
        }

        this.a = a;
        this.b = b;
        this.type = calcType();
    }

    public Interval(double aValue, boolean aIncluded, double bValue, boolean bIncluded) {
        this(new IntervalPoint(aValue, aIncluded), new IntervalPoint(bValue, bIncluded));
    }

    private IntervalType calcType() {
        IntervalType type;

        if (a.value == b.value) {
            type = IntervalType.DEGENERATE;
        } else {
            if (a.isIncluded) {
                type = (b.isIncluded) ? IntervalType.CLOSED : IntervalType.RIGHT_OPEN;
            } else {
                type = (b.isIncluded) ? IntervalType.LEFT_OPEN : IntervalType.OPEN;
            }
        }

        return type;
    }

    public IntervalPoint getA() {
        return a;
    }

    public IntervalPoint getB() {
        return b;
    }

    public IntervalType getType() {
        return type;
    }

    @Override
    public Interval clone() {
        Interval copy = null;
        try {
            copy = (Interval) super.clone();
            copy.a = (IntervalPoint) a.clone();
            copy.b = (IntervalPoint) b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    @Override
    public String toString() {
        if (a.value == b.value) {
            return String.format("{%.0f}", a.value);
        }

        char chrLeft = (a.isIncluded) ? '[' : '(';
        char chrRight = (b.isIncluded) ? ']' : ')';
        return String.format("%c%.0f, %.0f%c", chrLeft, a.value, b.value, chrRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return Objects.equals(a, interval.a) &&
                Objects.equals(b, interval.b) &&
                type == interval.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, type);
    }
}
