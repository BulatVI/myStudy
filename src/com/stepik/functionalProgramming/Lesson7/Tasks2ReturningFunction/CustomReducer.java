package com.stepik.functionalProgramming.Lesson7.Tasks2ReturningFunction;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.*;

class CustomReducer {

    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (Integer x, IntBinaryOperator y) ->
                    (IntBinaryOperator) (left, right) ->
                            IntStream.rangeClosed(left, right).reduce(x, (a, b) -> y.applyAsInt(a,b));
                            //IntStream.rangeClosed(left, right).reduce(x, y);

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (a, b) -> a + b);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = // write your code here
            reduceIntOperator.apply(1, (a, b) -> a * b);


    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");

        int l = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        int sumReducer = reduceIntOperator.apply(0, Integer::sum).applyAsInt(l, r);
        int sum = sumOperator.applyAsInt(l, r);

        int prodReducer = reduceIntOperator.apply(1, (x, y) -> x * y).applyAsInt(l, r);
        int prod = productOperator.applyAsInt(l, r);

        System.out.printf("%d %d %d %d%n", sumReducer, sum, prodReducer, prod);
    }
}
