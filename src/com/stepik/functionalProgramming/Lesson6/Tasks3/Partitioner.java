package com.stepik.functionalProgramming.Lesson6.Tasks3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
Complete the getPartition method that produces two partitions: free applications and paid ones. The partitions
should be organized into a Map that contains free application by the true key and paid ones by the false key.
*/
class Partitioner {

    public static Map<Boolean, List<Application>> getPartition(List<Application> applications) {   /* specify returning type here */
        // write your code
        return applications.stream()
                .collect(Collectors.partitioningBy(Application::isFree));
    }

    //Каков результат приведенного ниже кода?
    public static void main(String[] args) {
        List<List<String>> values = List.of(
                List.of("1", "2", "3"),
                List.of("green", "yellow", "blue", "red"),
                List.of("g10", "g11", "g12", "g13"),
                List.of("group captain", "general", "major", "admiral")
        );

        Map<Boolean, Long> map = values.stream()
                .filter((List<String> l) -> l.size() > 3)
                .collect(Collectors.groupingBy((List<String> s) -> s.get(0).length() < 4, Collectors.flatMapping(
                        (List<String> l) -> l.stream().filter((String v) -> v.contains("g")),
                        Collectors.counting()
                )));
        System.out.println(map);
    }
}
/*
In this exercise, you need to implement a function that accepts a list of words and groups them by their length.
Sample Input:
Java stream main util int
Sample Output:
{3=[int], 4=[Java, main, util], 6=[stream]}
*/

class Classifier {

    public static Map<Integer, List<String>> group(List<String> words) {
        // write your code here
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }
}

class Application {
    private final String name;
    private final boolean isFree;

    public Application(String name, boolean isFree) {
        this.name = name;
        this.isFree = isFree;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }
}
