package com.stepik.functionalProgramming.Lesson4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
Here, the owner field stores the name of the account's owner, and the locked flag determines if the account is locked / disabled.
Now you need to support an ability to sort accounts by their locked flag, balance and the name of the owner.
After sorting, non-blocked accounts should be placed before the blocked ones and they must be sorted by balance
in descending order. If the balances are the same, the accounts must also be sorted by owner name in lexicographic order.
To support this sorting mechanism, just implement the getComparatorByLockedBalanceAndOwner method by returning
an appropriate comparator.
 */
public class SortingMain {
    public static void main(String[] args) {
        List<Account1> accounts = new ArrayList<>();
        accounts.add(new Account1("Peter", 1000L, false));
        accounts.add(new Account1("John", 1000L, false));
        accounts.add(new Account1("Ivan", 8000L, true));
        accounts.add(new Account1("Helen", 5000L, false));
        accounts.add(new Account1("Nicole", 3000L, true));

        accounts.sort(Account1.getComparatorByLockedBalanceAndOwner());
        accounts.forEach(System.out::println);
        /*
        Helen 5000 false
        John 1000 false
        Peter 1000 false
        Ivan 8000 true
        Nicole 3000 true
        */
    }
}

class Account1 {
    private final String owner;
    private final long balance;
    private final boolean locked;

    Account1(String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    public static Comparator<Account1> getComparatorByLockedBalanceAndOwner() {
        // write your code here
        return  Comparator.comparing(Account1::isLocked )
                .thenComparing(Account1::getBalance, Comparator.reverseOrder())
                .thenComparing(Account1::getOwner);
    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return owner + " " + balance + " " + locked;
    }
}