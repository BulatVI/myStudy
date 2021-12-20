package com.stepik.functionalProgramming.Lesson4;

import java.util.Map;

public class CorrectWays {
    public static void main(String[] args) {
        Map<String, String> map = Map.of(
                "Tom Hunter", "0131 128 8144",
                "Layla Graham", "07027296303",
                "Michael Butler", "+44(0)1035 093821"
        );

        map.entrySet().forEach(e -> System.out.println(e.getKey() + "->" + e.getValue()));
        //map.forEach(System.out::println);
        //map.forEach(e -> System.out.println(e.getKey() + "->" + e.getValue()));
        map.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}
