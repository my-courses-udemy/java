package org.bo.pattern.factory.product.newyork;

import org.bo.pattern.factory.ProductPizza;

public class VegetarianNYPizza extends ProductPizza {

    public VegetarianNYPizza() {
        super();
        name = "Vegetarian New York Pizza";
        dough = "Vegetarian whole wheat dough";
        sauce = "Tomato sauce";
        ingredients.add("Vegan cheese");
        ingredients.add("Tomato");
        ingredients.add("Olives");
    }

    @Override
    public void cook() {
        System.out.printf("Cooking for 25 minutes, at 150ºC");
    }

    @Override
    public void cut() {
        System.out.printf("Cutting the pizza into square slices");
    }
}
