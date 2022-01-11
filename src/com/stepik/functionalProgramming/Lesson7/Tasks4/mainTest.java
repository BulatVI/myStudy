package com.stepik.functionalProgramming.Lesson7.Tasks4;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class mainTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> List.of("Run", "Debug", "Build", "Cancel")) // line A
                .thenApply(actions -> CompletableFuture.supplyAsync(() -> actions.subList(0, 2))) // line B
                .thenCompose(Function.identity())
                .thenApply(List::size); // line C
    }
}
