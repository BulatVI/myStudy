package com.stepik.functionalProgramming.Lesson6.Tasks2;

import java.util.Arrays;
import java.util.Scanner;
/*
The task here is pretty simple. You need to implement the sum method that calculates the sum of the given array of long's.
Please, use a primitive type stream to solve this task.
Sample Input:
3 1 2
Sample Output:
6
*/
class SumOfNumbers {

    public static long sum(long[] numbers) {
        // write your code here
        return Arrays.stream(numbers).sum();
        //return LongStream.of(numbers).sum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(sum(numbers));
    }
}
