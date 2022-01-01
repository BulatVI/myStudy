package com.stepik.functionalProgramming.Lesson5.Tasks5;

import java.util.*;
/*
Your task is to implement a method that calculates the total number of employees with salary >= threshold for all
departments whose code starts with the string "111-" (without ""). Try to apply your knowledge of the Stream API
and especially the flatMap method to provide the implementation.
* */
class EmployeesCounter {

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 15000L),
                        new Employee("Sophia", 22000L),
                        new Employee("John", 20000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("Victor", 25000L)
                ))
        );
        System.out.println(calcNumberOfEmployees(departments, 20_000L));
    }

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        // write your code here
        return departments.stream()
                .filter(dep -> dep.getCode().contains("111-"))
                .flatMap(dep -> dep.getEmployees().stream())
                .filter(empl -> empl.getSalary() >= threshold)
                .count();
    }
}

record Employee(String name, Long salary) {

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

record Department(String name, String code,
                  List<Employee> employees) {

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", employees=" + employees +
                '}';
    }
}
