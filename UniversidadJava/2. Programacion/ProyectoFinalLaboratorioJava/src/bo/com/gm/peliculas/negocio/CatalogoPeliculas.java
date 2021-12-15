package bo.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {

    String NOMBRE_RECURSO = "Peliculas.txt";
    
    public void agregarPelicula(String nombrePelicula);

    public void listarPeliculas();

    public void buscarPelicula(String buscar);

    public void iniciarCatalogoPeliculas();

}
