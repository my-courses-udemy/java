package org.bo.pattern.composite.example;

import org.bo.pattern.composite.Directory;
import org.bo.pattern.composite.File;

public class ExampleComposite {

    public static void main(String[] args) {
        Directory directory = new Directory("Documentos");
        Directory java = new Directory("Java");

        java.addComponent(new File("pattern-composite.docx"));
        Directory stream = new Directory("Api Stream");
        stream.addComponent(new File("Stream-map.docx"));

        java.addComponent(stream);

        directory.addComponent(java);
        directory.addComponent(new File("CV.docx"));
        directory.addComponent(new File("Logo.jpg"));

        System.out.println(directory.show(0));

    }

}
