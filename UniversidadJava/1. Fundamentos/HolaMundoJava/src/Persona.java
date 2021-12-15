
public class Persona {

    private String nombre;
    private int telefono;
    private boolean voto = false;
    private String cargo;
    
    public Persona(String nombre, int telefono, boolean voto,String cargo){
        this.nombre = nombre;
        this.telefono = telefono;
        this.voto = voto;
        this.cargo = cargo;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getTelefono(){
        return telefono;
    }
    public boolean getVoto(){
        return voto;
    }
    public String getCargo(){
        return cargo;
    }
    
    public void setVoto(boolean voto){
        this.voto = voto;
    }
}
