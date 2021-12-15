package accesodatos;

// usamos la palabra reservada "implements", los obligamos a agregar el comportamiento definido en la Inteface
public class ImplementacionMySql implements IAcceesoDatos {

    @Override
    public void insertar() {
        System.out.println("insertar desde mysql");
        
    }

    @Override
    public void listar() {
        System.out.println("lista en mysql");
        
    }
    
    @Override
    public void actualizar() {
        System.out.println("actualizar en mysql");
        
    }
    
    @Override
    public void eliminar() {
        System.out.println("eliminar en mysql");
        
    }


    
}