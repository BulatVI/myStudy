package com.stepik.functionalProgramming.Lesson6.Tasks2;

import java.util.Scanner;
import java.util.stream.Stream;

/*Here, you need to implement a method to check if the given word is an isogram that means that no letter
of the alphabet occurs more than once in this word, consecutive or non-consecutive.
To make it easier to come up with a stream-based solution, we give you a hint: the number of unique characters
 in an isogram word is the same as the length of this word.
Sample Input 1:
stream
Sample Output 1:
true
Sample Input 2:
java
Sample Output 2:
false
Sample Input 3:
exclusionary
Sample Output 3:
true*/
class Isogram {

    public static boolean isIsogram(String word) {
        // write your code here
        return  word.chars().distinct().count() == word.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(isIsogram(word));
    }
}
