package com.stepik.functionalProgramming.Lesson3;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface TernaryIntPredicate<T, U, I> {
    // write your code here
    public boolean test(T t, U u, I i);
}

class Main {
    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (t, u, i) -> t != u && t != i && u != i;
        // write a lambda expression here

    public static void main(String[] args) {
        UnaryOperator<Integer> operator = x -> x * 2 + 1;
        int result = operator.compose(operator).apply(10);
        System.out.println(result);


        Predicate<Character> isLetter = Character::isLetter;
        Predicate<Character> isUpperCase = Character::isUpperCase;
        //Как составить предикаты, чтобы новый предикат мог возвращать следующие результаты?
        Predicate<Character> predicate = isLetter.and(isUpperCase.negate()) ;
        System.out.println(predicate.test('1')); // false
        System.out.println(predicate.test('3')); // false
        System.out.println(predicate.test('c')); // true
        System.out.println(predicate.test('D')); // false
        System.out.println(predicate.test('e')); // true
        System.out.println(predicate.test('Q')); // false
    }

}

