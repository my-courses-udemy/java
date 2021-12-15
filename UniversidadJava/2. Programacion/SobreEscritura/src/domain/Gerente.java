package domain;

public class Gerente extends Empleado{
    
    private String departamento;

    public Gerente(String nombre, double sueldo, String departamento) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    @Override
    public String obtenerDetalles(){
        // podemos solicitar lo q sea llamando al padre con super
        return super.obtenerDetalles() + ", Departamento: " + this.departamento;
    }

}
