package org.bo.pattern.factory.product.newyork;

import org.bo.pattern.factory.ProductPizza;

public class NYItalianPizza extends ProductPizza {

    public NYItalianPizza() {
        super();
        name = "New York Italian Pizza";
        dough = "Large dough";
        sauce = "Tomato italian sauce";
        ingredients.add("Mozzarella cheese");
        ingredients.add("Olives");
        ingredients.add("Ham");
    }

    @Override
    public void cook() {
        System.out.println("Cooking for 30 minutes, at 120ºC");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into big triangles");
    }
}
