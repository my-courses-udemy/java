package org.bo.pattern.decorator2.decorators;

import org.bo.pattern.decorator2.Configurable;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice() + 3.7f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + ", Milk";
    }
}
