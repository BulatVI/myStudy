package com.stepik.functionalProgramming.Lesson4;

import java.util.Optional;

/*
For the class Rocket, create a getter method that returns Optional<NavigationModule>.
Please take into account that the navigationModule can be null.
* */
public class OptionalsExample {
    public static void main(String[] args) {
        Optional<String> title = null;      //null
        Optional<Long> number = Optional.empty();       //Optional<Long>.empty
        String version = null;
        Optional<String> initBatteryVersion = Optional.ofNullable(version);  //Optional<String>.empty
        version = "T1000";
        Optional<String> batteryVersion = Optional.of(version);      //Optional<String>["T1000"]
    }
}
class Rocket {
    private final NavigationModule navigationModule;

    public Rocket(NavigationModule navigationModule) {
        this.navigationModule = navigationModule;
    }

    public Optional<NavigationModule> getNavigationModule() {
        // write your code here
        return Optional.ofNullable(navigationModule);
    }
}

class NavigationModule {
    private final String title;

    public NavigationModule(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
