package bo.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import bo.com.gm.peliculas.domain.Pelicula;
import bo.com.gm.peliculas.excepciones.AccesoDatosEx;
import bo.com.gm.peliculas.excepciones.EscrituraDatosEx;
import bo.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File file = new File(nombreArchivo);
        return file.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File file = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        BufferedReader entrada;
        try {
            entrada = new BufferedReader(new FileReader(file));
            String lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula pelicula = new Pelicula(lectura);
                peliculas.add(pelicula);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion en listar peliculas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion en listar peliculas: " + e.getMessage());
        }
        
        return peliculas;
    }
    
    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        
        File file = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(file, anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo " + pelicula );
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepcion en listar peliculas: " + e.getMessage());
        }

    }
    
    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File file = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(file));
            String lectura = entrada.readLine();
            int indice = 1;
            while (lectura != null) {
                if(buscar != null && buscar.equalsIgnoreCase(lectura)){
                    resultado = "Pelicula " + lectura + " encontrada en la posicion " + indice;
                    break; // para romper el ciclo while
                }
                lectura = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion en listar peliculas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion en listar peliculas: " + e.getMessage());
        }
        
        return resultado;
    }
    
    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File file = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(file);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear Archivo: " + e.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File file = new File(nombreArchivo);
        if(file.exists())
            file.delete();
        System.out.println("Se ha borrado el archivo " + nombreArchivo);
    }

}
