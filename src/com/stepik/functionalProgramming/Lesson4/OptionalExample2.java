package com.stepik.functionalProgramming.Lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
Implement a method findUserByAccountId(Set<User> users, String id) that returns Optional<User> from a given
set of users. If the user with a specified account id exists, the method should return the Optional<User>
that encapsulates the found user, otherwise it should return the Optional.empty.
* */

public class OptionalExample2 {
    public static void main(String[] args) {
        System.out.println(FindUserQuiz.findUserByAccountId(new HashSet<>(), "fd"));
    }
}

class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        // write your code here
        return users.stream().filter(x -> x.getAccount().orElseThrow().getId().equals(id)).findAny();
        /*
        return users.stream()
            .filter(user -> user.getAccount()
                     .map(Account::getId)
                     .filter(id::equals)
                     .isPresent())
            .findAny();
            */
        /*
        return users.stream()
            .filter(user -> user.getAccount().map(Account::getId).orElse("").equals(id))
            .findFirst();
        * */
    }
}

class Account {
    private final String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class User {
    private final String login;
    private final Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }
}