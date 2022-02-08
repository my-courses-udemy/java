package org.bo.pattern.decorator2.decorators;

import org.bo.pattern.decorator2.Configurable;

public class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice() + 5f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + ", Chocolate";
    }
}
