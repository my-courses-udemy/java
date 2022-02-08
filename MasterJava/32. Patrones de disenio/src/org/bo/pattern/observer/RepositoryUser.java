package org.bo.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class RepositoryUser extends Observable {

    private List<String> repository = new ArrayList<>();

    public void createUser(String user) {
        repository.add(user);
        notifyObserver(user);
    }

}
