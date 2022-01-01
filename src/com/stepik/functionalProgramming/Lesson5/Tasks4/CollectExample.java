package com.stepik.functionalProgramming.Lesson5.Tasks4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExample {
    public static void main(String[] args) {
        List<String> mostPopulatedCities = Stream
                .of("Tokyo", "Delhi", "Seoul", "Shanghai")
                .collect(
//                        Collectors.toModifiableList()            //
                        Collectors.toCollection(ArrayList::new)    //    ok
//                        Collectors.toCollection()                //
//                        Collectors.toList()                      //    ok
//                        Collectors.toArrayList()                 //
//                        Collectors.toUnmodifiableList()          //    ok
                );


        List<Integer> numbers = List.of(4, 7, 4, 2, 1, 6, 4);
        System.out.println(numbers.stream().filter(n -> n == 4).count()                          );
        System.out.println(numbers.stream().collect(Collectors.summingInt(i -> i + 4))           );
        System.out.println(numbers.stream().filter(n -> n == 4).collect(Collectors.counting())   );
        System.out.println(Collections.frequency(numbers, 4)                                     );
        //System.out.println(numbers.stream().collect(Collectors.counting(n -> n == 4))            );
    }
}
