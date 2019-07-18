package com.tanis138.interval;

import java.util.Random;

public class IntervalAction {

    public static final int VALUE_FROM = -9;
    public static final int VALUE_TO = 10;

    public static Interval joinIntervals(Interval i1, Interval i2) {
        IntervalPoint a, b;

        // sort intervals by left point
        if (i1.getA().value > i2.getA().value) {
            Interval tmp = i1;
            i1 = i2;
            i2 = tmp;
        }

        final IntervalPoint a1 = i1.getA();
        final IntervalPoint b1 = i1.getB();
        final IntervalPoint a2 = i2.getA();
        final IntervalPoint b2 = i2.getB();

        // calculate left point of joined interval
        if (a1.value != a2.value) {
            // a1 < a2
            a = a1;
        } else {
            // a1 = a2
            // (a1.. ∪ [a1.. = [a1..
            a = (a1.isIncluded) ? a1 : a2;
        }

        // calculate right point of joined interval
        if (b1.value > a2.value) {
            if (b1.value > b2.value) {
                b = b1;
            } else if (b1.value < b2.value) {
                b = b2;
            } else {
                // b1 = b2
                // ..b1) ∪ ..b1] = b1]
                b = (b1.isIncluded) ? b1 : b2;
            }
        } else if (b1.value < a2.value) {
            // ..b1) ∪ (a2.. = null
            return null;
        } else {
            // b1 = a2
            if (b1.isIncluded || a2.isIncluded) {
                b = b2;
            } else {
                // ..b1) ∪ (b1.. = null
                return null;
            }
        }

        return new Interval(a, b);
    }

    public static Interval intersectIntervals(Interval i1, Interval i2) {
        IntervalPoint a, b;

        // sort intervals by left point
        if (i1.getA().value > i2.getA().value) {
            Interval tmp = i1;
            i1 = i2;
            i2 = tmp;
        }

        final IntervalPoint a1 = i1.getA();
        final IntervalPoint b1 = i1.getB();
        final IntervalPoint a2 = i2.getA();
        final IntervalPoint b2 = i2.getB();

        // calculate left point of intersected interval
        if (a1.value != a2.value) {
            // a1 < a2
            if (a2.value < b1.value) {
                a = a2;
            } else if (a2.value > b1.value) {
                // a2 > b1: ..b1) ∩ (a2.. = null
                return null;
            } else {
                // a2 = b1
                if (a2.isIncluded && b1.isIncluded) {
                    // ..b1] ∩ [b1.. = [b1]
                    a = b1;
                    return new Interval(a, a);
                } else {
                    // ..b1) ∩ (b1.. = null
                    return null;
                }
            }
        } else {
            // a1= a2
            // (a1.. ∩ [a1.. = (a1..
            a = (!a1.isIncluded) ? a1 : a2;
        }

        // calculate right point of intersected interval
        if (b1.value > b2.value) {
            b = b2;
        } else if (b1.value < b2.value) {
            b = b1;
        } else {
            b = b1;
            b.isIncluded = b1.isIncluded & b2.isIncluded;
        }

        return new Interval(a, b);
    }

    public static double getDistance(Interval[] intervals) {
        double minA = Double.POSITIVE_INFINITY;
        double maxB = Double.NEGATIVE_INFINITY;

        if (intervals == null) {
            return 0;
        }

        for (Interval interval : intervals) {
            minA = Math.min(minA, interval.getA().value);
            minA = Math.min(minA, interval.getB().value);
            maxB = Math.max(maxB, interval.getA().value);
            maxB = Math.max(maxB, interval.getB().value);
        }
        return maxB - minA;
    }

    public static void printIntervals(Interval[] intervals) {
        if (intervals == null) {
            System.out.println("Intervals array is empty!");
            return;
        }
        System.out.printf("Intervals Array (%d): \n", intervals.length);
        for (Interval interval : intervals) {
            System.out.printf("%s, ", interval);
        }
        System.out.println();
    }

    public static Interval[] generateIntervals(final int INTERVALS_COUNT) {
        Interval[] intervals = new Interval[INTERVALS_COUNT];

        for (int i = 0; i < INTERVALS_COUNT; i++) {
            double aValue = generateNumber(VALUE_FROM, VALUE_TO);
            boolean aIncluded = new Random().nextBoolean();

            double bValue = generateNumber(-9, 10);
            boolean bIncluded = new Random().nextBoolean();

            intervals[i] = new Interval(aValue, aIncluded, bValue, bIncluded);
        }

        return intervals;
    }

    private static double generateNumber(int from, int to) {
        if (from > to) {
            from = to;
        }
        return (double) (from + new Random().nextInt(to - from));
    }
}
