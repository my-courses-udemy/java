package org.bo.pattern.factory;

public abstract class PizzeriaZoneAbstractFactory {

    public ProductPizza orderPizza(String type) {
        ProductPizza pizza = createPizza(type);
        System.out.println("--------Building the pizza " + pizza.getName() + "--------");
        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.packaging();
        return pizza;
    }

    protected abstract ProductPizza createPizza(String type);

}
