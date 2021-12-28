package com.stepik.functionalProgramming.Lesson5.Tasks2;

import java.util.List;
import java.util.Scanner;

/**
 * Here you need to implement the printSortedJavaEvents method that takes a list of event titles and must print only
 * the names of Java-related events in the alphabetical order.
 * An event is considered a Java-related if it contains the substring "Java" in the title.
 * It is important that this substring can be written in any case: "java", "Java", "JAVA", etc, and they all must count.
 * <pre>{@code
 * Sample Input:
 * JavaZone
 * KotlinConf
 * java night party | Amsterdam
 * Day of Java
 * PyCon US
 *
 * Sample Output:
 * Day of Java
 * JavaZone
 * java night party | Amsterdam
 * }</pre>
 */
class SearchJavaEvents {

    public static void printSortedJavaEvents(List<String> events) {
        // write your code here
        events.stream()
                .filter(string -> string.toLowerCase().contains("java"))
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> events = List.of("JavaZone", "KotlinConf", "java night party | Amsterdam", "Day of Java", "PyCon US");
                /*List<String> events = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .collect(Collectors.toList());*/

        printSortedJavaEvents(events);
    }
}
