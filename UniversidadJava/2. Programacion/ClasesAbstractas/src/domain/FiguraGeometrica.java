package domain;

public abstract class FiguraGeometrica {
    
    protected String tipoFigura;

    protected FiguraGeometrica(String tipoFigura){
        this.tipoFigura = tipoFigura;
    }

    // un metodo abstracto no devuelve nada, solo sera usado por sus hijos de distintas formas
    public abstract void dibujar(); 
    
    public String getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica [tipoFigura=" + tipoFigura + "]";
    }

}
