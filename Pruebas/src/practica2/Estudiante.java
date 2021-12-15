package practica2;

public class Estudiante {
    private String nombre;
    private String curso;

    public Estudiante(){
        nombre = "";
        curso = "";
    }

    public Estudiante(String nombre, String curso){
        this.nombre = nombre;
        this.curso = curso;
    }

    public Estudiante(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante [curso=" + curso + ", nombre=" + nombre + "]";
    }
}
