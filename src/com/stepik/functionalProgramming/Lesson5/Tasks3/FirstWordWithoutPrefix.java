package com.stepik.functionalProgramming.Lesson5.Tasks3;

import java.util.*;
import java.util.stream.Collectors;

/*
Here you need to implement a method named printFirstWordWithoutPrefix that takes a list of words and a prefix
 and prints the first word that doesn't start from the prefix. If the suitable word is not found,
  the method shouldn't print anything.
Sample Input:
bitcoin bitrix bytecode bingo
bit
Sample Output:
bytecode
*/
class FirstWordWithoutPrefix {

    public static void printFirstWordWithoutPrefix(List<String> words, String prefix) {
        // write your code here
        words.stream()
                .filter(x -> !x.toLowerCase().contains(prefix.toLowerCase()))
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Set<String> companies = Set.of("Google", "JetBrains", "Miro", "Oracle", "Atlassian");
        //Which ones of the following stream pipelines return true?
        System.out.println(companies.stream().anyMatch(company -> company.startsWith("J")));
        System.out.println(companies.stream().noneMatch(company -> company.contains("Py")));
        System.out.println(companies.stream().noneMatch(company -> company.endsWith("e")));
        System.out.println(companies.stream().allMatch(company -> company.length() > "Java".length()));

        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String prefix = scanner.nextLine();

        printFirstWordWithoutPrefix(words, prefix);
    }
}
