package test;

import accesodatos.*;

public class TestInterfaces {
    
    public static void main(String[] args) {
        
        // no podemos crear objetos del tipo Interface
        // IAcceesoDatos datos = new IAcceesoDatos();

        // se ejecuta el metodo del objeto inicializado
        IAcceesoDatos datos = new ImplementacionMySql();
        // datos.actualizar();
        imprimir(datos);

        datos = new ImplementacionOracle();
        // datos.listar();
        imprimir(datos);
    }

    public static void imprimir(IAcceesoDatos datos){

        datos.listar();

    }

}
