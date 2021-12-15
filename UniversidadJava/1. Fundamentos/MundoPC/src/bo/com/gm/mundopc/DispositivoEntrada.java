package bo.com.gm.mundopc;
// ctrl E
public class DispositivoEntrada {

    private String tipoDeEntrada;
    private String tipoMarca;
    
    public DispositivoEntrada(String tipoEntrada, String marca){
        
        this.tipoDeEntrada = tipoEntrada;
        this.tipoMarca = marca;
        
    }

    public String getTipoDeEntrada() {
        return tipoDeEntrada;
    }

    public void setTipoDeEntrada(String tipoDeEntrada) {
        this.tipoDeEntrada = tipoDeEntrada;
    }

    public String getTipoMarca() {
        return tipoMarca;
    }

    public void setTipoMarca(String tipoMarca) {
        this.tipoMarca = tipoMarca;
    }

    @Override
    public String toString() {
        return "DispositivoEntrada{" + "tipoDeEntrada=" + tipoDeEntrada + ", tipoMarca=" + tipoMarca + '}';
    }
    
}
