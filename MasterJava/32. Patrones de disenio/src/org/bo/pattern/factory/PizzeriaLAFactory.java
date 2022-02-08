package org.bo.pattern.factory;

import org.bo.pattern.factory.PizzeriaZoneAbstractFactory;
import org.bo.pattern.factory.ProductPizza;
import org.bo.pattern.factory.product.losangeles.LACheesePizza;
import org.bo.pattern.factory.product.losangeles.LAVegetarianPizza;

public class PizzeriaLAFactory extends PizzeriaZoneAbstractFactory {
    @Override
    protected ProductPizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new LACheesePizza();
            case "vegetarian" -> new LAVegetarianPizza();
            default -> null;
        };
    }
}
