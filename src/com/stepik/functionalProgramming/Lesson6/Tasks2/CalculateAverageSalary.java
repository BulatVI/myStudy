package com.stepik.functionalProgramming.Lesson6.Tasks2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Imagine that you need to calculate the average monthly salary in a company. For that purpose, you need to implement
 the calcAverageSalary method that takes a list of salaries and calculates the value. You don't need to round the result here.
This code challenge is also used on the Hyperskill / JetBrains Academy platform.
Sample Input:
4500 5200 3900
Sample Output:
4533.333333333333
*/
class CalculateAverageSalary {

    private static double calcAverageSalary(Collection<Integer> salaries) {
        // write your code here
        return salaries.stream().mapToInt(x -> x).average().orElse(0.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> salaries = scanner.tokens()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(calcAverageSalary(salaries));
    }
}
