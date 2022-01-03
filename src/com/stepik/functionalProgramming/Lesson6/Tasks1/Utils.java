package com.stepik.functionalProgramming.Lesson6.Tasks1;

import java.util.stream.Stream;

/*
You need to implement a method named generateUsers that generates the specified number of users.
 A user has an id and an email, and the values of these fields must be unique among the generated users
 (without duplicates), e.g:
1 user1@gmail.com
2 user2@gmail.com
3 user3@gmail.com
If any users have the same id or email, the tests will fail.
Please, apply one of the methods you've learned in this lesson to solve the problem.
*/
final class Utils {

    //test
    public static void main(String[] args) {
        generateUsers(5).forEach(x -> System.out.println(x.getId() + " : " + x.getEmail()));
    }

    private Utils() {
    }

    public static Stream<User> generateUsers(int numberOfUsers) {
        // write your code here
        return Stream.iterate(1, i -> i <= numberOfUsers, i -> i + 1)
                .map(id -> new User(id, String.format("user%s@gmail.com", id)));
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
