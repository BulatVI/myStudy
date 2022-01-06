package com.stepik.functionalProgramming.Lesson6.Tasks4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Spliterator;

/*
Here is a program that reads unordered numbers from the standard input,  sorts and then multiplies by two.
Unfortunately, the sorting order is not preserved when displaying numbers. You should fix it any way you know!
Sample Input:
4 2 3 0 1
Sample Output:
0
2
4
6
8
*/
class NumbersProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted()
                .map(n -> n * 2)

                .forEach(System.out::println);
        //.forEachOrdered(System.out::println);

    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted()
                .map(n -> n * 2)
                .parallel()
                .forEach(System.out::println);
    }*/




}
