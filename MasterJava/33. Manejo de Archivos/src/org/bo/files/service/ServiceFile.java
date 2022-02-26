package org.bo.files.service;

import java.io.*;
import java.util.Scanner;

public class ServiceFile {

    public void createFile(String path) {
        File file = new File(path);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(file))) {
//            if the file exists, we add the next lines
//            FileWriter writer = new FileWriter(file, true);
//            FileWriter writer = new FileWriter(file);
//            Always write on the disk
            buffer.append("Hi what's up bro")
                    .append(", I need more time");
//            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile2(String path) {
        File file = new File(path);
        try (PrintWriter printer = new PrintWriter(new FileWriter(file))) {
//            if the file exists, we add the next lines
//            FileWriter writer = new FileWriter(file, true);
//            FileWriter writer = new FileWriter(file);
//            Always write on the disk
            printer.println("Hi what's up bro");
            printer.println("I need more time");
//            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String path) {
        StringBuilder builder = new StringBuilder();
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String readFile2(String path) {
        StringBuilder builder = new StringBuilder();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                builder.append(scanner.next()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}
