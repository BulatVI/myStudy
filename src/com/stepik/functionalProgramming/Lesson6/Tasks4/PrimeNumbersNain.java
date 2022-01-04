package com.stepik.functionalProgramming.Lesson6.Tasks4;

import java.util.stream.LongStream;
/*You need to create a prepared parallel LongStream for filtering prime numbers in the given range
(inclusive both borders). After calling the count() method it should return the count of prime numbers
in the given range. Please, take a look at the template of the method.
The static method NumberUtils.isPrime(someLong) is already declared. It returns true if the passed value
 is prime and false otherwise.*/
public class PrimeNumbersNain {
    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end).parallel().filter(NumberUtils::isPrime);
    }

    static class NumberUtils {
        public static boolean isPrime(long n) {
            return n > 1 && LongStream
                    .rangeClosed(2, n - 1)
                    .noneMatch(divisor -> n % divisor == 0);
        }
    }
}
