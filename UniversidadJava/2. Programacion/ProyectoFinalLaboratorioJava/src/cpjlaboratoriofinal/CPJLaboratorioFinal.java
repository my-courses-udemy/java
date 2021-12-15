package cpjlaboratoriofinal;

import java.util.Scanner;

import bo.com.gm.peliculas.negocio.CatalogoPeliculas;
import bo.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {
    
    public static void main(String[] args) {
        
        var opcion = -1;
        var scanner = new Scanner(System.in);

        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while(opcion != 0){
            System.out.println("Elige una opcion: \n"
                + "1. Iniciar catalogo de peliculas\n"
                + "2. Agregar pelicula\n"
                + "3. Listar peliculas\n"
                + "4. Buscar Pelicula\n"
                + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduzca el nombre de una pelicula");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta Pronto!!!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
        scanner.close();

    }

}
