package com.stepik.functionalProgramming.Lesson5;

import java.util.*;
import java.util.stream.Collectors;

/*You need to implement the findMaxEvenNumber method to find the maximum number that is divisible by 2 (even).
The method should return the found number or 0 if the stream doesn't contain any even numbers.
Sample Input:
40 81 27 86 79
Sample Output:
86
*/
class MaxEvenNumber {

    public static int findMaxEvenNumber(Collection<Integer> numbers) {
        // write your code here
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .max(Comparator.comparingInt(x -> x))
                //.max(Comparator.naturalOrder())
                .orElse(0);
    }

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(40, 81, 27, 86, 79);
        /*
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());*/

        System.out.println(findMaxEvenNumber(numbers));
    }
}
