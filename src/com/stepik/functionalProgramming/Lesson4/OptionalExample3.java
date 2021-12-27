package com.stepik.functionalProgramming.Lesson4;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
Implement a method that finds a user by a specified account id.
If the user's account type is "pro", the method should print a user's login.
Note that you can copy the findUserByAccountId(Set<User> users, String id) method implemented previously.
*/
public class OptionalExample3 {
    public static void main(String[] args) {
        PrintLoginQuiz.printLoginIfPro(new HashSet<>(), "fd");

    }
}

class PrintLoginQuiz {

    public static void printLoginIfPro(Set<User3> users, String id) {
        // write your code here
        Optional<User3> user = users.stream()
                .filter(x -> x.getAccount().orElseThrow().getId().equals(id)
                        && x.getAccount().orElseThrow().getType().equals("pro"))
                .findAny();
        user.ifPresent(x -> System.out.println(x.getLogin()));

    }
}

class Account3 {
    private String id;
    private String type;

    public Account3(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

class User3 {
    private String login;
    private Account3 account;

    public User3(String login, Account3 account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account3> getAccount() {
        return Optional.ofNullable(account);
    }
}
