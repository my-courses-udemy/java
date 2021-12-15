package practica2;

public class Colegio {
    private Estudiante estudiante;

    public Colegio(){
        estudiante = new Estudiante();
    }

    public Colegio(Estudiante estudiante){
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
