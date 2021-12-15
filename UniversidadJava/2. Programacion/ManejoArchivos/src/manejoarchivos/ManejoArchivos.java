package manejoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo){

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();// se crea el archivo en nuestro disco duro
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }

    }

    public static void escribirArchivos(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();// se crea el archivo en nuestro disco duro
            System.out.println("Se ha escrito al archivo");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }
    }

    public static void anexarInformacion(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            // con true, decimos q continue escribiendo sobre el archivo
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();// se crea el archivo en nuestro disco duro
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        try {
            // BufferedReader sirve para leer lineas completas de un archivo
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while(lectura != null){
                System.out.println("lectura = " + lectura);
                lectura  = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }
    }
    
}