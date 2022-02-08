package org.bo.pattern.decorator2;

import org.bo.pattern.decorator2.decorators.ChocolateDecorator;
import org.bo.pattern.decorator2.decorators.CreamDecorator;
import org.bo.pattern.decorator2.decorators.MilkDecorator;

public class ExampleCoffeeDecorator {

    public static void main(String[] args) {
        Configurable coffee = new Coffee(7, "Coffee Mocha");
        CreamDecorator cream = new CreamDecorator(coffee);
        MilkDecorator milk = new MilkDecorator(cream);
        ChocolateDecorator chocolate = new ChocolateDecorator(milk);

        System.out.println("The price of coffee Mocha is: " + chocolate.getBasePrice());
        System.out.println("The ingredients of coffee Mocha is: " + chocolate.getIngredients());

        Configurable cappuccino = new Coffee(5, "Coffee Capuchin");
        cream = new CreamDecorator(cappuccino);
        milk = new MilkDecorator(cream);

        System.out.println("The price of coffee Cappuccino is: " + milk.getBasePrice());
        System.out.println("The ingredients of coffee Cappuccino is: " + milk.getIngredients());
    }

}
