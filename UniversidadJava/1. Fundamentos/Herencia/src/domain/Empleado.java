
package domain;

public class Empleado extends Persona {
    
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

//    public Empleado(String nombre, char genero, int edad, String direccion) {
//        super(nombre, genero, edad, direccion); // con super mandamos los argumentos al padre y los guarde
//    }
    
    public Empleado(){
        //super(); llama a su padre, es decir a Persona
        this.idEmpleado = ++Empleado.contadorEmpleado;
    }

    public Empleado(String nombre, double sueldo) {
        
//        super(nombre);
        this();// llamamos al constructor vacio, y no podemos llamar a super en este caso
//        this.idEmpleado = ++Empleado.contadorEmpleado;
        this.nombre = nombre;
        this.sueldo = sueldo;
        
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        // con el atributo super accedemos al metodo toString() del padre
        sb.append(", ").append(super.toString()); // podemos acceder a los atributos del padre
        sb.append("}");
        return sb.toString();
    }
    
}
