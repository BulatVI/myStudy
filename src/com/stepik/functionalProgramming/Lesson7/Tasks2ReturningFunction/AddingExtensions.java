package com.stepik.functionalProgramming.Lesson7.Tasks2ReturningFunction;

import java.util.function.*;

/*
Implement the addExtension method that accepts two string predicates and returns a function.
The returning function should accept one argument and return the argument with .xml suffix if the argument matches
the first predicate, .json suffix if the argument matches the second predicate, and the argument itself otherwise.
Here is an example:
Function<String, String> function = addExtension(
        reportName -> reportName.contains("report"),
        logsName -> logsName.contains("logs")
);
String file = function.apply("main_report");
System.out.println(file); // main_report.xml
*/
public class AddingExtensions {

    public static Function<String, String> addExtension(Predicate<String> first, Predicate<String> second) {
        // write your code here
        return x -> {
            if (first.test(x)) return x + ".xml";
            else if (second.test(x)) return x + ".json";
            else return x;
        };
    }

    public static void main(String[] args) {
        Function<String, String> function = addExtension(
                reportName -> reportName.contains("report"),
                logsName -> logsName.contains("logs")
        );
        String file = function.apply("main_report");
        System.out.println(file); // main_report.xml


        //What is the output of the code below?
        BiFunction<String, String, Integer> biFunction = f1(x -> x.equals("Java") ? 1996 : 1985);
        Supplier<String> supplier = f2(biFunction, x -> x + 18);
        String message = supplier.get();

        System.out.println(message);
    }

    public static BiFunction<String, String, Integer> f1(Function<String, Integer> f) {
        return (a, b) -> f.apply(a + b);
    }

    public static Supplier<String> f2(BiFunction<String, String, Integer> f, IntUnaryOperator g) {
        return () -> "Java 8 was released in " + g.applyAsInt(f.apply("Ja", "va"));
    }
}
