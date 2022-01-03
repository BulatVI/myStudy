package com.stepik.functionalProgramming.Lesson5.Tasks6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/*
Here you need to implement the sumOfAbsoluteNumbers method to calculate the sum of long numbers regardless their sign.
Pay attention that here you work with the long type.
Sample Input 1:
7 3 -5 2
Sample Output 1:
17
Sample Input 2:
-1 -2 -3
Sample Output 2:
6
Sample Input 3:
-10
Sample Output 3:
10
*/

class AbsoluteSum {

    public static long sumOfAbsoluteNumbers(Collection<Long> numbers) {
        // write your code here
        return numbers.stream().reduce(0L, (x, y) -> Math.abs(x) + Math.abs(y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Long> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .toList();

        System.out.println(sumOfAbsoluteNumbers(numbers));
    }
}
