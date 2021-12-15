package practica;

public class Cuenta {
    private Persona titular;
    private double cantidad;

    public Cuenta(){
        titular = new Persona();
        cantidad = 0;
    }

    public Cuenta(Persona titular){
        this.titular = titular;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void ingresarCantidad(double cantidad){
        if (cantidad > 0) {
            this.cantidad = this.cantidad + cantidad;
        } else {
            System.out.println("No existe esa cantidad");
        }
    }

    public void retirar(double cantidad){
        if (this.cantidad >= cantidad) {
            this.cantidad = this.cantidad - cantidad;
        } else {
            System.out.println("No puede sacar ese monto");
        }
    }

    public String mostrar() {
        return "Cuenta [cantidad=" + cantidad + ", titular=" + titular.mostrar() + "]";
    }


    
}
