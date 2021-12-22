package com.stepik.functionalProgramming.Lesson4;

import java.util.*;

/*
To solve this problem, you need to implement two methods of the PhoneBook class.
The addNewPhoneNumbers method should add given phone numbers to the list of the numbers for a specified person
by the name. If the name is not yet in the phonebook, then it must appear in it with the given numbers.
the printPhoneBook should print all numbers with their types for each name in the phonebook.
The output example is presented below the example.
*/
public class PhonebookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.WORK, "34535")));

        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }
}

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        // write your code here
        /*if (nameToPhoneNumbersMap.get(name) == null) {
            nameToPhoneNumbersMap.put(name, new ArrayList<>(numbers));
        } else {
            nameToPhoneNumbersMap.get(name).addAll(new ArrayList<>(numbers));
        }*/
        nameToPhoneNumbersMap.merge(name, new ArrayList<>(numbers) , (t, y) -> {
            t.addAll(y);
            return t;
        });
    }

    public void printPhoneBook() {
        // write your code here
        nameToPhoneNumbersMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(t -> System.out.println(t.getType() + ": " + t.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
