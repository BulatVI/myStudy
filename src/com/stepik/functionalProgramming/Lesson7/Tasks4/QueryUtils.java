package com.stepik.functionalProgramming.Lesson7.Tasks4;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
/*
In this problem, you have a method named execute that should execute the given query represented as a function for
each database table in parallel using the CompletableFuture class. This method returns a Map<String, R> that contains
the query results for all the given tables. Unfortunately, it doesn't work as expected and you need to fix it.
-the method must wait until all the CompletableFuture objects are completed and then return the map;
-if there has been an exception in the query, the specified defaultValue must be put in the map for a particular table.
You don't need to rewrite the whole method, you just need to find a few places and fix them according to the last
knowledge you got in this and previous lessons.
*/
class QueryUtils {

    public static <R> Map<String, R> execute(List<String> tables, Function<String, R> query, R defaultValue) {
        Map<String, R> tableToResultMap = new ConcurrentHashMap<>();

        CompletableFuture<?>[] futures = tables.stream()
                .map(table -> CompletableFuture
                        .supplyAsync(() -> tableToResultMap.put(table, query.apply(table))))
                .toArray(value -> new CompletableFuture[value]);

        CompletableFuture.anyOf(futures).join();

        return tableToResultMap;
    }

    public static void main(String[] args) {
        execute(List.of("table1", "table2"), table -> {
            if (table.equals("table1")) {
                return 2;
            } else {
                throw new RuntimeException("Exception");
            }
        }, 5).forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
