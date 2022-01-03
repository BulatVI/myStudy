package com.stepik.functionalProgramming.Lesson5.Tasks6;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*Imagine you live in a country that unfortunately has a very high level of economic inflation and some categories
of groceries get significantly more expensive every year.
It is known that every year:
vegetables become 3 times more expensive;
fruits become 4 times more expensive;
dairy groceries become 2 times more expensive.
You just got some groceries from a grocery store and you want to predict the price of your purchase after N years.
The price of each category of groceries (vegetables, fruits, dairy) depends on its price in the previous year.
 You can calculate the price in N years using the following formula:
priceInNYears = initialPrice * pow(times, numberOfYears)
The categories of groceries are presented by the Category enum and the information about groceries is stored
in objects of the Grocery class. You need to implement the method that calculates the total price of a list
of groceries in N years. If the number of years equals to 0, the result must be the same as if we calculate
 the price without inflation.*/
class InflationProblem {

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
        // write your code here
        return groceries.stream()
                .map(grocery -> grocery.getCost() * (long) Math.pow(times(grocery.getCategory()), numberOfYears))
                .reduce(0L, Long::sum);
    }

    private static int times(Category category) {
        if (category == Category.VEGETABLES) return 3;
        else if (category == Category.FRUITS) return 4;
        else if (category == Category.DAIRY) return 2;
        else return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfYears = Integer.parseInt(scanner.nextLine());

        List<Grocery> groceries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine())
                .map(inputLine -> {
                    String[] parts = inputLine.split("\\s+");
                    return new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1]));
                })
                .collect(Collectors.toList());

        long totalPriceInFuture = calculateTotalPriceInFuture(numberOfYears, groceries);

        System.out.println(totalPriceInFuture);
    }
}

enum Category {
    VEGETABLES,
    FRUITS,
    DAIRY
}

class Grocery {
    private final long cost;
    private final Category category;

    // Imagine that this class has some other fields but they are skipped for simplicity

    public Grocery(long cost, Category category) {
        this.cost = cost;
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }
}
