package org.bo.files.examples;

import org.bo.files.service.ServiceFile;

public class ExampleReadLine {

    public static void main(String[] args) {
        String path = "src/org/bo/files/file/example.txt";
        ServiceFile serviceFile = new ServiceFile();
//        System.out.println(serviceFile.readFile(path));
        System.out.println(serviceFile.readFile2(path));
    }

}
