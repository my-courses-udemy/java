package org.bo.pattern.factory.product.newyork;

import org.bo.pattern.factory.ProductPizza;

public class NYPepperoniPizza extends ProductPizza {

    public NYPepperoniPizza() {
        super();
        name = "New York Pepperoni Pizza";
        dough = "Thin stone-backed dough";
        sauce = "Tomato sauce";
        ingredients.add("Cheese");
        ingredients.add("Extra pepperoni");
        ingredients.add("Olives");
    }

    @Override
    public void cook() {
        System.out.println("Cooking for 40 minutes, at 40ºC");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into triangles");
    }
}
