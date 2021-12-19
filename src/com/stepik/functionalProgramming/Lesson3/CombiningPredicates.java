package com.stepik.functionalProgramming.Lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        // write your code here
        //return n -> ... ;
        if (predicates.size() == 0) return n -> true;
        IntPredicate a = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            a = a.and(predicates.get(i));
        }
        return a;

        /*IntPredicate base = n -> true;
        for (IntPredicate temp: predicates) {
            base = base.and(temp);
        }
        return base;*/

        //return predicates.stream().reduce((s, p500) -> s.and(p500)).orElse(z -> true);
        //return predicates.stream().reduce(IntPredicate::and).orElse(n -> true);
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));
        //System.out.println("88888");
        System.out.println(conjunctAll(predicates).test(0));
        //System.out.println("99999");
    }
}
