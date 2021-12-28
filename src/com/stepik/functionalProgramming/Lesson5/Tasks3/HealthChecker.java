package com.stepik.functionalProgramming.Lesson5.Tasks3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Imagine, you are developing software to check health. It gathers the pulse rate of a patient multiple times a day
and periodically checks the data. There are different acceptable ranges for the pulse rate, but in this software,
the range 90-150 bpm is considered as good.
You need to implement the method checkPulseMeasurements that returns true if all pulse measurements are in the
acceptable range. If at least one measurement is outside the range, the method must return false for further analysis.
*/
class HealthChecker {

    public static boolean checkPulseMeasurements(List<Integer> pulseMeasurements) {
        // write your code here
        return pulseMeasurements.stream()
                .allMatch(x -> x >= 90 && x <= 150);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> measurements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(checkPulseMeasurements(measurements));
    }
}