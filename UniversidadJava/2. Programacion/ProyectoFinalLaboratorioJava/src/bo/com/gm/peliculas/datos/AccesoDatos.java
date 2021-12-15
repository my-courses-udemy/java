package bo.com.gm.peliculas.datos;

import bo.com.gm.peliculas.domain.Pelicula;
import bo.com.gm.peliculas.excepciones.AccesoDatosEx;
import bo.com.gm.peliculas.excepciones.EscrituraDatosEx;
import bo.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    public void crear(String nombreArchivo) throws AccesoDatosEx;

    public void borrar(String nombreArchivo) throws AccesoDatosEx;

}
