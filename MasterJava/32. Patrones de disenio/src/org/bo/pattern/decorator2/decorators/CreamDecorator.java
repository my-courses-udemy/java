package org.bo.pattern.decorator2.decorators;

import org.bo.pattern.decorator2.Configurable;

public class CreamDecorator extends CoffeeDecorator{
    public CreamDecorator(Configurable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice() + 2.5f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + ", Cream";
    }
}
