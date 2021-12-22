package com.stepik.functionalProgramming.Lesson4;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
The objects will be sorted according to the following rules:

If one range is longer than others, then it is the larger in the sorting order.
If several ranges have the same length, the smaller is the one with the smaller left border.
The sorting goes in the ascending order.

*/
public class LongRangeMain {
    public static void main(String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());
        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));

        numbers.forEach(System.out::println);
        /*2 4
        3 5
        1 4
        0 5
        1 7*/
    }
}

class LongRange {
    private final long left;
    private final long right;

    public static Comparator<LongRange> getComparator() {
        // write your code here
        /*return (o1, o2) -> {
            long i =  (o1.getRight() - o1.getLeft() - o2.getRight() + o2.getLeft());
            if (i == 0) i = o1.left - o2.left;
            return (int) i;
        };*/
        return Comparator.comparing(LongRange::getCapacity).thenComparing(LongRange::getLeft);
        //return Comparator.comparing((LongRange y) -> Math.abs(y.right - y.left)) .thenComparingLong(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }

    public long getCapacity() {
        return Math.abs(right - left);
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);
    }
}