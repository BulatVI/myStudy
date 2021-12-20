package com.stepik.functionalProgramming.Lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*In this task you need to create the xor operation using all of and, or and not.
There are several ways how to get it but the simplest one is just to follow the formula: A or B, but not(A and B).*/

public class Exclusive_OR_Predicate {
    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return t -> predicate1.and(predicate2.negate()).or(predicate2.and(predicate1.negate())).test(t); // write your code here
        //return t -> predicate1.test(t) ^ predicate2.test(t);
        //return p1.or(p2).and(p1.and(p2).negate());
    }

    public static void main(String[] args) {
        System.out.println(xor(n -> true, n -> false).test("Пётр петрович"));
        System.out.println(xor(n -> false, n -> true).test(false));
        System.out.println(xor(n -> true, n -> true).test(23));
        System.out.println(xor(n -> false, n -> false).test(23));
        //List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        //list.f
    }
}
