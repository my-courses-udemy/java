package test;

// debemos importarlo estaticante
import static manejoarchivos.ManejoArchivos.*;

public class TestManejoArchivos {
    
    public static void main(String[] args) {
        
        // en linux: "SANTIAGO/java/...."
        var nombreArchivo = "Prueba.txt";
        // crearArchivo(nombreArchivo);
        // escribirArchivos(nombreArchivo, "Hello from Java");
        // escribirArchivos(nombreArchivo, "Adios desde Java");
        // anexarInformacion(nombreArchivo, "Hello from Java");
        // anexarInformacion(nombreArchivo, "Adios desde Java");
        leerArchivo(nombreArchivo);

    }

}
