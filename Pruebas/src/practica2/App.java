package practica2;

public class App {
    
    public static void main(String[] args) {
        
        Estudiante estudiante = new Estudiante();
        System.out.println(estudiante);
        estudiante.setNombre("Isa");
        System.out.println(estudiante);
        estudiante.setCurso("Universidad");
        // estudiante.setNombre("Santi");
        System.out.println(estudiante);

        Estudiante estudiante2 = new Estudiante("Isa", "Universidad");
        System.out.println(estudiante2);

        Estudiante estudiante3 = new Estudiante("Isa");


    }

}
