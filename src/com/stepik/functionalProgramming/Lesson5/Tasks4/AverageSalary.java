package com.stepik.functionalProgramming.Lesson5.Tasks4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
Imagine you have a list of employees. Each employee has a name and a salary (in abstract units). You need to implement
the averageSalary method to return the average salary of all employees from the list as a double value.
If the given list is empty, the result must be zero.
Sample Input:
John 5000
Alise 6000
Sonya 3000
Chester 4000
Sample Output:
4500.0
*/
class AverageSalary {

    public static double averageSalary(List<Employee> employees) {
        // write your code here
        return employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
       /* List<Employee> employees = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine().split("\\s+"))
                .map(parts -> new Employee(parts[0], Long.parseLong(parts[1])))
                .toList();*/

        System.out.println(averageSalary(employees));
    }
}

class Employee {
    private final String name;
    private final long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }
}
