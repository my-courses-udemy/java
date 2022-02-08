package org.bo.pattern.factory.product.losangeles;

import org.bo.pattern.factory.ProductPizza;

public class LACheesePizza extends ProductPizza {

    public LACheesePizza() {
        super();
        name = "LA Cheese Pizza";
        dough = "Thin stone baked dough";
        sauce = "Tomato sauce";
        ingredients.add("Extra mozzarella cheese");
        ingredients.add("Onion");
        ingredients.add("Tomato");
    }

    @Override
    public void cook() {
        System.out.println("Cooking for 20 minutes, at 100ºC");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into small triangles");
    }
}
