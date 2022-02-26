package org.bo.files.examples;

import org.bo.files.service.ServiceFile;

public class ExampleFileCreation {

    public static void main(String[] args) {
        String path = "src/org/bo/files/file/example.txt";
        ServiceFile serviceFile = new ServiceFile();
//        serviceFile.createFile(path);
        serviceFile.createFile2(path);

    }

}
