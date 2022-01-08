package com.stepik.functionalProgramming.Lesson7.Tasks3Asynchronous;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class test {
    public static void main(String[] args) {
        CompletableFuture<List<String>> actionsFuture =
                CompletableFuture.supplyAsync(() -> List.of("Run", "Debug", "Build", "Cancel"));

        CompletableFuture<Void> printActionsFuture = actionsFuture
                .thenApply(actions -> actions.subList(0, 2)) // line A
                .thenApply(actions -> actions.size()) // line B
                .thenAccept(System.out::println); // line C
    }
}
