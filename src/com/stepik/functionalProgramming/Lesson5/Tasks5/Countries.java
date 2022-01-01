package com.stepik.functionalProgramming.Lesson5.Tasks5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Here you need to implement the getNamesOfTop3PopulatedCountries to return a list that contains three country names
which have the largest populations from all countries of the original collection. The names must be in uppercase
and sorted according to the population size (from the largest to the smallest population).
Sample Input:
Chile 18006000
Colombia 48128000
Brazil 204519000
Peru 33050325
Venezuela 30620000
Mexico 127500000
Sample Output:
BRAZIL
MEXICO
COLOMBIA
*/
class Countries {

    public static List<String> getNamesOfTop3PopulatedCountries(Collection<Country> countries) {
        // write your code here
        return countries.stream()
                .sorted(Comparator.comparing(Country::getPopulation, Comparator.reverseOrder()))
                .limit(3)
                .map(country -> country.getName().toUpperCase())
                .toList();
    }

    public static void main(String[] args) {
        /*List<List<String>> strings = List.of(
                List.of("j", "a", "v", "a"),
                List.of("i", "s"),
                List.of("g", "r", "e", "a", "t")
        );

        Set<String> result = strings.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));*/


        /*Scanner scanner = new Scanner(System.in);

        int max = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1) // iterates over all input lines
                .map(i -> scanner.nextLine())
                // some operations
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);*/


        Scanner scanner = new Scanner(System.in);

        List<Country> countries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(inputLine -> {
                    String[] parts = inputLine.split("\\s+");
                    return new Country(parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());

        getNamesOfTop3PopulatedCountries(countries)
                .forEach(System.out::println);
    }
}

class Country {
    private final String name;
    private final int population;

    Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
