package org.bo.pattern.factory.product.losangeles;

import org.bo.pattern.factory.ProductPizza;

public class LAVegetarianPizza extends ProductPizza {

    public LAVegetarianPizza() {
        super();
        name = "LA Vegetarian Pizza";
        dough = "Light thin dough";
        sauce = "Light BBQ sauce";
        ingredients.add("Mozzarella cheese");
        ingredients.add("Olives");
        ingredients.add("Onions");
    }

    @Override
    public void cook() {
        System.out.println("Cooking for 20 minutes, at 180ºC");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into rectangles");
    }
}
