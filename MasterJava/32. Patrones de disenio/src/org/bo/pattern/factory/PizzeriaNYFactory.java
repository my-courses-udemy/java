package org.bo.pattern.factory;

import org.bo.pattern.factory.product.newyork.NYItalianPizza;
import org.bo.pattern.factory.product.newyork.NYPepperoniPizza;
import org.bo.pattern.factory.product.newyork.VegetarianNYPizza;

public class PizzeriaNYFactory extends PizzeriaZoneAbstractFactory {
    @Override
    protected ProductPizza createPizza(String type) {
        return switch (type) {
            case "vegetarian" -> new VegetarianNYPizza();
            case "pepperoni" -> new NYPepperoniPizza();
            case "italian" -> new NYItalianPizza();
            default -> null;
        };
    }
}
