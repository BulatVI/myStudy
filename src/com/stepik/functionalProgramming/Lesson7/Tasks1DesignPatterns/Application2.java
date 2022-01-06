package com.stepik.functionalProgramming.Lesson7.Tasks1DesignPatterns;

// create NotificationStrategy interface and Notifier class here

@FunctionalInterface
interface NotificationStrategy{
    public void notifyCustomer(User user);
}
class Notifier{
    private NotificationStrategy notificationStrategy;

    public Notifier(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }
    public void notify(User user) {
        if (user == null) {
            throw new IllegalArgumentException("No user to notify");
        }
        notificationStrategy.notifyCustomer(user);
    }
}

class Application {

    private EmailService emailService;
    private SMSService smsService;

    public Application(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void run(User user) {
        // write your code here

        // write your code here
        Notifier notifier = new Notifier(user1 -> emailService.sendEmail(user1));
        notifier.notify(user);
        notifier.setNotificationStrategy(user1 -> smsService.sendSMS(user1));
        notifier.notify(user);

    }
}

class User {
    private final String email;
    private final String phoneNumber;

    User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

@FunctionalInterface
interface SMSService {
    void sendSMS(User user);
}

@FunctionalInterface
interface EmailService {
    void sendEmail(User user);
}
