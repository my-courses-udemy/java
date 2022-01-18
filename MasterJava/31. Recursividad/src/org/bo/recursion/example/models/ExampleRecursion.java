package org.bo.recursion.example.models;

import java.util.stream.Stream;

public class ExampleRecursion {

    public static void main(String[] args) {
        Component pc = new Component("PC Cabinet ATX");
        Component power = new Component("Power supply 800w");
        Component motherBoard = new Component("Mainbord ASUS sockets AMD");
        Component cpu = new Component("AMD Ryzen 5 2700");
        Component fan = new Component("Fan CPU");
        Component heatSink = new Component("Heat Sink");
        Component videoCard = new Component("Nvidia RTX 3080");
        Component gpu = new Component("Nvidia GPU RTX");
        Component gpuRam = new Component("4GB Ram");
        Component gpuRam2 = new Component("4GB Ram");
        Component gpuFan = new Component("Fans");
        Component ram = new Component("Ram 32GB");
        Component ssd = new Component("SSd 3TB");

        cpu.addComponent(fan).addComponent(heatSink);

        videoCard.addComponent(gpu)
                .addComponent(gpuRam)
                .addComponent(gpuRam2)
                .addComponent(gpuFan);

        motherBoard.addComponent(cpu)
                .addComponent(videoCard)
                .addComponent(ram)
                .addComponent(ssd);

        pc.addComponent(power)
                .addComponent(motherBoard)
                .addComponent(new Component("Keyboard"))
                .addComponent(new Component("Mouse"));

        recursionJava8(pc, 0)
                .forEach(component -> System.out.println("\t".repeat(component.getLevel()) + component.getName()));
    }

    public static void recursion(Component component, int level) {
        System.out.println("\t".repeat(level) + component.getName());
        if (component.hasChildren()) {
            for (Component child : component.getChildren()) {
                recursion(child, level + 1);
            }
        }
    }

    public static Stream<Component> recursionJava8(Component component, int level) {
        component.setLevel(level);
        return Stream.concat(Stream.of(component),
                component.getChildren().stream()
                        .flatMap(child -> recursionJava8(child, level + 1)));
    }

}