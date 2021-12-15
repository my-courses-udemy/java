package accesodatos;

public class ImplementacionOracle implements IAcceesoDatos {

    // debemos usar todos sus metodos
    @Override
    public void insertar() {
        System.out.println("insertar en oracle");
        
    }

    @Override
    public void listar() {
        System.out.println("listar en oracle");

    }

    @Override
    public void actualizar() {
        System.out.println("actualizar en oracle");

    }

    @Override
    public void eliminar() {
        System.out.println("eliminar en oracle");

    }

}
