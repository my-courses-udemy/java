package org.shuanacu.api.stream.examples;

import org.shuanacu.api.stream.examples.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ExampleStreamParallel {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Andres", "Guzman"));
        list.add(new User("Luci", "Martinez"));
        list.add(new User("Pepe", "Fernandez"));
        list.add(new User("Cata", "Perez"));
        list.add(new User("Lalo", "Mena"));
        list.add(new User("Ezequiel", "Doe"));
        list.add(new User("Bruce", "Lee"));
        list.add(new User("Bruce", "Wilson"));

        long time1 = System.currentTimeMillis();
        String result = list.stream()
                .parallel()
                .map(user -> user.toString().toUpperCase())
                .peek(nameUser -> System.out.println("Thread name: " + Thread.currentThread().getName() + " - " + nameUser))
                .flatMap(name -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (name.contains("bruce".toUpperCase())) {
                        return Stream.of(name);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long time2 = System.currentTimeMillis();
        System.out.println("Total time: " + (time2 - time1));
        System.out.println(result);
    }

}
