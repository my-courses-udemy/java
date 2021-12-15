package domain;

public class Rectangulo extends FiguraGeometrica {
    
    public Rectangulo(String tipoFigura){
        super(tipoFigura);
    }

    // no es sobreescribir, lo estamos implementando
    @Override
    public void dibujar(){
        // getClass() nos devuelve el tipo de clase
        // getSimpleName() nos devuelve le nombre de la clase
        System.out.println("se imprime un: " + this.getClass().getSimpleName());
    }

}
