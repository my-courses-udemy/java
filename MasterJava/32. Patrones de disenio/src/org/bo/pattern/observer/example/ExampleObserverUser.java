package org.bo.pattern.observer.example;

import org.bo.pattern.observer.RepositoryUser;

public class ExampleObserverUser {

    public static void main(String[] args) {
        RepositoryUser repositoryUser = new RepositoryUser();
        repositoryUser.addObserver((observable, object) -> System.out.println("Sending email to user " + object));
        repositoryUser.addObserver((observable, object) -> System.out.println("Sending email to admin"));
        repositoryUser.addObserver((observable, object) -> System.out.println("Saving new user " + object));
        repositoryUser.createUser("Andres");
    }

}
