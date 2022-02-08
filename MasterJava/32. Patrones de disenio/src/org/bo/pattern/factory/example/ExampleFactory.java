package org.bo.pattern.factory.example;

import org.bo.pattern.factory.PizzeriaLAFactory;
import org.bo.pattern.factory.PizzeriaNYFactory;
import org.bo.pattern.factory.PizzeriaZoneAbstractFactory;
import org.bo.pattern.factory.ProductPizza;

public class ExampleFactory {

    public static void main(String[] args) {
        PizzeriaZoneAbstractFactory newYork = new PizzeriaNYFactory();
        PizzeriaZoneAbstractFactory losAngeles = new PizzeriaLAFactory();

        ProductPizza pizza = losAngeles.orderPizza("vegetarian");
        System.out.println("pizza = " + pizza);
        
        pizza = newYork.orderPizza("pepperoni");
        System.out.println("pizza = " + pizza);

        pizza = newYork.orderPizza("vegetarian");
        System.out.println("pizza = " + pizza);
    }

}
