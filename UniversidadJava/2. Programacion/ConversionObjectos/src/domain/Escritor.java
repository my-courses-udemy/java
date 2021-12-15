package domain;

public class Escritor extends Empleado {
    
    final TipoEscritura tipoEscritura;
    
    public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura) {
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", tipo de escritura: " + tipoEscritura.getDescripcion();
    }

    public TipoEscritura getTipoEscritura(){
        return this.tipoEscritura;
    }

    @Override
    public String toString() {
        return "Escritor [tipoEscritura=" + tipoEscritura + "]" + " " + super.toString();
    }

}
