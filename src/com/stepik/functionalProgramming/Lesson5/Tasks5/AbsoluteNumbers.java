package com.stepik.functionalProgramming.Lesson5.Tasks5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
There is a program that should print the absolute values of given integer numbers. The program reads the numbers from
 the standard input and must print the result to the standard output (as a single string containing all the numbers).
You need to finish up the program by adding one or more map operations to fulfill the task.
*/
class AbsoluteNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays.stream(scanner.nextLine().split("\\s+")) // Stream<String>
                // add one or more map invocations here
                .map(Integer::parseInt)
                .map(Math::abs)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
