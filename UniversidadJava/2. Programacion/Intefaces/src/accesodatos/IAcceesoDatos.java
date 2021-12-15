package accesodatos;

// las interfaces se crean con una I al principio para decir q es interface
// las interfaces a diferencia de clases abstractas va mas por comportamineto
public interface IAcceesoDatos {
    
    // los atributos son constantes, el compilador agrega "public static final" por nosotros
    int MAX_REGISTROS = 10;

    // el compilador agrega "public abstract" por nosotros
    void insertar();

    void listar();

    void actualizar();

    void eliminar();

}
