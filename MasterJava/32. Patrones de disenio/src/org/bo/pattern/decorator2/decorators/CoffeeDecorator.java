package org.bo.pattern.decorator2.decorators;

import org.bo.pattern.decorator2.Configurable;

public abstract class CoffeeDecorator implements Configurable {

    protected Configurable coffee;

    public CoffeeDecorator(Configurable coffee) {
        this.coffee = coffee;
    }

}
