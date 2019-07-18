package com.tanis138.interval;

public class IntervalRunner {

    public static void main(String[] args) {
        Interval i1, i2;

        System.out.println("Intervals Union Test:");
        i1 = new Interval(0, false, 3, true);
        i2 = new Interval(4, true, 7, true);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 3, false);
        i2 = new Interval(3, true, 7, true);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 3, false);
        i2 = new Interval(3, false, 7, true);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 4, false);
        i2 = new Interval(3, false, Double.POSITIVE_INFINITY, true);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 7, false);
        i2 = new Interval(3, false, 7, false);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 7, true);
        i2 = new Interval(3, false, 7, false);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(Double.NEGATIVE_INFINITY, false, 7, true);
        i2 = new Interval(0, false, 8, false);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(0, false, 3, true);
        i2 = new Interval(0, false, 2, false);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        i1 = new Interval(3, false, 3, false);
        i2 = new Interval(3, false, 7, false);
        System.out.printf("%s ∪ %s = %s\n", i1, i2, IntervalAction.joinIntervals(i1, i2));

        System.out.println();

        System.out.println("Intervals Intersection Test:");
        i1 = new Interval(0, false, 3, false);
        i2 = new Interval(4, false, 7, false);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, false, 3, true);
        i2 = new Interval(3, false, 7, false);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, false, 3, true);
        i2 = new Interval(3, true, 7, false);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, false, 5, true);
        i2 = new Interval(0, true, 2, true);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, true, 5, false);
        i2 = new Interval(0, false, 7, true);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, true, 5, false);
        i2 = new Interval(0, false, 5, true);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, true, 5, true);
        i2 = new Interval(2, false, 7, true);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, true, 5, true);
        i2 = new Interval(2, false, 5, false);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        i1 = new Interval(0, true, Double.POSITIVE_INFINITY, true);
        i2 = new Interval(-5, false, 3, true);
        System.out.printf("%s ∩ %s = %s\n", i1, i2, IntervalAction.intersectIntervals(i1, i2));

        System.out.println();

        // generate and print Intervals
        Interval[] intervals = IntervalAction.generateIntervals(5);
        IntervalAction.printIntervals(intervals);

        // calculate maximal distance
        System.out.printf("The distance of intervals array is %.0f\n", IntervalAction.getDistance(intervals));

    }
}
