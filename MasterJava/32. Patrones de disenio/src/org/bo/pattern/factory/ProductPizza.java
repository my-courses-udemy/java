package org.bo.pattern.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductPizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> ingredients;

    public ProductPizza() {
        this.ingredients = new ArrayList<>();
    }

    public void prepare() {
        System.out.println("Preparing the " + name);
        System.out.println("Selecting the " + dough);
        System.out.println("Adding the " + sauce);
        System.out.println("Adding the ingredients:");
        this.ingredients.forEach(System.out::println);
    }

    public void packaging() {
        System.out.println("Putting the piiza in a packing box");
    }

    public abstract void cook();
    public abstract void cut();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductPizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

}
